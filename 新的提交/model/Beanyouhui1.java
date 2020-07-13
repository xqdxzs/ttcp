package cn.edu.zucc.ttcp.model;

public class Beanyouhui1 {
	public static final String[] tableTitles={"优惠序号","商家序号","优惠金额","集单要求数","优惠券可持有时间(天)"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.youhui_id);
		else if(col==1) return String.valueOf(this.shangjia_id);
		else if(col==2) return String.valueOf(this.youhui);
		else if(col==3) return String.valueOf(this.requests_number);
		else if(col==4) return String.valueOf(this.time_of_day);
		else return "";
	}
	
	int youhui_id;
	int shangjia_id;
	float youhui;
	int requests_number;
	int time_of_day;
	public int getTime_of_day() {
		return time_of_day;
	}
	public void setTime_of_day(int time_of_day) {
		this.time_of_day = time_of_day;
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
	public float getYouhui() {
		return youhui;
	}
	public void setYouhui(float youhui) {
		this.youhui = youhui;
	}
	public int getRequests_number() {
		return requests_number;
	}
	public void setRequests_number(int requests_number) {
		this.requests_number = requests_number;
	}
}
