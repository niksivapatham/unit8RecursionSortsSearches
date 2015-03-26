import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

public class Component extends JComponent
{
    public void paintComponent(Graphics g)
    {        
        Graphics2D g2 = (Graphics2D) g;
    }
}
