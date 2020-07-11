package cn.edu.zucc.ttcp.model;

public class Beanshangping_xiangxi {
	public static final String[] tblStepTitle= {"序号","商品名称","价格","余量"};
	private int shangping_id;
	private int category_id;
	private String shangping_name;
	private float price;
	private float youhui;
	private int yuliang;
	public int getYuliang() {
		return yuliang;
	}
	public void setYuliang(int yuliang) {
		this.yuliang = yuliang;
	}
	public int getShangping_id() {
		return shangping_id;
	}
	public void setShangping_id(int shangping_id) {
		this.shangping_id = shangping_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getShangping_name() {
		return shangping_name;
	}
	public void setShangping_name(String shangping_name) {
		this.shangping_name = shangping_name;
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
	public String getCell(int col){
		if(col==0) return String.valueOf(this.shangping_id);
		else if(col==1) return this.shangping_name;
		else if(col==2) return String.valueOf(this.price);
		else if(col==3) return String.valueOf(this.yuliang);
		else return "";
	}
}
