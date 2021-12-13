package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Model;
import model.Node;


@SuppressWarnings("serial")
public class Panel extends JPanel {

	private Model model;

	public Panel(Model new_model) {
		super();
		this.model = new_model;
	}

	public void paintComponent(Graphics g) {
		this.setBackground(Color.white);
		super.paintComponent(g);
		for (Map.Entry<Node, Integer[]> entry : model.coords.entrySet()) {
			Node key = entry.getKey();
			Integer[] val = entry.getValue();
			NodePanel np = new NodePanel(key);
			np.setVisible(true);
			this.add(np);
			System.out.println(val[0] + val[1]);
			np.setBounds(val[0], val[1], 200, 200);
			np.paint(g);
		}
	}
	
	
	
}
