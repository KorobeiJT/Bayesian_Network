package view;

import java.awt.*;
import javax.swing.*;

import model.Node;

@SuppressWarnings("serial")
public class NodePanel extends JPanel {

	public NodePanel(Node node) {
		super();
		super.setLayout(new BorderLayout());
//		this.setBounds(0, 0, 200, 200);
//		this.setMaximumSize(new Dimension(200,200));
		this.add(new JLabel(node.name), BorderLayout.CENTER);
		this.add(new JButton(node.name), BorderLayout.NORTH);
//		this.setBackground(Color.red);
	}
}
