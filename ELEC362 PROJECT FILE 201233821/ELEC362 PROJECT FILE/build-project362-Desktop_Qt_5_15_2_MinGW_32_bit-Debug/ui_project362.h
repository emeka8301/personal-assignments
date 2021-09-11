/********************************************************************************
** Form generated from reading UI file 'project362.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PROJECT362_H
#define UI_PROJECT362_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QGraphicsView>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTableView>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_project362
{
public:
    QAction *Thickness;
    QAction *Colour;
    QAction *Load_File;
    QWidget *centralwidget;
    QHBoxLayout *horizontalLayout;
    QVBoxLayout *verticalLayout_3;
    QLabel *label;
    QTableView *tableView;
    QComboBox *comboBox;
    QPushButton *plotGraph;
    QLabel *label_3;
    QVBoxLayout *verticalLayout;
    QTextEdit *textEdit;
    QGroupBox *groupBox_2;
    QWidget *layoutWidget;
    QVBoxLayout *verticalLayout_2;
    QPushButton *ChangeColor;
    QPushButton *thickness;
    QGraphicsView *graphicsView;
    QMenuBar *menubar;
    QMenu *File;
    QMenu *Edit;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *project362)
    {
        if (project362->objectName().isEmpty())
            project362->setObjectName(QString::fromUtf8("project362"));
        project362->resize(800, 674);
        QSizePolicy sizePolicy(QSizePolicy::Expanding, QSizePolicy::Expanding);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(project362->sizePolicy().hasHeightForWidth());
        project362->setSizePolicy(sizePolicy);
        Thickness = new QAction(project362);
        Thickness->setObjectName(QString::fromUtf8("Thickness"));
        Colour = new QAction(project362);
        Colour->setObjectName(QString::fromUtf8("Colour"));
        Load_File = new QAction(project362);
        Load_File->setObjectName(QString::fromUtf8("Load_File"));
        centralwidget = new QWidget(project362);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        horizontalLayout = new QHBoxLayout(centralwidget);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        label = new QLabel(centralwidget);
        label->setObjectName(QString::fromUtf8("label"));
        QSizePolicy sizePolicy1(QSizePolicy::Minimum, QSizePolicy::Minimum);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(label->sizePolicy().hasHeightForWidth());
        label->setSizePolicy(sizePolicy1);
        QFont font;
        font.setPointSize(10);
        label->setFont(font);

        verticalLayout_3->addWidget(label);

        tableView = new QTableView(centralwidget);
        tableView->setObjectName(QString::fromUtf8("tableView"));
        QSizePolicy sizePolicy2(QSizePolicy::Minimum, QSizePolicy::Expanding);
        sizePolicy2.setHorizontalStretch(0);
        sizePolicy2.setVerticalStretch(0);
        sizePolicy2.setHeightForWidth(tableView->sizePolicy().hasHeightForWidth());
        tableView->setSizePolicy(sizePolicy2);
        tableView->setMinimumSize(QSize(250, 200));

        verticalLayout_3->addWidget(tableView);

        comboBox = new QComboBox(centralwidget);
        comboBox->addItem(QString());
        comboBox->addItem(QString());
        comboBox->setObjectName(QString::fromUtf8("comboBox"));
        sizePolicy1.setHeightForWidth(comboBox->sizePolicy().hasHeightForWidth());
        comboBox->setSizePolicy(sizePolicy1);
        comboBox->setFont(font);

        verticalLayout_3->addWidget(comboBox);

        plotGraph = new QPushButton(centralwidget);
        plotGraph->setObjectName(QString::fromUtf8("plotGraph"));
        sizePolicy1.setHeightForWidth(plotGraph->sizePolicy().hasHeightForWidth());
        plotGraph->setSizePolicy(sizePolicy1);
        plotGraph->setFont(font);

        verticalLayout_3->addWidget(plotGraph);

        label_3 = new QLabel(centralwidget);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        sizePolicy1.setHeightForWidth(label_3->sizePolicy().hasHeightForWidth());
        label_3->setSizePolicy(sizePolicy1);
        label_3->setFont(font);

        verticalLayout_3->addWidget(label_3);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setSpacing(7);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        verticalLayout->setContentsMargins(0, -1, 0, -1);

        verticalLayout_3->addLayout(verticalLayout);

        textEdit = new QTextEdit(centralwidget);
        textEdit->setObjectName(QString::fromUtf8("textEdit"));
        sizePolicy2.setHeightForWidth(textEdit->sizePolicy().hasHeightForWidth());
        textEdit->setSizePolicy(sizePolicy2);
        textEdit->setMinimumSize(QSize(250, 60));

        verticalLayout_3->addWidget(textEdit);

        groupBox_2 = new QGroupBox(centralwidget);
        groupBox_2->setObjectName(QString::fromUtf8("groupBox_2"));
        sizePolicy1.setHeightForWidth(groupBox_2->sizePolicy().hasHeightForWidth());
        groupBox_2->setSizePolicy(sizePolicy1);
        groupBox_2->setMinimumSize(QSize(250, 100));
        groupBox_2->setFont(font);
        layoutWidget = new QWidget(groupBox_2);
        layoutWidget->setObjectName(QString::fromUtf8("layoutWidget"));
        layoutWidget->setGeometry(QRect(0, 20, 251, 71));
        verticalLayout_2 = new QVBoxLayout(layoutWidget);
        verticalLayout_2->setSpacing(0);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        verticalLayout_2->setContentsMargins(9, 0, 9, 0);
        ChangeColor = new QPushButton(layoutWidget);
        ChangeColor->setObjectName(QString::fromUtf8("ChangeColor"));
        sizePolicy1.setHeightForWidth(ChangeColor->sizePolicy().hasHeightForWidth());
        ChangeColor->setSizePolicy(sizePolicy1);

        verticalLayout_2->addWidget(ChangeColor);

        thickness = new QPushButton(layoutWidget);
        thickness->setObjectName(QString::fromUtf8("thickness"));
        sizePolicy1.setHeightForWidth(thickness->sizePolicy().hasHeightForWidth());
        thickness->setSizePolicy(sizePolicy1);

        verticalLayout_2->addWidget(thickness);


        verticalLayout_3->addWidget(groupBox_2);


        horizontalLayout->addLayout(verticalLayout_3);

        graphicsView = new QGraphicsView(centralwidget);
        graphicsView->setObjectName(QString::fromUtf8("graphicsView"));
        QSizePolicy sizePolicy3(QSizePolicy::MinimumExpanding, QSizePolicy::MinimumExpanding);
        sizePolicy3.setHorizontalStretch(0);
        sizePolicy3.setVerticalStretch(0);
        sizePolicy3.setHeightForWidth(graphicsView->sizePolicy().hasHeightForWidth());
        graphicsView->setSizePolicy(sizePolicy3);

        horizontalLayout->addWidget(graphicsView);

        project362->setCentralWidget(centralwidget);
        menubar = new QMenuBar(project362);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 800, 26));
        File = new QMenu(menubar);
        File->setObjectName(QString::fromUtf8("File"));
        Edit = new QMenu(menubar);
        Edit->setObjectName(QString::fromUtf8("Edit"));
        project362->setMenuBar(menubar);
        statusbar = new QStatusBar(project362);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        project362->setStatusBar(statusbar);

        menubar->addAction(File->menuAction());
        menubar->addAction(Edit->menuAction());
        File->addAction(Load_File);
        Edit->addAction(Thickness);
        Edit->addSeparator();
        Edit->addAction(Colour);

        retranslateUi(project362);

        QMetaObject::connectSlotsByName(project362);
    } // setupUi

    void retranslateUi(QMainWindow *project362)
    {
        project362->setWindowTitle(QCoreApplication::translate("project362", "project362", nullptr));
        Thickness->setText(QCoreApplication::translate("project362", "Thickness", nullptr));
        Colour->setText(QCoreApplication::translate("project362", "Color", nullptr));
        Load_File->setText(QCoreApplication::translate("project362", "Load File", nullptr));
        label->setText(QCoreApplication::translate("project362", "Table of Values", nullptr));
        comboBox->setItemText(0, QCoreApplication::translate("project362", "Plot with constant", nullptr));
        comboBox->setItemText(1, QCoreApplication::translate("project362", "Plot without constant", nullptr));

        plotGraph->setText(QCoreApplication::translate("project362", "Plot Graph", nullptr));
        label_3->setText(QCoreApplication::translate("project362", "Graph Properties", nullptr));
        groupBox_2->setTitle(QCoreApplication::translate("project362", "Edit Graph", nullptr));
        ChangeColor->setText(QCoreApplication::translate("project362", "Color", nullptr));
        thickness->setText(QCoreApplication::translate("project362", "Thickness", nullptr));
        File->setTitle(QCoreApplication::translate("project362", "File", nullptr));
        Edit->setTitle(QCoreApplication::translate("project362", "Edit", nullptr));
    } // retranslateUi

};

namespace Ui {
    class project362: public Ui_project362 {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PROJECT362_H
