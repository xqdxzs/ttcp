package cn.edu.zucc.ttcp.model;

public class Beanyouhui1 {
	public static final String[] tableTitles={"优惠序号","商家序号","优惠金额"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.youhui_id);
		else if(col==1) return String.valueOf(this.shangjia_id);
		else if(col==2) return String.valueOf(this.youhui);
		else return "";
	}
	int youhui_id;
	int shangjia_id;
	float youhui;
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
}
