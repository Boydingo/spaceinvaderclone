import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.lang.reflect.Array;

public class Shot extends JPanel{
	private JPanel panel;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private Rectangle2D.Double shot;
	private int width;
	private int height;
	
	private Color backgroundColour;
	private Dimension dimension;
	private Bat bat;
	private int batx;
	private int baty;

public Shot(JPanel p,int xpos,int ypos) {
	panel = p;
    dimension = panel.getSize();
    backgroundColour = panel.getBackground ();
    x=xpos;
    y=ypos;
    width = 4;
    height = 8;
	
	dx=10;
	dy=20;
	
	
}
public void draw () {
    Graphics g = panel.getGraphics ();
    Graphics2D g2 = (Graphics2D) g;

    shot = new Rectangle2D.Double(x,y,width,height);
    g2.setColor(Color.red);
    g2.fill(shot);
    
    g.dispose();
 }
public void erase () {
    Graphics g = panel.getGraphics ();
    Graphics2D g2 = (Graphics2D) g;

    // erase face by drawing a rectangle on top of it

    g2.setColor (backgroundColour);
    g2.fill(shot);
 
    g.dispose();
 }
public void moveup() {
	   if(!panel.isVisible())return;
	   
	   y-=dy;
}
public int getY() {
	return y;
}

}

