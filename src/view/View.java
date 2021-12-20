package view;


import java.awt.*;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.Model;
import model.Node;

public class View {

	private final static int WIDTH = 1000;
	private final static int HEIGHT = 800;

	private JPanel mainPanel;
	private JFrame frame;
	private Container container;
	private Model model;

	/* The View manages the differents graphics components and paint it on a panel which is on a frame. 
	 * */

	public View(Model new_model) {
		model = new_model;
		
		// frame
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(200, 50);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = frame.getContentPane();
        container.setLayout(null);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
        mainPanel.setOpaque(false);

        container.add(mainPanel);
        
        for (Map.Entry<Node, Integer[]> entry : model.coords.entrySet()) {
			Node key = entry.getKey();
			Integer[] val = entry.getValue();
			JPanel pan = new JPanel();
			pan.setLayout(new BorderLayout());
			JLabel label = new JLabel(key.name);
			label.setVisible(true);
//			label.setSize(label.getPreferredSize());
			pan.add(label, BorderLayout.CENTER);
			label.revalidate();
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pan.setBackground(Color.white);
			pan.setBounds(val[0], val[1], 70, 25);
			pan.setVisible(true);
			pan.revalidate();
			mainPanel.add(pan);
		}     
                
	}
	
	public JPanel drawPan(Node node, int x, int y) {
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(new JLabel(node.name), BorderLayout.CENTER);
		pan.setBackground(Color.red);
		pan.setBounds(x,y,150,200);
		pan.setVisible(true);
		
		return pan;
	}


	public void start() {
		while(true) {
//			this.frame.repaint();
//			this.mainPanel.repaint();
			Graphics g = mainPanel.getGraphics();
	        
	        for(Map.Entry<Node, Integer[]> entry : model.coords.entrySet()) {
	        	Node key = entry.getKey();
				Integer[] val = entry.getValue();
				for (Node child : key.children) {
					g.drawLine(val[0]+35, val[1]+12, model.coords.get(child)[0]+35, model.coords.get(child)[1]+12);
				}
	        }
			try {
				Thread.sleep((long) Math.floor(1000/60));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
