package model;

import java.util.ArrayList;

import model.data.Parameters;

public class Node {
	
	public ArrayList<Node> parents;
	public ArrayList<Node> children;
	public Parameters parametre;
	
	public String name;
	public String[] parents_names;
	public String[] children_names;
	
	public Node(String name, String[] parents_names, String[] children_names) {
		this.name = name;
		this.parents_names = parents_names;
		this.children_names = children_names;
	}
	
	public void setParentsNames(String[] parents_names) {
		this.parents_names = parents_names;
	}	
	
	public void setChildrenNames(String[] children_names) {
		this.children_names = children_names;
	}
	
}
