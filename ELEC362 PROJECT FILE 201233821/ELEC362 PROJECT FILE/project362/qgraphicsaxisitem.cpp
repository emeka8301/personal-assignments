#include "qgraphicsaxisitem.h"
#include "project362.h"


QGraphicsAxisItem::QGraphicsAxisItem(char mode, qreal pix_min, qreal pix_max, int NumOfTicks, qreal TickIncrement, qreal TickStart)
{
    // The constructor
    pix_low=pix_min;
    pix_high=pix_max;
    this->mode=mode;

    tick_number=NumOfTicks;

    tick_increment=TickIncrement;

    start_tick=TickStart;

    d_pix=(pix_high-pix_low)/(double) tick_number; // this variable is the number of pixels in a given interval in the axis
}

QRectF QGraphicsAxisItem::boundingRect() const{

    // This function defines the area occupied by the axis item
    QRectF outerRect;

    qreal length= pix_high-pix_low;

   if(mode=='x') outerRect.setRect(pix_low-30,-50,length+60,100);

   else {outerRect.setRect(-100,-(pix_high+60),100,length+60);}

    return outerRect;

}

void QGraphicsAxisItem::paint(QPainter *painter, const QStyleOptionGraphicsItem *, QWidget *)
{
    // This function paints the item
    qreal current_value=pix_low;
    qreal current_tick=start_tick;
    QString text;

    if (mode=='x'){

        painter->drawLine(pix_low,0,pix_high,0);
        //draw arrow at the end
        painter->drawLine(pix_high-15,15,pix_high,0);
        painter->drawLine(pix_high-15,-15,pix_high,0);

        // drawing the ticks assuming it is x-axis
        for (int i=0; i<tick_number; i++){

            painter->drawLine(current_value,0,current_value,-5);
            text=QString::number(current_tick,'f',2);
            painter->drawText(current_value,20,text);
            current_value += d_pix;
            current_tick+= tick_increment;
    }

        painter->drawText(current_value,20,"(x)"); //value written on the x axis

    }

        else{

            painter->rotate(180);
            painter->drawLine(0,pix_low,0,pix_high);
            //draw arrow at the end
            painter->drawLine(15,pix_high-15,0,pix_high);
            painter->drawLine(-15,pix_high-15,0,pix_high);

            for (int i=0; i<tick_number; i++)
        {
                painter->drawLine(0,current_value,5,current_value);
                text=QString::number(current_tick,'f',2);
                painter->rotate(-180);
                painter->drawText(-30,-current_value,text);
                painter->rotate(180);
                current_value += d_pix;
                current_tick+= tick_increment;
        }

            //value written on the x axis
            painter->rotate(-180);
            painter->drawText(-30,-current_value,"(y)");

       }

}

void QGraphicsAxisItem::setAxisPen(QPen* external_pen)
{ // This function is created to allow the user to set the style of the axis (the colour, the width, and so on)
    pen=external_pen;
}

void QGraphicsAxisItem::setAxisFont(QFont* external_font)
{// This function is created to allow the user to set the font of the ticks
    font=external_font;
}

qreal QGraphicsAxisItem::Pixels2Data()
{
    // This function returns the conversion ratio from pixel into "real" numbers

    return d_pix/tick_increment;

}

QGraphicsAxisItem::~QGraphicsAxisItem()
{// Don't forget to clean up if you used dynamic memory


}
