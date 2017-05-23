/**
 * 
 */
package crawl;

import java.util.ArrayList;
import java.util.List;

import pojo.HashTagPojo;
import pojo.Tweet;
import pojo.TweetsList;
import twitter4j.HashtagEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitterfactory.Twitter4jFactory;
import utils.DateUtility;
import utils.FileWriter;

/**
 * @author MANJEET
 *
 */
public class TweetsCrawler {

	/**
	 * @param args
	 */
	
	public void getTwitterData(Twitter twitterInstance, String lang, String queryName) {
		try {
			List<Status> tweetsList = getTweets(twitterInstance, lang, queryName);
			List<Tweet> tweetsXMLDataList = new ArrayList<Tweet>();
 			for(Status status : tweetsList) {
 				tweetsXMLDataList.add(setXMLData(status));
			}
 			TweetsList list = new TweetsList();
 			list.setTweetsList(tweetsXMLDataList);
			FileWriter writer = new FileWriter();
			writer.writeDataToFile(list, lang, queryName, DateUtility.getCurrentTimeStamp());
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	private Twitter getTwitterInstance() {
		return Twitter4jFactory.getInstance();
	}
	
	private List<Status> getTweets(Twitter twitterInstance, String lang, String queryName) throws TwitterException{
		List<Status> queryRslt = new ArrayList<Status>();
		try {
			Query query = new Query();
			query.setLang(lang);
			query.setQuery(queryName);
			query.setCount(2000);
			QueryResult rslt = twitterInstance.search(query);
			queryRslt = rslt.getTweets();
		} catch (Exception e) {
			throw new TwitterException("Encountered an exception while fetching tweets for query: "+e);
		}
		return queryRslt;
	}
	
	private Tweet setXMLData(Status tweetData) {
		Tweet xmlObj = new Tweet();
		xmlObj.setUserId(tweetData.getId());
		xmlObj.setLanguage(tweetData.getLang());
		xmlObj.setTweetAddress(tweetData.getSource());
		xmlObj.setTweetText(tweetData.getText());
		xmlObj.setRetweetCount(tweetData.getRetweetCount());
		xmlObj.setTweetURL(tweetData.getURLEntities().toString());
		HashtagEntity[] hashTags = tweetData.getHashtagEntities();
		List<HashTagPojo> hashTagList = new ArrayList<HashTagPojo>();
		for(HashtagEntity entity : hashTags) {
			HashTagPojo obj = new HashTagPojo();
			obj.setHashTagText(entity.getText());
			hashTagList.add(obj);
		}
		xmlObj.setHashTags(hashTagList);
		return xmlObj;
	}
	
	public static void main(String[] args) {
		TweetsCrawler crawler = new TweetsCrawler();
		try {
			Twitter twitterInstance = new TweetsCrawler().getTwitterInstance();
			crawler.getTwitterData(twitterInstance, "en", "Donald Trump");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}