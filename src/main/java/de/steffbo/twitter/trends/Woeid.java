package de.steffbo.twitter.trends;

import java.util.HashMap;

public class Woeid {

    public static final int BERLIN = 638242;
    public static final int PARIS = 615702;
    public static final int LONDON = 44418;
    public static final int NEW_YORK = 2459115;

    public static HashMap<Integer, String> cities;

    static {
	cities = new HashMap<Integer, String>();
	cities.put(BERLIN, "Berlin");
	cities.put(PARIS, "Paris");
	cities.put(LONDON, "London");
	cities.put(NEW_YORK, "New York");
    }

    public static String getCity(int woeid) {

	return cities.get(woeid);
    }
}
