package cn.edu.zucc.ttcp.model;

public class Beangouwuche {
	public static final String[] tblStepTitle= {"商品名称","单价","数量"};
	private String user_id;
	private int shangping_id;
	private int shangjia_id;
	private String shangping_name;
	private float price;
	private int number;
	public String getCell(int col){
		if(col==0) return this.shangping_name;
		else if(col==1) return String.valueOf(this.price);
		else if(col==2) return String.valueOf(this.number);
		else return "";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getShangping_id() {
		return shangping_id;
	}
	public void setShangping_id(int shangping_id) {
		this.shangping_id = shangping_id;
	}
	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
