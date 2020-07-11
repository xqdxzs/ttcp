package cn.edu.zucc.ttcp.comtrol.example;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import cn.edu.zucc.ttcp.itf.Adminshangjia;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;

public class ExampleAdminshangjia implements Adminshangjia {
	
	public Beanshangjia_xingxi addshagnjia(String shangjia_name,int shangjia_star,float renjunxf)throws BaseException {
		Connection conn=null;
		int shangjia_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(shangjia_id) from shangjia_xingxi_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				shangjia_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into shangjia_xingxi_table(shangjia_id,shangjia_name,shangjia_star,"
					+ "renjunxf) values(?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,shangjia_id);
			pst.setString(2, shangjia_name);//获取登录后的userid
			pst.setInt(3, shangjia_star);
			pst.setFloat(4, renjunxf);
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

	public Beanshangjia_xingxi deleteshangjia(int shangjia_id) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete  from shangjia_xingxi_table where shangjia_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, shangjia_id);
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

	@Override
	public Beanshangjia_xingxi xiugaishangjia(int shangjia_id,String name, int shangjia_star, float renjunxf) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
		
			
			String sql="update shangjia_xingxi_table set shangjia_name = ?, shangjia_star = ?, renjunxf =? where shangjia_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);

			pst.setString(1, name);
			pst.setInt(2, shangjia_star);
			pst.setFloat(3, renjunxf);
			pst.setInt(4, shangjia_id);
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
	public Beanshangping_leibie addleibie(int shangjia_id, String category_name, int number) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		int category_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(category_id) from shangping_leibie_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				category_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into shangping_leibie_table(shangjia_id,category_name,category_id,"
					+ "shangping_number) values(?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,shangjia_id);
			pst.setString(2, category_name);
			pst.setInt(3, category_id);
			pst.setFloat(4, number);
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
	public Beanshangping_leibie deleteleibie(int category_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete  from shangping_leibie_table where category_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, category_id);
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

	@Override
	public Beanshangping_leibie xiugaileibie(int shangjia_id, String category_name, int category_id,
			int shangping_number) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
		
			String sql="update shangping_leibie_table set shangjia_id = ?,cagegory_name = ?, shangping_number = ? where category_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);

			pst.setInt(1, shangjia_id);
			pst.setString(2, category_name);
			pst.setInt(3, shangping_number);
			pst.setInt(4, category_id);
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
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beanshangping_xiangxi addshangping( int category_id, String shangping_name, float price,
			int yuliang) throws BaseException {
		Connection conn = null;
		int shangping_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(shangping_id) from shangping_xiangxi_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				shangping_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into shangping_xiangxi_table(shangping_id,category_id,shangping_name,"
					+ "price,yuliang) values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,shangping_id);
			pst.setInt(2, category_id);
			pst.setString(3, shangping_name);
			pst.setFloat(4, price);
			pst.setInt(5, yuliang);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beanshangping_xiangxi deleteshangping(int shangping_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete  from shangping_xiangxi_table where shangping_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, shangping_id);
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

	@Override
	public Beanshangping_xiangxi xiugaishangping(int shangping_id, int category_id, String shangping_name, float price,
			int yuliang) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
		
			String sql="update shangping_xiangxi_table set category_id = ?,shangping_name = ?, price = ?,yuliang=? where shangping_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);

			pst.setInt(1, category_id);
			pst.setString(2, shangping_name);
			pst.setFloat(3, price);
			pst.setInt(4, yuliang);
			pst.setInt(5, shangping_id);
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
		
		// TODO Auto-generated method stub
		return null;
	}
}
