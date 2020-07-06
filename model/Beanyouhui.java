package cn.edu.zucc.ttcp.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Beanyouhui {
	private int youhui_id;
	private String user_id;
	private int order_id;
	private float discount_amount;
	private float requests_number;
	private Timestamp start_date;
	private Timestamp end_date;
	private float youhui;
	private int number;
	private Timestamp deadline;
	public int getYouhui_id() {
		return youhui_id;
	}
	public void setYouhui_id(int youhui_id) {
		this.youhui_id = youhui_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public float getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(float discount_amount) {
		this.discount_amount = discount_amount;
	}
	public float getRequests_number() {
		return requests_number;
	}
	public void setRequests_number(float requests_number) {
		this.requests_number = requests_number;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public float getYouhui() {
		return youhui;
	}
	public void setYouhui(float youhui) {
		this.youhui = youhui;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Timestamp getDeadline() {
		return deadline;
	}
	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}
	
}
