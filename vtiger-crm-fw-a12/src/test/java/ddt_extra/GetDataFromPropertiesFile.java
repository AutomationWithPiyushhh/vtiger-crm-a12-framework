package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		1.	Get the Java Representation Object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");

//		2.	Use the load() of Properties class to load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		3.	Use the getProperty(Key) and pass the key and get the value in String format
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
