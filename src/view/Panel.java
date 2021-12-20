package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Model;
import model.Node;


@SuppressWarnings("serial")
public class Panel extends JPanel {

	private Model model;

	public Panel(Model new_model) {
		super();
		super.setLayout(null);
		this.model = new_model;
	}

	public void paintComponent(Graphics g) {
		this.setBackground(Color.white);
		super.paintComponent(g);
		for (Map.Entry<Node, Integer[]> entry : model.coords.entrySet()) {
			Node key = entry.getKey();
			Integer[] val = entry.getValue();
			JPanel pan = new JPanel();
			pan.setBackground(Color.red);
			pan.add(new JButton("oui"));
//			JPanel pan = drawPannel(val[0], val[1], key);
			pan.setVisible(true);
			this.add(pan);
		}
	}
	
	public JPanel drawPannel(int x, int y, Node node) {
		JPanel res = new JPanel();
		res.setBounds(x, y, 200, 100);
		
		res.add(new JLabel(node.name), BorderLayout.CENTER);
		res.add(new JButton(node.name), BorderLayout.NORTH);
		
		return res;
		
	}
	
	
	
}
