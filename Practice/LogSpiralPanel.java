import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

public class LogSpiralPanel extends JPanel
{
   private static final double GOLDEN_MEAN = ((1 + Math.sqrt(5)) / 2);

   public void paintComponent(Graphics2D g)
   {
      Graphics2D g2 = (Graphics2D) g;
      double height = getHeight();
      double width = getHeight()*GOLDEN_MEAN;
      Rectangle2D rect = new Rectangle2D.Double(0,0,width,height);
      g2.draw(rect);
      recursiveDraw(g2,0,0,height,90);
   }
   
   /**
      Method that recursively draws a logarithmic spiral.
      @param x The x-coordinate of the golden rectangle's upper-left corner  
      @param y The y-coordinate of the golden rectangle's upper-left corner
      @param side the smallest side size of the golden rectangle
      @param angle the angle (0, 90, 180 or 270) where the top of the 
      golden rectangle is located. For the outermost golden rectangle, 
      the angle is 90.
   */
   private void recursiveDraw(Graphics2D g, double x, double y, double side, int angle)
   {
      int dumb;
   }
}