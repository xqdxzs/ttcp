package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanshangjia_pingjia {
	private int bussiness_id;
	private String user_id;
	private String pingjia_neirong;
	public int getBussiness_id() {
		return bussiness_id;
	}
	public void setBussiness_id(int bussiness_id) {
		this.bussiness_id = bussiness_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPingjia_neirong() {
		return pingjia_neirong;
	}
	public void setPingjia_neirong(String pingjia_neirong) {
		this.pingjia_neirong = pingjia_neirong;
	}
	public Timestamp getPingjia_date() {
		return pingjia_date;
	}
	public void setPingjia_date(Timestamp pingjia_date) {
		this.pingjia_date = pingjia_date;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getPhotop() {
		return photop;
	}
	public void setPhotop(String photop) {
		this.photop = photop;
	}
	private Timestamp pingjia_date;
	private int star;
	private String photop;
}
