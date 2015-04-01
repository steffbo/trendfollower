package de.steffbo.twitter.trends.misc;

import java.io.InputStream;
import java.util.Properties;

public class TrendProperties {

    private Properties properties;

    private TrendProperties() {
	loadProperties();
    }

    private static class LazyHolder {
	private static final TrendProperties INSTANCE = new TrendProperties();
    }

    public static TrendProperties getInstance() {
	return LazyHolder.INSTANCE;
    }

    private void loadProperties() {

	String propFileName = "config.properties";

	if (properties == null) {
	    try {
		properties = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		properties.load(inputStream);
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	}
    }

    public Properties getProperties() {
	return properties;
    }

}
