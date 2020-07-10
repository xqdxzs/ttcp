package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanrider {
	public int getRider_id() {
		return rider_id;
	}
	public void setRider_id(int rider_id) {
		this.rider_id = rider_id;
	}
	public String getRider_name() {
		return rider_name;
	}
	public void setRider_name(String rider_name) {
		this.rider_name = rider_name;
	}
	public Timestamp getEmtry_date() {
		return emtry_date;
	}
	public void setEmtry_date(Timestamp emtry_date) {
		this.emtry_date = emtry_date;
	}
	public String getRider_sf() {
		return rider_sf;
	}
	public void setRider_sf(String rider_sf) {
		this.rider_sf = rider_sf;
	}
	private int rider_id;
	private String rider_name;
	private Timestamp emtry_date;
	private String rider_sf;
}	
