/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.util.Random;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

/**
 *
 * @author Usuario
 */
public class UtiilsData {
    
    public String customerId;
    
    public UtiilsData() {}
    
    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr.toLowerCase();
    }
    
    public String getSaltNumbers(){
        String SALTCHARS = "0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
   }            
    
    public String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
    
    public void createXml(String dataId){
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            // students root element
            Element rootElement = doc.createElement("test-customer");
            doc.appendChild(rootElement);

            // student elements

                Element dataRow = doc.createElement("customer-data");
                Element dataValue = doc.createElement("customer-id");
                dataValue.setTextContent(dataId);
                dataRow.appendChild(dataValue);
                rootElement.appendChild(dataRow);


            // Write the content into XML file
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("customer-new.xml"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Beautify the format of the resulted XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public String readXml(){
    
        try{
            File stocks = new File("customer-new.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            
            System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
            
            NodeList nodes = doc.getElementsByTagName("customer-data");
            
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    customerId = this.getValue("customer-id", element);
                }
            }
            
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return customerId;
    }
}
