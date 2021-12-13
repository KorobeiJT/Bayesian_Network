package model;

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
		String[] tmp = new String[0];
		nw.nodes.put("test", new Node("test", tmp));
		coords = new HashMap<Node, Integer[]>();
		int i = 1;
		for (Iterator<Node> iterator = nw.nodes.values().iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			int step_width = (int) Math.floor(max_width/((nw.nodes.size()/2)+1));
			int step_height = (int) Math.floor(max_height/3);
			Integer[] coordtmp = new Integer[2];
			coordtmp[0] = step_width * i;
			coordtmp[1] = (int) (step_height * Math.floor(i/3));
			coords.put(node, coordtmp);
			i++;
		}
	}
	
	public Collection<Node> getNodes(){
		return nw.nodes.values();	
	}

	public static void main(String[] args) {
		DataCollector dc = new DataCollector("gamesList.xml", "typeList.xml");
		Model model = new Model(1000,700);
		View view = new View(model);
		
		
	}
	
}
