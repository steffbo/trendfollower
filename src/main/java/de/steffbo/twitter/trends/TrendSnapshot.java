package de.steffbo.twitter.trends;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.ektorp.support.CouchDbDocument;

public class TrendSnapshot extends CouchDbDocument {

    private static final long serialVersionUID = 1L;

    private Date time;
    private int woeid;
    private ArrayList<String> trends;

    public TrendSnapshot() {
    }

    public TrendSnapshot(ArrayList<String> trends, Date time, int woeid) {
	this.setTrends(trends);
	this.setTime(time);
	this.setWoeid(woeid);
    }

    public TrendSnapshot(ArrayList<String> trends, int woeid) {
	this(trends, new Date(), woeid);
    }

    public ArrayList<String> getTrends() {
	return trends;
    }

    public void setTrends(ArrayList<String> trends) {
	this.trends = trends;
    }

    public Date getTime() {
	return time;
    }

    public void setTime(Date time) {
	this.time = time;
    }

    public int getWoeid() {
	return woeid;
    }

    public void setWoeid(int woeid) {
	this.woeid = woeid;
    }

    @Override
    public String toString() {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append("Time: ");
	sb.append(sdf.format(time));
	sb.append(", Woeid: ");
	sb.append(woeid);
	sb.append(" (");
	sb.append(Woeid.getCity(woeid));
	sb.append(")");
	sb.append(", Trends: ");
	sb.append(trends.stream().collect(Collectors.toList()).toString());
	sb.append("]");
	return sb.toString();
    }

}
