package svm.predictor.service.impl;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("documentGetter")
public class DocumentGetter {

	private static Logger logger = LoggerFactory.getLogger(DocumentGetter.class);
	
	public Document getDocument(String url) {
		Document doc =  getDocument(url, null);
		return doc;
	}
	
	public Document getDocument(String url, Map<String, String> cookies) {
		Document doc = doGetDocument(url, cookies, 15000, 3);
		return doc;
	}
	
	private Document doGetDocument(String url, Map<String, String> cookies, int timeout, int retries) {
		if(retries == 0) {
			logger.error("Can't connect after retries to url: " + url);
			throw new RuntimeException("Can't connect after retries to url: " + url);
		}
		Document doc = null;
		try {
			Connection connection = Jsoup.connect(url).timeout(timeout);
			if(cookies != null) {
				connection.cookies(cookies);
			}
			doc = connection.get();
		} catch (IOException e) {
			logger.error("Can't connect to url: " + url + " current retry: " + retries);
			doc = doGetDocument(url, cookies, timeout, --retries);
		}
		return doc;
	}
}
