package cn.edu.zucc.ttcp.model;

public class BeanAddress {
	public static final String[] tableTitles={"地址序号","省","市","区","电话号码","地址"};
	public String getCell(int col){
		if(col==0) return String.valueOf(this.address_id);
		else if(col==1) return this.sheng;
		else if(col==2) return this.shi;
		else if(col==3) return this.qu;
		else if(col==4) return this.telephone_number;
		else if(col==5) return this.address;
		else return "";
	}
	private int address_id;
	private int order_id;
	private String user_id;
	private String sheng;
	private String shi;
	private String qu;
	private String address;
	private String telephone_number;
	
	public String getTelephone_number() {
		return telephone_number;
	}
	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
