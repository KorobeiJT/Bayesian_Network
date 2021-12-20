package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import model.data.DataCollector;
import view.View;

public class Model {

	public Network nw;
	public HashMap<Node, Integer[]> coords;
	private int max_width;
	private int max_height;

	public Model(int max_width, int max_height) {
		this.max_width = max_width;
		this.max_height = max_height;
		nw = new Network();
		nw.linkNodes();
		String[] tmp = new String[0];
		coords = new HashMap<Node, Integer[]>();

		int i = 0;
		int j = 0;
		for (Iterator<Node> iterator = sortNode(nw.nodes.values()).iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			int step_width = (int) Math.floor(max_width / nw.nodes.size());
			int step_height = (int) Math.floor(max_height / 3);
			Integer[] coordtmp = new Integer[2];
			coordtmp[0] = (step_width * (i % 6));
			coordtmp[1] = (int) (step_height * Math.floor(j));
			coords.put(node, coordtmp);
			i++;
			if (i % 6 == 0)
				j++;
		}
	}

	public Collection<Node> getNodes() {
		return nw.nodes.values();
	}

	public ArrayList<Node> sortNode(Collection<Node> nodes) {
		ArrayList<Node> res = new ArrayList<Node>();
		for (Node node : nodes) {
			if (!node.parents.isEmpty())
				res.add(0, node);
		}
		for (Node node : nodes) {
			if (!res.contains(node))
				res.add(0, node);
		}
		return res;
	}

	public static void main(String[] args) {
		DataCollector dc = new DataCollector("gamesList.xml", "typeList.xml");
		Model model = new Model(1000, 700);
		View view = new View(model);
		view.start();

	}

}
