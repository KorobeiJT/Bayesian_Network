package model;

import model.data.DataCollector;

public class Model {

	public static void main(String[] args) {
		DataCollector dc = new DataCollector("gamesList.xml", "typeList.xml");
		Network network = new Network();
	}
	
}
