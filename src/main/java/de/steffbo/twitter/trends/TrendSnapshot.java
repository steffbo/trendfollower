package de.steffbo.twitter.trends;

import java.util.Date;

import org.ektorp.support.CouchDbDocument;

import twitter4j.Trends;

public class TrendSnapshot extends CouchDbDocument {

    private static final long serialVersionUID = 1L;
    
    private Trends trends;
    private Date time;
    private int woeid;

    public TrendSnapshot() {
    }

    public TrendSnapshot(Trends trends, Date time, int woeid) {
	this.setTrends(trends);
	this.setTime(time);
	this.setWoeid(woeid);
    }

    public TrendSnapshot(Trends trends, int woeid) {
	this(trends, new Date(), woeid);
    }

    public Trends getTrends() {
	return trends;
    }

    public void setTrends(Trends trends) {
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

}
