#ifndef PROJECT362_H
#define PROJECT362_H

#include <QMainWindow>
#include <QGraphicsScene>
#include "qgraphicsaxisitem.h"
#include<QFileDialog>
#include <QFile>
#include <QVector>
#include <QTextStream>
#include <QGraphicsLineItem>
#include <QGraphicsItemGroup>
#include <gsl/gsl_fit.h>
#include <gsl/gsl_statistics_double.h>
#include <QList>
#include <QStandardItemModel>
#include <QFont>
#include <QColorDialog>
#include <QColor>
#include <QInputDialog>
#include<QMessageBox>
#include <QGraphicsEllipseItem>
#include <QResizeEvent>
#include "gsl/gsl_spline.h"


using namespace std;

QT_BEGIN_NAMESPACE
namespace Ui { class project362; }

QT_END_NAMESPACE

class project362 : public QMainWindow
{
    Q_OBJECT

public:
    project362(QWidget *parent = nullptr);
    void LinearSpace(double start, double end, int NumofValues, QVector<double>& data);// function to create linear space vector
    void IsActionValid(); //a function to handle error

  ~project362();


private slots:
    void customMenuRequested(QPoint pos);

    void resizeEvent(QResizeEvent *e);

    void on_Load_File_triggered();

    void on_plotGraph_clicked();

    void on_ChangeColor_clicked();

    void on_Colour_triggered();

    void on_thickness_clicked();

    void on_Thickness_triggered();


private:
    Ui::project362 *ui;
    QGraphicsScene *scene= new QGraphicsScene(this);//connect scen to the view
    QGraphicsAxisItem *x_axis; //Defining the x axis
    QGraphicsAxisItem *y_axis; //Defining the y axis

    QGraphicsItemGroup *curve=new QGraphicsItemGroup(); // This saves all the lines making the curve of the function to be plotted

    QStandardItemModel *csvModel; //creates a table to store values to display on screen
    QVector<double> *x_csv, *y_csv; //saves the columns from csv file in a column
    QString *line; //saves a line from the read file

    qreal x_pix2data, y_pix2data;//those variables are for matching "real" numbers of the functions to those of pixels

    //formatting variables
    QPen *pen=new QPen();
    QFont *font=new QFont();

    // to store the x and y data of the user's input
    QVector<double> xcolumn, ycolumn;

    //original set colour of graph line
    QColor pencolor=Qt::red;


    //error handling variables
    bool InputIsValid=false; // flag to say the error can be handled properly
    QMessageBox *error_load_file_to_plot=new QMessageBox(); // Error message for when there is no loaded file

};
#endif // PROJECT362_H
