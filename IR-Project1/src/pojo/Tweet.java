/**
 * 
 */
package pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author MANJEET
 *
 */
@XmlRootElement(name="tweet")
@XmlAccessorType (XmlAccessType.FIELD)
public class Tweet{

	@XmlElement(name="userid")
	private long userId;
	@XmlElement(name="language")
	private String language;
	@XmlElement(name="TweetURL")
	private String tweetURL;
	@XmlElement(name="TweetAddress")
	private String tweetAddress;
	@XmlElement(name="Text")
	private String tweetText;
	@XmlElement(name="HashTags")
	private List<HashTagPojo> hashTags;
	@XmlElement(name="RetweetCount")
	private Integer retweetCount;
	
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * @return the tweetURL
	 */
	public String getTweetURL() {
		return tweetURL;
	}
	/**
	 * @param tweetURL the tweetURL to set
	 */
	public void setTweetURL(String tweetURL) {
		this.tweetURL = tweetURL;
	}
	
	/**
	 * @return the tweetAddress
	 */
	public String getTweetAddress() {
		return tweetAddress;
	}
	/**
	 * @param tweetAddress the tweetAddress to set
	 */
	public void setTweetAddress(String tweetAddress) {
		this.tweetAddress = tweetAddress;
	}
	
	/**
	 * @return the tweetText
	 */
	public String getTweetText() {
		return tweetText;
	}
	/**
	 * @param tweetText the tweetText to set
	 */
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	
	/**
	 * @return the hashTags
	 */
	public List<HashTagPojo> getHashTags() {
		return hashTags;
	}
	/**
	 * @param hashTags the hashTags to set
	 */
	public void setHashTags(List<HashTagPojo> hashTagTextList) {
		this.hashTags = hashTagTextList;
	}
	
	/**
	 * @return the retweetCount
	 */
	public Integer getRetweetCount() {
		return retweetCount;
	}
	/**
	 * @param retweetCount the retweetCount to set
	 */
	public void setRetweetCount(Integer retweetCount) {
		this.retweetCount = retweetCount;
	}
}