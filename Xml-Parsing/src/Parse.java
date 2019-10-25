import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parse{

	int cols=10;
	int rows=4;
	String[][] array=new String[cols][rows];
	String TempBalance=null;
	public void ParseMethod(String path)
	{	
		
		try {
	
				File fXmlFile = new File(path);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
						
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
		
				//System.out.println("Root element :" + ((org.w3c.dom.Document) doc).getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("User");
						
				//System.out.println("----------------------------");
		
				int mytemp=0;
				for (int temp = 0; temp < nList.getLength(); temp++)
				{
					
					Node nNode = nList.item(temp);
							
					//System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) 
					{
		
						
						Element eElement = (Element) nNode;
		
						//System.out.println("User id : " + eElement.getAttribute("id"));
						array[mytemp][0]=eElement.getAttribute("id");
						
						//System.out.println("First Name : " + eElement.getElementsByTagName("Firstname").item(0).getTextContent());
						array[mytemp][1]=eElement.getElementsByTagName("Firstname").item(0).getTextContent();
						
						//System.out.println("Last Name : " + eElement.getElementsByTagName("Lastname").item(0).getTextContent());
						array[mytemp][2]=eElement.getElementsByTagName("Lastname").item(0).getTextContent();
						
						//System.out.println("Balance : " + eElement.getElementsByTagName("Balance").item(0).getTextContent());
						array[mytemp][3]=eElement.getElementsByTagName("Balance").item(0).getTextContent();
						
						//System.out.println("----------------------------");
						
						mytemp++;
		
					}
				}
		    }
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void ShowArray()
	{
		boolean temp=true;
		for(int i=0;i<cols;i++)
		{
			for(int j=0;j<rows;j++)
			{
				if(array[i][j]!=null)
				{
					String line=array[i][j];	
					System.out.printf("%s ",line+" ");
				}
				else
				{
					temp=false;
				}
			}
			if(temp==false)
			{
				break;
			}
			System.out.println();
		}
	}
	
	
	public int findUserByID(String ID)
	{
		int position=0;
		for(int i=0;i<cols;i++)
		{
			String temp=array[i][0];
			if(ID.equals(temp)==true)
			{
				System.out.println(array[i][0]+" "+array[i][1]+" "+array[i][2]+" "+array[i][3]);
				position=i;
				break;
			}
		}
		return position;
	}
	
	
	public void UpdateBalance(String balance)
	{
		TempBalance=balance;
	}
	
	public void Update(int position)
	{
		array[position][3]=TempBalance;
	}
}
