package cn.edu.zucc.ttcp.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
//
//import cn.edu.zucc.personplan.model.BeanUser;
//import cn.edu.zucc.personplan.util.BaseException;
//import cn.edu.zucc.personplan.util.BusinessException;
//import cn.edu.zucc.personplan.util.DBUtil;
//import cn.edu.zucc.personplan.util.DbException;

import cn.edu.zucc.ttcp.itf.IUserManager;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;



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

	
	public Beanuser login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Beanuser user=new Beanuser();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			
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


	public void changePwd(Beanuser user, String oldPwd, String newPwd,String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
	
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
		
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
}
