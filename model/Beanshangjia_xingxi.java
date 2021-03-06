package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanshangjia_xingxi {
	public static final String[] tableTitles={"序号","名称","星级","人均消费"};
	
	private int shangjia_id;
	private String shangjia_name;
	private int shangjia_star;
	private float renjunxf;
	private int total_sales;
	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
	}
	public String getShangjia_name() {
		return shangjia_name;
	}
	public void setShangjia_name(String shangjia_name) {
		this.shangjia_name = shangjia_name;
	}
	public int getShangjia_star() {
		return shangjia_star;
	}
	public void setShangjia_star(int shangjia_star) {
		this.shangjia_star = shangjia_star;
	}
	public float getRenjunxf() {
		return renjunxf;
	}
	public void setRenjunxf(float renjunxf) {
		this.renjunxf = renjunxf;
	}
	public int getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(int total_sales) {
		this.total_sales = total_sales;
	}
	 public String getCell(int col){
		  if(col==0) return String.valueOf(this.shangjia_id);
		  else if(col==1) return this.shangjia_name;
		  else if(col==2) return String.valueOf(this.shangjia_star);
		  else if(col==3) return String.valueOf(this.renjunxf);
		  else return "";
	 }
}
