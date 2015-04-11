import java.awt.*;
import javax.swing.JPanel;
/**
 * Creates a fractal recursively through some insane trig skills
 * 
 * @author Nikhil Sivapatham 
 * @version 10 April 2015
 */
public class FractalTreePanel extends JPanel
{
    private final int PANEL_WIDTH = 1000;
    private final int PANEL_HEIGHT = 1000;
    
    //The Angle between the straight "father" lines
    // and their "children" lines
    private final double ANGLE = 60;
    //The ammount the length of each line will decrease
    private final double REDUCTION_AMMOUNT = 2;

    private final int TOPX = 450, TOPY = 400;
    private final int BOTTOMX = 450, BOTTOMY = 700;

    private int current; //current order

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public FractalTreePanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }
    
    /**
     * Recursively draws a fractal, passing in coordinates for a line, as well
     * as order, which keeps track of ths stage of the fractal
     *
     * @param  order  The order/stage the fractal is currently in
     * @param  x1   The bottom x-coordinate of the line
     * @param  y1   The bottom y-coordinate of the line
     * @param  x2   The top x-coordinate of the line
     * @param  y2   The top y-coordinate of the line
     * 
     */ 

    public void drawFractal (int order, int x1, int y1, int x2, int y2,
    Graphics page)
    {
        int length;

        if (order == 1)
            page.drawLine (x1, y1, x2, y2);
        else
        {  
            length = (int) (Math.sqrt(Math.pow((y1-y2),2) + Math.pow((x1-x2),2)));
            int newLength = (int) (length/REDUCTION_AMMOUNT);
            
            //The new X and Y coordinates on the Left Side, done using trig 
            int xLNew = (int) (x1 + newLength *((Math.cos(Math.toRadians(ANGLE))))); 
            int yLNew = (int) (y1 - newLength *((Math.sin(Math.toRadians(ANGLE))))); 

            //The new X and Y coordinates on the Right Side, done using trig 
            int xRNew = (int) (x1 - newLength *((Math.cos(Math.toRadians(ANGLE)))));   
            int yRNew = (int) (y1 - newLength *((Math.sin(Math.toRadians(ANGLE)))));

            //Draws the Parent line
            drawFractal (order-1, x1, y1, x2, y2, page);
            //Draws the Left Child
            drawFractal (order-1, xLNew, yLNew, x1, y1, page);
            //Draws the Right Child
            drawFractal (order-1, xRNew, yRNew, x1, y1, page);
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
