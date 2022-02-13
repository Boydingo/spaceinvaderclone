import java.awt.event.KeyEvent;

import javax.swing.JPanel;


public class GameThread implements Runnable{
	private GamePanel gamepanel;
	private Shot shot;
	private int keycode;
	private boolean isRunning;

	
	
	public GameThread (GamePanel gamePanel) {
		this.gamepanel = gamePanel;
		isRunning = true;
		
	}
	
	public void update() {
		gamepanel.updatealien();
	}
	
	public void render() {
		gamepanel.GameRender();
	}
	

	@Override
	public void run() {
		try {
			while(isRunning!=false) {
				render();
				update();
				render();
				Thread.sleep(250);
			}
			
		}catch(InterruptedException e) {}
		
	
		
		
	}

	
}
