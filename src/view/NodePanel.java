package view;

import java.awt.*;
import javax.swing.*;

import model.Node;

@SuppressWarnings("serial")
public class NodePanel extends JPanel {

	public NodePanel(Node node) {
		super();
		FlowLayout layout = new FlowLayout();
		super.setLayout(layout);
		this.setMaximumSize(new Dimension(200,200));
		this.add(new JLabel(node.name, SwingConstants.CENTER));
		this.add(new JButton(node.name));
		this.setBackground(Color.red);
	}
}
