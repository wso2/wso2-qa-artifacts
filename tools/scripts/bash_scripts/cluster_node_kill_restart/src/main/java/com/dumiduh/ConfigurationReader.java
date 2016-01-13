/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumiduh;

import java.util.ArrayList;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author dumiduh
 */
public class ConfigurationReader {
private ArrayList<NodeDTO> nodes;
private String configURL;

    public ConfigurationReader(String url)
    {
        nodes = new ArrayList<NodeDTO>();
        this.configURL=url;
    }

    /**
     * @return the nodes
     */
    public ArrayList<NodeDTO> getNodes() {
        return this.nodes;
    }


    
    
    public void readConfig()
    {

        try {
        
        String absolutePath = new File(configURL).getAbsolutePath();
	File fXmlFile = new File(absolutePath);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile); 
        doc.getDocumentElement().normalize();
 
	
 
	NodeList nList = doc.getElementsByTagName("node");
 
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
                        NodeDTO node = new NodeDTO();
                        node.setIp(eElement.getElementsByTagName("ip").item(0).getTextContent());
                        node.setUsername(eElement.getElementsByTagName("username").item(0).getTextContent());
                        node.setKeyPath(eElement.getElementsByTagName("keypath").item(0).getTextContent());
                        node.setKeyword(eElement.getElementsByTagName("keyword").item(0).getTextContent());
                     
                        nodes.add(node);
			 
		}
	}
        

    } catch (ParserConfigurationException e) {
	e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (DOMException e) {
        e.printStackTrace();
    }
        
        
  }
            

 }
