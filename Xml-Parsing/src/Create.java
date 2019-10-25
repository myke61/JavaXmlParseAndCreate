import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Create {

	//Parse pr=new Parse();
	public static final String xmlFilePath = "C:\\Users\\myke\\eclipse-workspace\\Xml-Parsing\\file.xml";
	
	public void CreateAndSave(String array[][])
	{
		
		try {
			 
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("company");
            document.appendChild(root);
            
            
    		for(int i=0;i<10;i++)
    		{
    				if(array[i][0]!=null)
    				{	
    					
        	            // employee element
        	            Element employee = document.createElement("User");
        	 
        	            root.appendChild(employee);
        	 
        	            // set an attribute to staff element
        	            Attr attr = document.createAttribute("id");
        	            attr.setValue(array[i][0]);
        	            employee.setAttributeNode(attr);
        	 
        	            //you can also use staff.setAttribute("id", "1") for this
        	 
        	            // firstname element
        	            Element firstName = document.createElement("Firstname");
        	            firstName.appendChild(document.createTextNode(array[i][1]));
        	            employee.appendChild(firstName);
        	 
        	            // lastname element
        	            Element lastname = document.createElement("Lastname");
        	            lastname.appendChild(document.createTextNode(array[i][2]));
        	            employee.appendChild(lastname);
        	 
        	            // email element
        	            Element email = document.createElement("Balance");
        	            email.appendChild(document.createTextNode(array[i][3]));
        	            employee.appendChild(email);
        	            System.out.print(array[i][0]);
    				}
    				
    		}
 
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
 
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
		
		
	}
}
