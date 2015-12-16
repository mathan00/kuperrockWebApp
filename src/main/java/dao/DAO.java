package dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Feed;
import model.User;

public class DAO {

	
	
	
	public static User getUser(String phoneNumber) throws MalformedURLException{
		if (phoneNumber == null) return null;
		
		User u1 = new User();
		u1.setEmail("mathan_5_5@hotmail.com");
		u1.setFirstName("Mathan");
		u1.setPhoneNumber("6479677368");
		u1.setPassword("123456");
		
		List<Feed> feeds = new ArrayList<Feed>();
		Feed f1 = new Feed();
		f1.setCategory(Category.BUSINESS);
		f1.setUrl(new URL("https://news.google.com/news?cf=all&hl=en&pz=1&ned=ca&topic=b&output=rss"));
		f1.setSource("Google News");
		
		Feed f2 = new Feed();
		f2.setCategory(Category.ENTERTAINMENT);
		f2.setUrl(new URL("https://news.google.com/news?cf=all&hl=en&pz=1&ned=ca&topic=e&output=rss"));
		f2.setSource("Google News");
		
		Feed f3 = new Feed();
		f3.setCategory(Category.POLITICS);
		f3.setUrl(new URL("https://news.google.com/news?cf=all&hl=en&pz=1&ned=ca&topic=w&output=rss"));
		f3.setSource("Google News");
		
		Feed f4 = new Feed();
		f4.setCategory(Category.WORLD);
		f4.setUrl(new URL("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk"));
		f4.setSource("BBC News");
		
		feeds.add(f1);
		feeds.add(f2);
		feeds.add(f3);
		feeds.add(f4);
		
		u1.setFeeds(feeds);
		return u1;
	}
}
