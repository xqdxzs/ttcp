package cn.edu.zucc.ttcp.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Beanorder {
	public static final String[] tableTitles={"订单编号","商品编号","数量","单价","合计"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.order_id);
		else if(col==1) return String.valueOf(shangping_id);
		else if(col==2) return String.valueOf(number);
		else if(col==3) return String.valueOf(price);
		else if(col==4) return String.valueOf(number*price);
		else return "";
	}
	private int order_id;
	private int shangping_id;
	private int number;
	private float price;

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
	
	
}
