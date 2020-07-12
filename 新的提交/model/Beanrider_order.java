package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanrider_order {
	private int rider_id;
	public int getRider_id() {
		return rider_id;
	}
	public void setRider_id(int rider_id) {
		this.rider_id = rider_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public int getUser_pingjia() {
		return user_pingjia;
	}
	public void setUser_pingjia(int user_pingjia) {
		this.user_pingjia = user_pingjia;
	}
	public float getOrder_money() {
		return order_money;
	}
	public void setOrder_money(float order_money) {
		this.order_money = order_money;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	private int order_id;
	private Timestamp order_time;
	private int user_pingjia;
	private float order_money;
	private int order_number;
}
