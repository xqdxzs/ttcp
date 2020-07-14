package cn.edu.zucc.ttcp.comtrol.example;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanadmin;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanjidan;
import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanorder;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.util.BaseException;
import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.itf.IUserGouwu;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;
import sun.print.resources.serviceui;

public class ExampleUserGouwu implements IUserGouwu {
	
	public Beanshangping_xiangxi addshangping(String name) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Beanshangjia_xingxi> loadAll() throws BaseException {
		List<Beanshangjia_xingxi> result=new ArrayList<Beanshangjia_xingxi>();
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from shangjia_xingxi_table";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			
			java.sql.ResultSet rs =pst.executeQuery();
			
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				Beanshangjia_xingxi p=new Beanshangjia_xingxi();
				p.setShangjia_id(rs.getInt(1));
				p.setShangjia_name(rs.getString(2));
				p.setShangjia_star(rs.getInt(3));
				p.setRenjunxf(rs.getFloat(4));
				result.add(p);
			}
			pst.close();
			rs.close();
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
	public List<Beanshangping_leibie> loadleibie(Beanshangjia_xingxi shangjia) throws BaseException {
		List<Beanshangping_leibie> result=new ArrayList<Beanshangping_leibie>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select category_name,category_id,shangping_number from shangping_leibie_table where shangjia_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setInt(1,shangjia.getShangjia_id());
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) {
			//	System.out.print(rs.getString(1));
				Beanshangping_leibie p=new Beanshangping_leibie();
				p.setCategory_name(rs.getString(1));
				p.setCategory_id(rs.getInt(2));
				p.setShangping_number(rs.getInt(3));
				result.add(p);
			}
			pst.close();
			rs.close();
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
	public List<Beanshangping_xiangxi> loadshagnping(Beanshangping_leibie leibie)throws BaseException {
		List<Beanshangping_xiangxi> result=new ArrayList<Beanshangping_xiangxi>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select shangping_id,shangping_name,price,youhui,yuliang from shangping_xiangxi_table where category_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setInt(1,leibie.getCategory_id());
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				Beanshangping_xiangxi p=new Beanshangping_xiangxi();
				p.setShangping_id(rs.getInt(1));
				p.setShangping_name(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setYouhui(rs.getFloat(4));
				p.setYuliang(rs.getInt(5));
				
				result.add(p);
			}
			pst.close();
			rs.close();
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

	public List<Beangouwuche> loadgouwuche() throws BaseException {
		
		String userid=Beanuser.currentLoginUser.getUser_id();
		Connection conn=null;
		List<Beangouwuche> result=new ArrayList<Beangouwuche>();
		try {
			conn=DBUtil.getConnection();
			String sql="select shangping_id,shangping_name,price,number,shangjia_id from gouwuche_table where user_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, userid);
			java.sql.ResultSet rs =pst.executeQuery();
		
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				Beangouwuche p=new Beangouwuche();		
				p.setShangping_id(rs.getInt(1));
				p.setShangping_name(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setNumber(rs.getInt(4));
				p.setShangjia_id(rs.getInt(5));
				result.add(p);
			}
			pst.close();
			rs.close();
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
	public Beangouwuche addshangping(int shangping_id,String shangping_name,float price,int number,int shangjia_id) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into gouwuche_table(user_id,shangping_id,"
					+ "shangping_name,price,number,shangjia_id) values(?,?,?,?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, Beanuser.currentLoginUser.getUser_id());//获取登录后的userid
			pst.setInt(2,shangping_id);
			pst.setString(3, shangping_name);
			pst.setFloat(4, price);
			pst.setInt(5, number);
			pst.setInt(6, shangjia_id);
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
	public Beanshangping_xiangxi update_yuliang(int number) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beanyouhui> chakanuser_youhui(String user_id) throws BaseException {
		Connection conn=null;
		List<Beanyouhui> result=new ArrayList<Beanyouhui>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select user_youhui_id,youhui_id,shangjia_id,youhui,number,start_time,deadline from youhui_information_table where user_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanyouhui p=new Beanyouhui();
				p.setUser_youhui_id(rs.getInt(1));
				p.setYouhui_id(rs.getInt(2));
				p.setShangjia_id(rs.getInt(3));
				p.setYouhui(rs.getFloat(4));
				p.setNumber(rs.getInt(5));
				p.setStart_time(rs.getTimestamp(6));
				p.setDeadline(rs.getTimestamp(7));

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
	public List<Beanjidan> chakanuser_jidan(String user_id) throws BaseException {
		Connection conn=null;
		List<Beanjidan> result=new ArrayList<Beanjidan>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select youhui_id,shangjia_id,requests_number,order_number ,time_of_day from jidan_songquan_table where user_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanjidan p=new Beanjidan();
				p.setYouhui_id(rs.getInt(1));
				p.setShangjia_id(rs.getInt(2));
				p.setRequests_number(rs.getInt(3));
				p.setOrder_number(rs.getInt(4));
				p.setTime_of_day(rs.getInt(5));
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
	public void lingqu_youhui(Beanjidan user_jidan) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		String user_id = user_jidan.getUser_id();
		int youhui_id = user_jidan.getYouhui_id();
		int shangjia_id = user_jidan.getShangjia_id();
		int requests_number = user_jidan.getRequests_number();
		int order_number = user_jidan.getOrder_number();
		int time_of_day = user_jidan.getTime_of_day();
	//	int day = user_jidan.get
		//int number
		try {
			if (order_number<requests_number) {
					JOptionPane.showMessageDialog(null, "集单数不足");
				
			}
			else if (order_number>=requests_number) {
				order_number=order_number-requests_number;
			}
			conn=DBUtil.getConnection();
			
			String sql="update jidan_songquan_table set order_number = ? where youhui_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setInt(1, order_number);
			pst.setInt(2, youhui_id);
			pst.execute();
			pst.close();
			
			int user_youhui_id=1;
			sql = "select  max(user_youhui_id) from youhui_information_table";
					pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				user_youhui_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			sql="insert into youhui_information_table(user_youhui_id,user_id,youhui_id,shangjia_id,youhui,number,start_time,deadline) values(?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, user_youhui_id);
			pst.setString(2, user_id);
			pst.setInt(3, youhui_id);
			pst.setInt(4, shangjia_id);
			pst.setInt(5, youhui_id);
			pst.setInt(6, 1);
			Timestamp A = new java.sql.Timestamp(System.currentTimeMillis());
			Timestamp B = new java.sql.Timestamp(A.getTime()+time_of_day*24*60*1000*60);
			pst.setTimestamp(7,A );
			pst.setTimestamp(8,B);
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
	public List<Beanyouhui> loadyouhui_2(String user_id, int shangjia_id) throws BaseException {
		Connection conn=null;
		List<Beanyouhui> result=new ArrayList<Beanyouhui>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select user_youhui_id,youhui_id,youhui,number,deadline from youhui_information_table where (user_id=? and shangjia_id=?) or shangjia_id=0 ";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			pst.setInt(2,shangjia_id);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanyouhui p=new Beanyouhui();
				p.setUser_youhui_id(rs.getInt(1));
				p.setYouhui_id(rs.getInt(2));
				p.setYouhui(rs.getFloat(3));
				p.setNumber(rs.getInt(4));
				p.setDeadline(rs.getTimestamp(5));
				result.add(p);
			}
			
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
	public List<Beanmanjian> loadmanjian_jiesuan(int shangjia_id) throws BaseException {
		Connection conn=null;
		List<Beanmanjian> result=new ArrayList<Beanmanjian>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select manjian_id,shangjia_id,manjian_amount,youhui_amount,diejia from manjian_fangan_table where shangjia_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setString(1,Beanuser.currentLoginUser.get_id());
			pst.setInt(1, shangjia_id);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				Beanmanjian p=new Beanmanjian();
				p.setManjian_id(rs.getInt(1));				
				p.setShangjia_id(rs.getInt(2));
				p.setManjian_amount(rs.getInt(3));
				p.setYouhui_amount(rs.getInt(4));
				int flag=1;
				if(rs.getInt(5)!=1) {
					flag=0;
				}
				p.setDiejia(flag);
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
	public List<Beanshangping_order> loadorder(String user_id) throws BaseException {
		Connection conn=null;
		List<Beanshangping_order> result=new ArrayList<Beanshangping_order>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select order_id,address_id,yuanjia,shijijiage,order_time,order_zhuangtai from shangping_order_table where user_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				Beanshangping_order p=new Beanshangping_order();
				p.setOrder_id(rs.getInt(1));
				p.setAddress_id(rs.getInt(2));
				p.setYuanjia(rs.getFloat(3));
				p.setShijijiage(rs.getFloat(4));
				p.setOrder_time(rs.getTimestamp(5));
				p.setOrder_zhuangtai(rs.getString(6));
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
	public List<Beanorder> loadorder_xiangxi(int order_id) throws BaseException {
		Connection conn=null;
		List<Beanorder> result=new ArrayList<Beanorder>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select order_id,shangping_id,number,price from order_table where order_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, order_id);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				//System.out.print(rs.getString(2));
				Beanorder p=new Beanorder();
				p.setOrder_id(rs.getInt(1));
				p.setShangping_id(rs.getInt(2));
				p.setNumber(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
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

	

}


