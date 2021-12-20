package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;
import view.View;

public class Controller implements MouseListener {

	/*
	 * Class principale qui gere le model, qui contient le Model, et la view, qui
	 * contient la frame et la panel de vue
	 */

	private Model model;
	private View view;

	private final static int WIDTH = 1000;
	private final static int HEIGHT = 800;

	public Controller() {
		// Cree un monde qui contient les birds et la food qui evoluent
		this.model = new Model(WIDTH, HEIGHT);
		this.view = new View(model);
//		this.view.getPanel().addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	public static void main(String[] args) {
		Controller controller = new Controller();
//		controller.view.start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
