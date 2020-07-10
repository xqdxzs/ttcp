package cn.edu.zucc.ttcp.model;

public class Beanshangping_leibie {
	public static final String[] tblStepTitle= {"名称","类别序号","商品总数"};
	private String category_name;
	private int category_id;
	private int shangjia_id;
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
	}
	public int getShangping_number() {
		return shangping_number;
	}
	public void setShangping_number(int shangping_number) {
		this.shangping_number = shangping_number;
	}
	private int shangping_number;
	public String getCell(int col){
		if(col==0) return this.getCategory_name();
		else if(col==1) return String.valueOf(this.category_id);
		else if(col==2) return String.valueOf(this.shangping_number);
		else return "";
	}
}
