package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.data.DataCollector;

public class Network {

	public HashMap<String, Node> nodes;
	
	public Network() {
		nodes = new HashMap<String, Node>();
	}
	
	public void addNode(Node new_node) {
		nodes.put(new_node.name, new_node);
	}
	
	public void linkNodes() {
		DataCollector dc = new DataCollector("gamesList.xml", "typeList.xml");
		ArrayList<String> typeList = dc.getTypes();
		HashMap<String, String[]> gameList = dc.getGames();
		
		Iterator<String> typeIt = typeList.iterator();
		while(typeIt.hasNext()) {
			String typeName = typeIt.next();
			String[] games = gamesOfType(typeName, gameList);
			
			if (!nodes.containsKey(typeName)) {
				nodes.put(typeName, new Node(typeName, games, null));
			}
			else {
				nodes.get(typeName).setParentsNames(games);
			}
		}
		
		Set<String> games = gameList.keySet();
		for(String game : games) {
			String[] types = gameList.get(game);
			
			if(!nodes.containsKey(game)) {
				nodes.put(game, new Node(game, null, types));
			}
			else {
				nodes.get(game).setChildrenNames(types);
			}
		}
		
		Set<String> netNodes = nodes.keySet();
		for(String nodeName : netNodes) {
			Node node = nodes.get(nodeName);
			String[] parents = node.parents_names;
			String[] children = node.children_names;
			
			if(parents!=null) {
				for (String parent : parents) {
					node.parents.add(nodes.get(parent));
				}
			}
			
			if(children!=null) {
				for (String child : children) {
					node.children.add(nodes.get(child));
				}
			}
		}
	}

	private boolean gameIsOfType(String game, String type, HashMap<String, String[]> gameList) {
		String[] typeList = gameList.get(game);
		for (String typeName : typeList) {
			if (typeName.equals(type)) return true;
		}
		
		return false;
	}

	private String[] gamesOfType(String type, HashMap<String, String[]> gameList) {
		ArrayList<String> res = new ArrayList<String>();
		
		Set<String> games = gameList.keySet();
		for(String game : games) {
			if(gameIsOfType(game, type, gameList)) res.add(game);
		}
		
		return (String[]) res.toArray();
	}
	
}
