package engine;

import javax.swing.JPanel;

import behavior.CellBehavior;
import main.Settings;
import universe.Universe;

public abstract class Engine {
	protected Universe universe;
	protected JPanel mainPanel;
	protected CellBehavior behavior;
	
	public Engine(Universe universe, JPanel mainPanel, CellBehavior behavior){
		this.universe = universe;
		this.mainPanel = mainPanel;
		this.behavior = behavior;
	}
	
	public void start(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					Engine.this.next();
					mainPanel.repaint();
					try {
						Thread.sleep(Settings.PARIOD_DURATION);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public abstract void next();
	
}
