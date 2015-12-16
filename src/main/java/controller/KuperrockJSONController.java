package controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Feed;
import model.NewsItem;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import dao.DAO;

@Controller
@RequestMapping("/UserFeedDetails")
public class KuperrockJSONController {

	@RequestMapping(value="UserFeed", method = RequestMethod.GET, params={"pn"})
	public @ResponseBody User getUserFeedInJSON( @RequestParam(value = "pn") String phoneNumber) {
		System.out.println("getUserFeedInJSON is called()");
		
		User u1 = null;
		try {
			u1 = DAO.getUser(phoneNumber);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Feeds: "+u1.getFeeds());
		return u1;
	}

	@RequestMapping(value="News", method = RequestMethod.GET, params = {"pn"})
	public @ResponseBody List<NewsItem> getNewsJSON(@RequestParam(value = "pn") String phoneNumber)  {
		System.out.println("getUserFeedInJSON is called()");
		
		User u1 = null;
		try {
			u1 = DAO.getUser(phoneNumber);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		List<NewsItem> newsItems = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			newsItems = new ArrayList<NewsItem>();
			int maxNewsPerFeed = u1.getMaxNewsPerFeed();
			int newsItemAdded = 0;
			for (Feed feed: u1.getFeeds()){
				InputStream is = null;
				is = feed.getUrl().openStream();
				Document doc = documentBuilder.parse(new InputSource(is));
				NodeList nodeList = doc.getElementsByTagName("item");
				newsItemAdded = 0;
				for (int j=0; j<nodeList.getLength() && newsItemAdded < maxNewsPerFeed; j++){				
					Node n = nodeList.item(j);
					NodeList nodeList2 = n.getChildNodes();
					NewsItem nItem = new NewsItem();
					for (int i=0; i < nodeList2.getLength(); i++){
		
						if ("title".equals(nodeList2.item(i).getNodeName())){
							nItem.setTitle(nodeList2.item(i).getTextContent());
						}else if ("description".equalsIgnoreCase(nodeList2.item(i).getNodeName())){
							nItem.setDescription(nodeList2.item(i).getTextContent().replaceAll("<[^>]*>|&nbsp|&raquo", ""));
						}
					}
					newsItems.add(nItem);
					newsItemAdded++;
				}

			}
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("News Items: "+newsItems);
		return newsItems;
	}

	
}