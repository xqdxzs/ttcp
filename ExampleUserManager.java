package cn.edu.zucc.ttcp.comtrol.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
//
//import cn.edu.zucc.personplan.model.BeanUser;
//import cn.edu.zucc.personplan.util.BaseException;
//import cn.edu.zucc.personplan.util.BusinessException;
//import cn.edu.zucc.personplan.util.DBUtil;
//import cn.edu.zucc.personplan.util.DbException;
import java.util.List;

import com.sun.crypto.provider.RSACipher;
import com.sun.scenario.effect.impl.prism.PrTexture;
import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;

import cn.edu.zucc.ttcp.itf.IUserManager;
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beanadmin;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;
import sun.print.resources.serviceui;



public class ExampleUserManager implements IUserManager {
	public Beanuser reg(String userid, String pwd,String pwd2,String name,String telepohone_number,String email,String city,String sex) throws BaseException {
		// TODO Auto-generated method stub
		if(userid==null||"".equals(userid)) throw new BusinessException("用户名不能为空");
		if(pwd==null||"".equals(pwd)) throw new BusinessException("密码不能为空");
		if(!(pwd.equals(pwd2))) throw new BusinessException("二次输入密码不相同");
		if(name==null||"".equals(name)) throw new BusinessException("昵称不可为空");
		if(telepohone_number==null||"".equals(telepohone_number)) throw new BusinessException("电话号码不能为空");
		if(email==null||"".equals(email)) throw new BusinessException("邮件不可为空");
		if(city==null||"".equals(city)) throw new BusinessException("城市不可为空");
		if(sex==null||"".equals(sex)) throw new BusinessException("性别未选择");
		Beanuser user=new Beanuser();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql ="select * from user_information_table where user_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("用户名已存在");
			rs.close();
			pst.close();
			sql = "insert into user_information_table(user_id,name,gender,password,telephone_number,email,city) values(?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2,name);
			pst.setString(3,sex);
			pst.setString(4,pwd);
			pst.setString(5,telepohone_number);
			pst.setString(6,email);
			pst.setString(7,city);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return user;
	}

	
	public Beanadmin login(String admin_id, String pwd) throws BaseException {
		// TODO Auto-generated method stub

		Beanadmin root = new Beanadmin();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from administrator_information_table where admin_id=? and password=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, admin_id);
			pst.setString(2, pwd);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("用户名不存在或密码错误");
			
			root.setAdmin_id(rs.getString(1));
			root.setAdmin_name("root");
			root.setPassword(rs.getString(3));
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return root;
	}
	public Beanuser loginuser(String admin_id, String pwd) throws BaseException {
		// TODO Auto-generated method stub

		Beanuser user = new Beanuser();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from user_information_table where user_id=? and password=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, admin_id);
			pst.setString(2, pwd);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("用户名不存在或密码错误");
			user.setUser_id(rs.getString(1));
			user.setName(rs.getString(2));
			user.setGender(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setTelephone_number(rs.getString(5));
			user.setEmail(rs.getString(6));
			user.setCity(rs.getString(7));
			user.setChuece_time(rs.getTimestamp(8));
			user.setVip(rs.getInt(9));
			//user.currentLoginUser
			user.setVip_deadline(String.valueOf(rs.getTimestamp(10)));
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return user;
	}



	


	@Override
	public void changeuserPwd(Beanuser user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub

		if(!String.valueOf(user.getPassword()).equals(oldPwd)) throw new BusinessException("密码错误");
		
		if(!(newPwd.equals(newPwd2))) throw new BusinessException("二次密码不同");
		
		Connection conn=null;
		try {
			//System.out.print("1111");
			conn=DBUtil.getConnection();
			String sql="update user_information_table set password=? where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getUser_id());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}





	public void changeadminPwd(Beanadmin admin, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub

		if(!String.valueOf(admin.getPassword()).equals(oldPwd)) throw new BusinessException("密码错误");
		
		if(!(newPwd.equals(newPwd2))) throw new BusinessException("二次密码不同");
		
		Connection conn=null;
		try {
			//System.out.print("1111");
			conn=DBUtil.getConnection();
			String sql="update administrator_information_table set password=? where admin_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2,admin.getAdmin_id());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}



	@Override
	public void vip(float money) {
		// TODO Auto-generated method stub
		
	}
	public BeanAddress add_address(String user_id,String sheng, String shi, String qu ,String telephone_number, String addrss)throws BaseException{
		Connection conn=null;
		int address_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(address_id) from address_list";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				address_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into address_list(address_id,user_id,sheng,"
					+ "shi,qu,telephone_number,address) values(?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,address_id);
			pst.setString(2, Beanuser.currentLoginUser.getUser_id());//获取登录后的userid
			pst.setString(3, sheng);
			pst.setString(4, qu);
			pst.setString(5, shi);
			pst.setString(6, telephone_number);
			pst.setString(7, addrss);
			pst.execute();
			pst.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}


	@Override
	public List<BeanAddress> loadaddresss() throws BaseException {
		Connection conn=null;
		List<BeanAddress> result=new ArrayList<BeanAddress>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select address_id,sheng,shi,qu,telephone_number,address from address_list where user_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,Beanuser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				BeanAddress p=new BeanAddress();
				p.setAddress_id(rs.getInt(1));
				p.setSheng(rs.getString(2));
				p.setShi(rs.getString(3));
				p.setQu(rs.getString(4));
				p.setTelephone_number(rs.getString(5));
				p.setAddress(rs.getString(6));
				
				result.add(p);
			}
			pst.execute();
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}


	@Override
	public BeanAddress delete_address(int address_id) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete  from address_list where address_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, address_id);
			pst.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
	


}
