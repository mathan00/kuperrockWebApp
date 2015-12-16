import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.NewsItem;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class ParseApp {

	public static void main(String[] args) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			List<NewsItem> newsItems = new ArrayList<NewsItem>();
			InputStream is = null;
			is = new URL("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk").openStream();
			Document doc = documentBuilder.parse(new InputSource(is));
			NodeList nodeList = doc.getElementsByTagName("item");
			for (int j=0; j<nodeList.getLength(); j++){				
				Node n = nodeList.item(j);
				NodeList nodeList2 = n.getChildNodes();
				NewsItem nItem = new NewsItem();
				for (int i=0; i < nodeList2.getLength(); i++){
					if ("title".equals(nodeList2.item(i).getNodeName())){
						nItem.setTitle(nodeList2.item(i).getTextContent());
					}else if ("description".equalsIgnoreCase(nodeList2.item(i).getNodeName())){
						nItem.setDescription(nodeList2.item(i).getTextContent());
					}
				}
				newsItems.add(nItem);
			}

			//Node node = doc.getChildNodes().item(1);
			for (NewsItem item: newsItems){
				System.out.println(item.getTitle() + " -- " +  item.getDescription().replaceAll("<[^>]*>|&nbsp|&raquo", ""));
			}
			
		

	}

}
