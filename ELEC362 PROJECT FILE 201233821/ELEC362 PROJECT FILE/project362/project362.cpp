#include "project362.h"
#include "ui_project362.h"

project362::project362(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::project362)

{
    ui->setupUi(this);

ui->tableView->setEditTriggers(QAbstractItemView::NoEditTriggers);//makes the table view box uneditable

ui->textEdit->setEnabled(false); //makes the text edit box uneditable
ui->textEdit->setStyleSheet("QTextEdit {background-color: #FFFFFF}"); //sets text edit background colour
ui->textEdit->setTextColor(Qt::black);//sets text edit colour

//creates a context menu
ui->graphicsView->setContextMenuPolicy(Qt::CustomContextMenu);
connect(ui->graphicsView, SIGNAL(customContextMenuRequested(QPoint)),
          SLOT(customMenuRequested(QPoint)));

//creates a standard menu item to store varables on the table
csvModel = new QStandardItemModel(this);
}


void project362::LinearSpace(double start, double end, int NumofValues, QVector<double> &data)
{
    double dl=((end+1)-(start-1))/double(NumofValues);

    for (int i=0; i<NumofValues;i++) data.push_back((start)+i*dl);
}


//function checks displays an error message when a file has not been loaded ans the user tries to plot or change graph settings
void project362::IsActionValid()
{
if(InputIsValid==false){
    error_load_file_to_plot->setWindowTitle("Error!");
    error_load_file_to_plot->setIcon(QMessageBox::Critical);
    error_load_file_to_plot->setText("Load a file to implement changes to the scene");
    error_load_file_to_plot->setButtonText(0,"OK");
    error_load_file_to_plot->exec();
    }
}


//an option to change graph settings by right-clicking on the graphic view
void project362::customMenuRequested(QPoint pos)
{
    QMenu *menu=new QMenu(this);
    menu->addAction("Color", this, SLOT(on_ChangeColor_clicked()));
    menu->addAction("Thickness", this, SLOT(on_thickness_clicked()));
    menu->popup(ui->graphicsView->viewport()->mapToGlobal(pos));
}


//function resizes the graph if the window is resized
void project362::resizeEvent(QResizeEvent *e)
{
    if (InputIsValid==true && ui->graphicsView->items().size()>0){
    project362::on_plotGraph_clicked();
    }
}


project362::~project362()
{
    delete ui;

    delete pen;
    delete font;

    delete x_axis;
    delete y_axis;


    delete curve;

    delete scene;

}


//function for when load file is clicked on from the menu bar
void project362::on_Load_File_triggered()
{
     // called when load file is triggered and loads only .csv files
    QString filename=QFileDialog::getOpenFileName(this,tr("Load FIle"),tr("*.csv"));

    /*this if statement prevents the program from crashing, only
     * implements this the user selects a file. the user could decide to click
     * cancel and this prevents the application from crashing
    */
    if(filename!=NULL){

        QFile file(filename);

        file.open(QIODevice::ReadOnly);

        //read text from .csl file
        QTextStream in(&file);

        QString header=(in.readLine()); //ignores firstline

        //variable to store the data from the spreadsheet
        x_csv=new QVector<double>;
        y_csv=new QVector<double>;


        csvModel->clear();//clears the table view if "Load File is called again"

        //creates a new tableview when load file is called again and the previous table is cleared
        csvModel = new QStandardItemModel(this);
        csvModel->setColumnCount(2);
        csvModel->setHorizontalHeaderLabels(QStringList()<<header.split(',').at(0)<<header.split(',').at(1));
        ui->tableView->setModel(csvModel);

        while(!in.atEnd()){
            line=new QString(in.readLine());


            //saves the coulumns in a vector to draw graph later
            x_csv->push_back(line->split(',').at(0).toDouble());
            y_csv->push_back(line->split(',').at(1).toDouble());

            //variable to put the values in a tablee
            QList<QStandardItem *> standardItemList;

            for (QString item: line->split(',')){
                standardItemList.append(new QStandardItem(item));
            }

            csvModel->insertRow(csvModel->rowCount(), standardItemList);
         }

        file.close();

        //sets initial pen width
        pen->setWidth(2);

        //input value is set to true after a file has been loaded which handles the error
        InputIsValid=true;

        //clean up
        delete line;
    }
}



