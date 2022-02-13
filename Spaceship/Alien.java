import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import java.util.Random;

public class Alien extends Thread{

   private JPanel panel;

   private int x;
   private int y;

   private int width;
   private int height;

   private int originalX;
   private int originalY;
   private int panelWidth;
   private int panelHeight;
   Rectangle2D.Double Lwing;
   Rectangle2D.Double Mwing;
   Rectangle2D.Double Rwing;

   private int dx;		// increment to move along x-axis
   private int dy;		// increment to move along y-axis

   private Color backgroundColour;
   private Dimension dimension;

   private Random random;

   private Bat bat;

   public Alien (JPanel p, int xPos, int yPos) {
      panel = p;
      dimension = panel.getSize();
      backgroundColour = panel.getBackground ();

      width = 5;
      height = 20;

      random = new Random();

      x = xPos;
      y = yPos;

      dx = 10;			// no movement along x-axis
      dy = 10;			// would like the alien to drop down

     
   }

   
   public void setHeight() {
      panelWidth = panel.getWidth();
      panelHeight = panel.getHeight();
     
   }


   public void draw () {
      Graphics g = panel.getGraphics ();
      Graphics2D g2 = (Graphics2D) g;

      Lwing = new Rectangle2D.Double(x,y,width,height);
      Mwing = new Rectangle2D.Double(x,y+5,height,width);
      Rwing = new Rectangle2D.Double(x+height,y,width,height);


     
      g2.setColor(Color.GREEN);
      g2.fill(Lwing);
      g2.fill(Mwing);
      g2.fill(Rwing);

      g.dispose();
   }


   public void erase () {
      Graphics g = panel.getGraphics ();
      Graphics2D g2 = (Graphics2D) g;

      // erase face by drawing a rectangle on top of it

      g2.setColor (backgroundColour);
      g2.fill(Lwing);
      g2.fill(Mwing);
      g2.fill(Rwing);
      
      g.dispose();
   }


   public void movedown() {

      if (!panel.isVisible ()) return;

      y+=dy;

      }
   public void moveleft() {
	   if(!panel.isVisible())return;
	   
		   x-=dx;
	   if(x<0) 
		   x=400;
	   
	  
   }
   public void moveright() {
	   if(!panel.isVisible())return;
	   
	   x+=dx;
	   if(x>400) {
		   x=0;
		   
	   }
   }
   public void moveup() {
	   if(!panel.isVisible())return;
	   
	   y-=dy;
   }
   public int getX() {
	   return x+dx;
   }
   public int getY() {
	   return y+dy;
   }

   public Rectangle2D.Double getBoundingRectangle() {
      return new Rectangle2D.Double (x, y, width, height);
   }


	}

   



