package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanrider {
	public static final String[] tableTitles={"骑手编号","骑手姓名","入职时间","身份","接单数"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.rider_id);
		else if(col==1) return this.rider_name;
		else if(col==2) return String.valueOf(emtry_date);
		else if(col==3) return this.rider_sf;
		else if(col==4) return String.valueOf(order_number);
		else return "";
	}
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
	private int order_number;
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
}	
