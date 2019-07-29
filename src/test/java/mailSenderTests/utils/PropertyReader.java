package mailSenderTests.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static PropertyReader propertyReader;

	public PropertyReader() {
	}
	public static PropertyReader getInstance() {
		if (propertyReader == null)
		{
			propertyReader = new PropertyReader();
		}
		return propertyReader;
	}

	public String getProperty(String propertyName) {
		Properties props = new Properties();
		try(FileReader fileReader = new FileReader(System.getProperty("target", "prod.properties"))){
			props.load(fileReader);
		}
		catch (IOException e){
			throw new UnableToReadPropertyFileException("Unable to read property file");
		}
		return props.getProperty(propertyName);
	}
}