void project362::on_plotGraph_clicked(){

    if(InputIsValid==false){
        IsActionValid();
    }

    else{
        //gets the max value of the x and y column
        qreal xmax=*max_element(x_csv->begin(),x_csv->end());
        qreal ymax=*max_element(y_csv->begin(),y_csv->end());

        //this part draws the axis for the graph
        scene=new QGraphicsScene();

        /*the axis are drawn in such a way that it resizes with the screen*/

        // Defining the x axis over the pixles with ticks values
        x_axis=new QGraphicsAxisItem('x',-ui->graphicsView->width()/2.3,ui->graphicsView->width()/2.3,10,int((10-fmod(xmax,10))+xmax)/5,-((10-fmod(xmax,10))+xmax));
        y_axis=new QGraphicsAxisItem('y',-ui->graphicsView->height()/2.3,ui->graphicsView->height()/2.3,10,int((10-fmod(ymax,10))+ymax)/5,-((10-fmod(ymax,10))+ymax));

        x_axis->setAxisPen(pen);
        x_axis->setAxisFont(font);

        y_axis->setAxisPen(pen);
        y_axis->setAxisFont(font);

        scene->addItem(x_axis);
        scene->addItem(y_axis);

        x_pix2data=x_axis->Pixels2Data();
        y_pix2data=y_axis->Pixels2Data();

        ui->graphicsView->setScene(scene);

        //used to change pen colour if user decides to
        pen->setColor(pencolor);


        double max=*max_element(x_csv->begin(),x_csv->end());
        double min=*min_element(x_csv->begin(),x_csv->end());

        LinearSpace(min,max,x_csv->size(),xcolumn);//creates a new vector for linear spacingg

        // To make sure every time we plot a new function the old function is removed from the scene
        delete curve;

        curve=new QGraphicsItemGroup();//used to store the line and ellipes to draw the graph

        ui->textEdit->clear();//clears the text Edit if a new type of graph is plotted

        double intercept, slope, cov00, cov01, cov11, sumsq;//variables to store data when linear fit function is called using gsl library

        //gets a choice from user to plot either with or without a constant value

        if(ui->comboBox->currentIndex()==0){

            gsl_fit_linear(x_csv->data(), 1, y_csv->data(), 1, x_csv->size(), &intercept, &slope, &cov00, &cov01, &cov11, &sumsq);

            for (int i=0; i< xcolumn.size(); i++){
                ycolumn.push_back(intercept+slope*xcolumn.at(i));
            }
        }

        else {
            gsl_fit_mul(x_csv->data(), 1, y_csv->data(), 1, x_csv->size(), &slope, &cov11, &sumsq);

            for (int i=0; i< xcolumn.size(); i++){
                ycolumn.push_back(slope*xcolumn.at(i));
            }
        }

        QGraphicsLineItem *lineItem=new QGraphicsLineItem();

        for (int i=1; i<xcolumn.size();i++){
            lineItem= new QGraphicsLineItem(x_pix2data*xcolumn[i-1],-1*y_pix2data*ycolumn[i-1],x_pix2data*xcolumn[i],-1*y_pix2data*ycolumn[i]); //plots a line from one point to another
            lineItem->setPen(*pen);//sets pen value
            curve->addToGroup(lineItem);//adds current line to collection of lines
        }

        if(ui->comboBox->currentIndex()==0){
            //writes the values of the line in the text box
            QString textStr= "The equation of the line is Y= "+QString::number(slope,'f', 3)+"X + "+QString::number(intercept,'f', 3)+
            "\nThe covarian matrix are ["+QString::number(cov00,'f', 3)+", "+QString::number(cov01,'f', 3)+", "+QString::number(cov11,'f', 3)+
            "]\nThe sum of squares of the residuals is = "+QString::number(sumsq);

            //adds to the text box screen
            ui->textEdit->setFontPointSize(10);
            ui->textEdit->setText(textStr);
         }

        else {
            QString textStr= "The equation of the line is Y= "+QString::number(slope,'f', 3)+"X "+
            "\nThe covarian matrix is ["+QString::number(cov11,'f', 3)+
            "]\nThe sum of squares of the residuals is = "+QString::number(sumsq);

            ui->textEdit->setFontPointSize(10);
            ui->textEdit->setText(textStr);
         }

        //the draws the dots of the original points
        QGraphicsEllipseItem *ellipse=new QGraphicsEllipseItem;

        for (int i=0; i<x_csv->size();i++){
ellipse= new QGraphicsEllipseItem(x_pix2data*x_csv->at(i),-1*y_pix2data*y_csv->at(i), 4,4);
ellipse->setBrush(Qt::blue);
 curve->addToGroup(ellipse);
}


        scene->addItem(curve);

        //clears the vectors
        ycolumn.clear();
        xcolumn.clear();

        delete ellipse;
        delete lineItem;
    }

}

//this function changes the color of the line
void project362::on_ChangeColor_clicked(){

   pencolor=QColorDialog::getColor(Qt::black,this,"Color");

  if(pencolor.isValid()) project362::on_plotGraph_clicked();//changes colour if valid

}

//changes colour
void project362::on_Colour_triggered()
{
  project362::on_ChangeColor_clicked();
}

//changes the thickness and recalls plotgraph
void project362::on_thickness_clicked()
{

    bool ok;
    int thicknum= QInputDialog::getInt(this, tr("thickness of curve"), tr("Insert Value: \n (max:100, min:0)"), 25,0,100,1,&ok);
    if(ok){
      pen->setWidth(thicknum);
      project362::on_plotGraph_clicked();
  }

}

//changes thickness
void project362::on_Thickness_triggered()
{
 project362::on_thickness_clicked();
}



