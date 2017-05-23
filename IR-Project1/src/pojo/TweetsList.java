package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tweets")
@XmlAccessorType (XmlAccessType.FIELD)
public class TweetsList {
	@XmlElement(name="tweetlist")
	private List<Tweet> tweetsList = new ArrayList<Tweet>();

	/**
	 * @return the tweetsList
	 */
	public List<Tweet> getTweetsList() {
		return tweetsList;
	}
	/**
	 * @param tweetsList the tweetsList to set
	 */
	public void setTweetsList(List<Tweet> tweetsList) {
		this.tweetsList = tweetsList;
	}
}