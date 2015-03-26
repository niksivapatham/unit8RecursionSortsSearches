//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class KochPanel extends JPanel
{
   private final int PANEL_WIDTH = 1000;
   private final int PANEL_HEIGHT = 1000;

   private final double ANGLE = 30;

   private final int TOPX = 450, TOPY = 500;
   private final int BOTTOMX = 450, BOTTOMY = 900;

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public KochPanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (int order, int x1, int y1, int x5, int y5,
                            Graphics page)
   {
      int deltaX, deltaY, x3, y3, tempXLeft, tempXRight, tempY;

      if (order == 1)
         page.drawLine (x1, y1, x5, y5);
      else
      {
         deltaY = (y5 - y1)/2; // distance between end points         
         
         tempXLeft = x1+deltaY/2;
         tempXRight = x1-deltaY/2;
         tempY = y1-deltaY;
         
         x3 = (int) (((tempY-y1)/((Math.cos(Math.toRadians(ANGLE))))));  // tip of projection
         y3 = (int) ((y1+y5) + Math.cos(Math.toRadians(ANGLE)) * deltaY);

         drawFractal (order-1, x5, y5, x1, y1, page);
         drawFractal (order-1, x1, y1, tempXLeft, tempY, page);
         drawFractal (order-1, x1, y1, tempXRight, tempY, page);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      drawFractal (current, TOPX, TOPY, BOTTOMX, BOTTOMY, page);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
