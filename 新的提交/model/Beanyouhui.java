package cn.edu.zucc.ttcp.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Beanyouhui {
	public static final String[] tableTitles={"用户账号","优惠金额","持有数量","开始时间","到期时间"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.user_id);
		else if(col==1) return String.valueOf(youhui);
		else if(col==2) return String.valueOf(this.number);
		else if(col==3) return String.valueOf(start_time);
		else if(col==4) return String.valueOf(deadline);
		else return "";
	}
	private int youhui_id;
	private String user_id;
	private int shangjia_id;
	private float youhui;
	private int number;
	private Timestamp start_time;
	private Timestamp deadline;
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
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
