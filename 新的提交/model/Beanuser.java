package cn.edu.zucc.ttcp.model;

import java.sql.Timestamp;

public class Beanuser {
	public static Beanuser currentLoginUser=null;
	private String user_id;
	private String name;
	private String gender;
	private String password;
	private String telephone_number;
	private String email;
	private String city;
	private Timestamp chuece_time;
	private int vip;
	private String vip_deadline;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone_number() {
		return telephone_number;
	}
	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Timestamp getChuece_time() {
		return chuece_time;
	}
	public void setChuece_time(Timestamp timestamp) {
		this.chuece_time = timestamp;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getVip_deadline() {
		return vip_deadline;
	}
	public void setVip_deadline(String vip_deadline) {
		this.vip_deadline = vip_deadline;
	}
	
}
