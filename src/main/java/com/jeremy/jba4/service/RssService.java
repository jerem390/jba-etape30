package com.jeremy.jba4.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.jeremy.jba4.entities.Item;
import com.jeremy.jba4.exceptions.RssException;
import com.jeremy.jba4.rss.ObjectFactory;
import com.jeremy.jba4.rss.TRss;
import com.jeremy.jba4.rss.TRssChannel;
import com.jeremy.jba4.rss.TRssItem;


@Service
public class RssService  {
	
	public List<Item> getItems(File file)throws RssException{
		return getItems(new StreamSource(file));
	}
	
	public List<Item> getItems(String url)throws RssException{
		return getItems(new StreamSource(url));
	}
	
	private List<Item> getItems(Source source)throws RssException{
		List<Item> list=new ArrayList<Item>();
					try {
						JAXBContext jaxbContext=JAXBContext.newInstance(ObjectFactory.class);
						Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
						JAXBElement<TRss> jaxbElement=unmarshaller.unmarshal(source, TRss.class);
						TRss rss=jaxbElement.getValue();
						List<TRssChannel> channels=rss.getChannel();
						for (TRssChannel channel : channels) {
							List<TRssItem> items=channel.getItem();
							for (TRssItem tRssItem : items) {
								Item item=new Item();
								item.setTitle(tRssItem.getTitle());
								item.setDescription(tRssItem.getDescription());
								item.setLink(tRssItem.getLink());
								Date publishedDate=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.ENGLISH).parse(tRssItem.getPubDate());
								item.setPublishedDate(publishedDate);
								list.add(item);
							
							}
						}
						
					} catch (JAXBException e) {
					
						throw new RssException(e);
					} catch (ParseException e) {
						throw new RssException(e);
						
					
					}
					return list;
		
	}
	
}
