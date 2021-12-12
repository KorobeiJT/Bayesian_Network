package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Model;


@SuppressWarnings("serial")
public class Panel extends JPanel {

	private Model model;

	public Panel(Model new_model) {
		super();
		this.model = new_model;
	}

	public void paintComponent(Graphics g) {
		this.setBackground(Color.white);
		try {
			super.paintComponent(g);
			Image image = ImageIO.read(new File(System.getProperty("user.dir") + "//src//parc.jpg"));
			int x = (this.getWidth() - image.getWidth(null)) / 2;
			int y = (this.getHeight() - image.getHeight(null)) / 2;
			g.drawImage(image, x, y, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
