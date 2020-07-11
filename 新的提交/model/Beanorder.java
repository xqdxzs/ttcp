package cn.edu.zucc.ttcp.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Beanorder {
	private int order_id;
	private int shangping_id;
	private int number;
	private float price;
	private float youhui;
	private Timestamp time;
	private String user_pingjia;
	private float sigle_revenue;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getShangping_id() {
		return shangping_id;
	}
	public void setShangping_id(int shangping_id) {
		this.shangping_id = shangping_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getYouhui() {
		return youhui;
	}
	public void setYouhui(float youhui) {
		this.youhui = youhui;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getUser_pingjia() {
		return user_pingjia;
	}
	public void setUser_pingjia(String user_pingjia) {
		this.user_pingjia = user_pingjia;
	}
	public float getSigle_revenue() {
		return sigle_revenue;
	}
	public void setSigle_revenue(float sigle_revenue) {
		this.sigle_revenue = sigle_revenue;
	}
	
}
