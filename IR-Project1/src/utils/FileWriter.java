/**
 * 
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import pojo.TweetsList;

/**
 * @author MANJEET
 *
 */
public class FileWriter {
	
	public static final String FILE_PATH = "tweets\\";
	
	public void writeDataToFile(TweetsList list, String lang, String queryName, String timestamp) {
		String fileURI = FILE_PATH.concat(lang).concat(queryName).concat(timestamp).concat(".xml");
		try {
			File file = new File(fileURI);
			JAXBContext context = JAXBContext.newInstance(TweetsList.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(list, new FileOutputStream(file));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}