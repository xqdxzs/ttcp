package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanshangping_order {
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
