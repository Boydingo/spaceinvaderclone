import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

/**
   A component that displays all the game entities
*/

public class GamePanel extends JPanel{
	private int NUM_ALIENS = 6;
   private Bat bat;
   private Alien[] alien;
   private Shot shot;
   private GameThread gamethread;
   Random rand = new Random();
   public GamePanel () {
	bat = null;
	alien = null;
	shot = null;
	
   }
   

   public void createGameEntities() {
       bat = new Bat (this); 
       shot = new Shot(this,200,370);
       alien = new Alien [6];
       for(int i=0;i<alien.length;i++) {
    	   alien[i]=  new Alien (this,rand.nextInt(390),rand.nextInt(300));
       }
//       alien[0] = new Alien (this,rand.nextInt(400),rand.nextInt(300));
//       alien[1] = new Alien (this,rand.nextInt(400),rand.nextInt(300));
//       alien[2] = new Alien (this, rand.nextInt(400),rand.nextInt(300));
//       alien[3] = new Alien (this, rand.nextInt(400),rand.nextInt(300));
//       alien[4] = new Alien (this, rand.nextInt(400),rand.nextInt(300));
//       alien[5] = new Alien (this, rand.nextInt(400),rand.nextInt(300));
  }


   public void GameRender() {

       if (bat != null) {
    	   bat.draw();
       }
       	  
       if (alien!= null) {
			for (int i=0; i<alien.length; i++)
			   alien[i].draw();
				
      		}
      
     
   }
   

   public void dropAliens() {
	   Thread thread;
	   createGameEntities();
	   gamethread = new GameThread (this);
	   thread = new Thread (gamethread);			
	   thread.start();
}
		
   
	
  public void updatealien() {
	  
	for(int i=0;i<alien.length;i++) {
		if(iseven(i)==true) {
			alien[i].moveright();
			alien[i].erase();
		}else {
			alien[i].moveleft();
			alien[i].erase();
		}
	}  
  }//end method
  
public boolean iseven(int i) {
	if(i%2==0)
		return true;
	else 
		return false;
}
  public void updateGameEntities(int direction) {
	  
	  if (bat != null) {
		bat.erase();
	       	bat.move(direction);
	  }
	  
	    	

   }


   public boolean isOnBat (int x, int y) {
      return bat.isOnBat(x, y);
   }







   

}