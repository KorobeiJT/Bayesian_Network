package view;

import java.awt.Color;
import javax.swing.JFrame;

import model.Model;

public class View {

	private final static int WIDTH = 1000;
	private final static int HEIGHT = 800;

	private Panel panel;
	private JFrame frame;

	/* The View manages the differents graphics components and paint it on a panel which is on a frame. 
	 * */

	public View(Model new_model) {
		// The World on which the view get information about the position of food and birds.  
		
		this.panel = new Panel(new_model);
		panel.setBackground(Color.white);
		panel.setBounds(0, 0, WIDTH, HEIGHT);

		this.frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(panel);
		frame.setVisible(true);
	}

	public Panel getPanel() {
		return this.panel;
	}

	public void start() {
		while(true) {
			this.panel.repaint();
			try {
				Thread.sleep((long) Math.floor(1000/60));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
