package cn.edu.zucc.ttcp.model;

public class Beanmanjian {
	public static final String[] tableTitles={"满减编号","商家编号","要求满减金额","优惠金额","叠加优惠券"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.manjian_id);
		else if(col==1) return String.valueOf(shangjia_id);
		else if(col==2) return String.valueOf(manjian_amount);
		else if(col==3) return String.valueOf(youhui_amount);
		else if(col==4) return String.valueOf(diejia);
		else return "";
	}
	private int manjian_id;
	private int order_id;
	private int shangjia_id;
	private int manjian_amount;
	private int youhui_amount;
	private int diejia;
	public int getManjian_id() {
		return manjian_id;
	}
	public void setManjian_id(int manjian_id) {
		this.manjian_id = manjian_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
	}
	public int getManjian_amount() {
		return manjian_amount;
	}
	public void setManjian_amount(int manjian_amount) {
		this.manjian_amount = manjian_amount;
	}
	public int getYouhui_amount() {
		return youhui_amount;
	}
	public void setYouhui_amount(int youhui_amount) {
		this.youhui_amount = youhui_amount;
	}
	public int getDiejia() {
		return diejia;
	}
	public void setDiejia(int diejia) {
		this.diejia = diejia;
	}
	
}
