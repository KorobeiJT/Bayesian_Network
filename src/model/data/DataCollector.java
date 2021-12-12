package model.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataCollector {

	private String gamePath;
	private String typePath;

	public DataCollector(String gamePath, String typePath) {
		this.gamePath = gamePath;
		this.typePath = typePath;
	}

	public ArrayList<String> getTypes() {
		ArrayList<String> res = new ArrayList<String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(typePath);
			NodeList typesList = doc.getElementsByTagName("type");
			for (int i = 0; i < typesList.getLength(); i++) {
				Node type = typesList.item(i);
				assert(type.getNodeType() == Node.ELEMENT_NODE);
				if (!type.getTextContent().isBlank()) {
					res.add(type.getTextContent());					
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public HashMap<String, String[]> getGames(){
		HashMap<String, String[]> res = new HashMap<String, String[]>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(gamePath);
			NodeList gamesList = doc.getElementsByTagName("game");
			for (int i = 0; i < gamesList.getLength(); i++) {
				NodeList gameData = gamesList.item(i).getChildNodes();				
				String[] tmp = new String[2];
				for (int j = 0; j < gameData.getLength(); j++) {
					tmp[0] = gameData.item(3).getTextContent();
					tmp[1] = gameData.item(5).getTextContent();
					res.put(gameData.item(1).getTextContent(), tmp);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}		
		return res;
		
	}
	
	/*public static void main(String[] args) {
		DataCollector dc = new DataCollector("typeList.xml");
		for (String string : dc.getTypes()) {
			System.out.println(string);
		}
		DataCollector dc2 = new DataCollector("gamesList.xml");
		HashMap<String, String[]> hm = dc2.getGames();
		for (String string : hm.keySet()) {
			System.out.println(string + " : " + hm.get(string)[0] + hm.get(string)[1]);
		}
		
	}*/
}
