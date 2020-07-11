package cn.edu.zucc.ttcp.comtrol.example;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanadmin;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import java.sql.Connection; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String sql="select shangping_id,shangping_name,price,number from gouwuche_table where user_id=?";
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
}


