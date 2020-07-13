package cn.edu.zucc.ttcp.model;


public class Beanjidan {
	
	public static final String[] tableTitles={"优惠编号","商家编号","集单要求数","已下订单数","有效期(天)"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.youhui_id);
		else if(col==1) return String.valueOf(shangjia_id);
		else if(col==2) return String.valueOf(requests_number);
		else if(col==3) return String.valueOf(order_number);
		else if(col==4) return String.valueOf(time_of_day);
		else return "";
	}
	private String user_id;
	private int youhui_id;
	private int shangjia_id;
	private int requests_number;
	private int order_number;
	private int time_of_day;
	public int getTime_of_day() {
		return time_of_day;
	}
	public void setTime_of_day(int time_of_day) {
		this.time_of_day = time_of_day;
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
	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
	}
	public int getRequests_number() {
		return requests_number;
	}
	public void setRequests_number(int requests_number) {
		this.requests_number = requests_number;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	
}
