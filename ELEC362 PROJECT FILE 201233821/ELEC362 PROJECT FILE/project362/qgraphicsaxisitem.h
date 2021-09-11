#ifndef QGRAPHICSAXISITEM_H
#define QGRAPHICSAXISITEM_H

#include <QGraphicsItem>
#include <QRectF>
#include <QPainter>
#include <QString>
#include <QDebug>
#include <QPen>
#include <QFont>

class QGraphicsAxisItem : public QGraphicsItem
{
private:
    qreal pix_low, pix_high; // Variables used to define the upper and the lower limits in pixels for axis
    qreal d_pix; //number of pixels in a given interval
    char mode; // variable to decided whether the required axis is x or y axis
    int tick_number; // Numbers of ticks required
    qreal tick_increment;  // This vairbale represent the "real" numbers on the ticks of the axis
    qreal start_tick; // This variable have the "real" number on the first tick

    //formatting variables:
    QPen *pen=new QPen();
    QFont *font=new QFont();



public:
    QGraphicsAxisItem(char mode, qreal pix_min, qreal pix_max, int NumOfTicks, qreal TickIncrement, qreal TickStart);

    // These two functions must be overriden (i.e the derived class deinfition must override the parent's class definition of what they do)
    QRectF boundingRect() const override;
    void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget ) override;

     // These functions are used for formatting the axis:
     void setAxisPen(QPen* external_pen);
     void setAxisFont(QFont* external_font);

// This function is used to return the number of pixels that correspond to a real number
    qreal Pixels2Data();

    ~QGraphicsAxisItem(); // The destructor must be defined manually here
};


#endif // QGRAPHICSAXISITEM_H
