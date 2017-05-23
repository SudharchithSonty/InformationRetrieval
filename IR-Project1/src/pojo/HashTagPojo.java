package pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HashTags")
@XmlAccessorType (XmlAccessType.FIELD)
public class HashTagPojo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Text")
	private String hashTagText;

	/**
	 * @return the hashTagText
	 */
	public String getHashTagText() {
		return hashTagText;
	}
	/**
	 * @param hashTagText the hashTagText to set
	 */
	public void setHashTagText(String hashTagText) {
		this.hashTagText = hashTagText;
	}
}