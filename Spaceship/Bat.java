import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import java.lang.reflect.Array;


public class Bat {

   private JPanel panel;
   private int x;
   private int y;
   private int x2;
   private int y2;
   private int x3;
   private int y3;
   private int[] polyX= {190,200,210};
   private int[] polyY= {400,380,400};
   private int dx;
   private int dy;
   private Shot shot;

   private Polygon bat;

   private Color backgroundColour;
   private Dimension dimension;


   public Bat (JPanel p) {
	      panel = p;
	      dimension = panel.getSize();
	      backgroundColour = panel.getBackground ();
	    
	      dx = 10;
	      dy = 0;
	      
	   }


   public void draw () {
      Graphics g = panel.getGraphics ();
      Graphics2D g2 = (Graphics2D) g;

      bat = new Polygon(polyX,polyY,3);
      g2.setColor(Color.RED);
      g2.fill(bat);

      g.dispose();
   }


   

public void move (int direction) {

      if (!panel.isVisible ()) return;
    	  if(direction == 1) {
    		  if(polyX[0]-dx<0) {
    				
    			}else {
    				  for(int i=0; i<polyX.length;i++) {
    			  polyX[i]-=dx;
    			}
    			
    		}
    	  
      	
    	  }else if(direction == 2) {
    			  if(polyX[2]+dx>400) {
    				  
    			  }else {
    				  for(int i=0; i<polyX.length;i++) {
    					  polyX[i]+=dx;
    				  }
    			  }
    				  
    		  }
}


   public void erase () {
	      Graphics g = panel.getGraphics ();
	      Graphics2D g2 = (Graphics2D) g;


	      // erase bat by drawing a rectangle on top of it with the background colour

	      g2.setColor (backgroundColour);
	      g2.fill (new Polygon(polyX,polyY,3));

	      g.dispose();
	   }
public int getX() {
	return x;
}
public int getY() {
	return y;
}
   public boolean isOnBat (int x, int y) {
      if (bat == null)
      	  return false;

      return bat.contains(x, y);
   }

}