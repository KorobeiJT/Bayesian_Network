package model;

import java.util.HashMap;

public class Network {

	public HashMap<String, Node> nodes;
	
	public Network() {
		nodes = new HashMap<String, Node>();
	}
	
	public void addNode(Node new_node) {
		nodes.put(new_node.name, new_node);
	}
	
	public void linkNodes() {
		
	}

}
