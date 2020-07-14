package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanshangping_order {
	public static final String[] tableTitles={"订单编号","地址编号","原价","实付","下单时间","订单状态"};
	public static final String[] tableTitles1={"订单编号","地址编号","原价","实付","下单时间","要求送达时间"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.order_id);
		else if(col==1) return String.valueOf(address_id);
		else if(col==2) return String.valueOf(yuanjia);
		else if(col==3) return String.valueOf(shijijiage);
		else if(col==4) return String.valueOf(order_time);
		else if(col==5) return this.order_zhuangtai;
		else return "";
	}
	public String getCell1(int col){
		if(col==0) return String.valueOf(this.order_id);
		else if(col==1) return String.valueOf(address_id);
		else if(col==2) return String.valueOf(yuanjia);
		else if(col==3) return String.valueOf(shijijiage);
		else if(col==4) return String.valueOf(order_time);
		else if(col==5) return String.valueOf(required_time);
		else return "";
	}
	private int order_id;
	private int address_id;
	private int manjian_id;
	private String user_id;
	private int youhui_id;
	private float yuanjia;
	private float shijijiage;
	private Timestamp order_time;
	private Timestamp required_time;
	private String order_zhuangtai;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getManjian_id() {
		return manjian_id;
	}
	public void setManjian_id(int manjian_id) {
		this.manjian_id = manjian_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getYouhui_id() {
		return youhui_id;
	}
	public void setYouhui_id(int youhui_id) {
		this.youhui_id = youhui_id;
	}
	public float getYuanjia() {
		return yuanjia;
	}
	public void setYuanjia(float yuanjia) {
		this.yuanjia = yuanjia;
	}
	public float getShijijiage() {
		return shijijiage;
	}
	public void setShijijiage(float shijijiage) {
		this.shijijiage = shijijiage;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public Timestamp getRequired_time() {
		return required_time;
	}
	public void setRequired_time(Timestamp required_time) {
		this.required_time = required_time;
	}
	public String getOrder_zhuangtai() {
		return order_zhuangtai;
	}
	public void setOrder_zhuangtai(String order_zhuangtai) {
		this.order_zhuangtai = order_zhuangtai;
	}
}
