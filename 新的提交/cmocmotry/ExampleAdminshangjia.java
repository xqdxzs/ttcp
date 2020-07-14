package cn.edu.zucc.ttcp.comtrol.example;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.edu.zucc.ttcp.itf.Adminshangjia;
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanrider;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.model.Beanyouhui1;
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
			int number=0;
			conn=DBUtil.getConnection();
			 String sql="select count(category_id) from shangping_leibie_table where shangjia_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, shangjia_id);
			java.sql.ResultSet rs = pst.executeQuery();
			
			if(rs.next())
				number=rs.getInt(1);
			if(number>0) {
				JOptionPane.showMessageDialog(null,"该商家还存在商品分类或商品，请先删除","错误",JOptionPane.ERROR_MESSAGE);
				
			}
			
			sql="delete  from shangjia_xingxi_table where shangjia_id=?";
			 pst = conn.prepareStatement(sql);
			
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
			int number=0;
			conn=DBUtil.getConnection();
			 String sql="select count(shangping_id) from shangping_xiangxi_table where category_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, category_id);
			java.sql.ResultSet rs = pst.executeQuery();
			
			if(rs.next())
				number=rs.getInt(1);
			if(number>0) {
				JOptionPane.showMessageDialog(null,"该类别存在商品","错误",JOptionPane.ERROR_MESSAGE);
				
			}
			 sql="delete  from shangping_leibie_table where category_id=?";
			 pst = conn.prepareStatement(sql);
			
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

	@Override
	public Beanmanjian addmanjian(int shangjia_id, int manjian_amount, int youhui_amount, int diejia)
			throws BaseException {
		Connection conn=null;
		int manjian_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(manjian_id) from manjian_fangan_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				manjian_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into manjian_fangan_table(manjian_id,shangjia_id,manjian_amount,"
					+ "youhui_amount,diejia) values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,manjian_id);
			pst.setInt(2, shangjia_id);
			pst.setInt(3, manjian_amount);
			pst.setInt(4, youhui_amount);
			pst.setInt(5, diejia);
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
	public Beanmanjian deletemanjian(int manjian_id) throws BaseException {
		Connection conn=null;
		try {
			int number=0;
			conn=DBUtil.getConnection();			
			String sql="delete  from manjian_fangan_table where manjian_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, manjian_id);
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
	public Beanmanjian xiugaimanjian(int manjian_id, int shangjia_id, int manjian_amount, int youhui_amount, int diejia)
			throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
		
			String sql="update manjian_fangan_table set shangjia_id = ?,manjian_amount = ?, youhui_amount = ?,diejia=? where manjian_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);

			pst.setInt(1, shangjia_id);
			pst.setInt(2, manjian_amount);
			pst.setInt(3, youhui_amount);
			pst.setInt(4, diejia);
			pst.setInt(5, manjian_id);
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
	public List<Beanmanjian> loadmanjian() throws BaseException {
		Connection conn=null;
		List<Beanmanjian> result=new ArrayList<Beanmanjian>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select manjian_id,shangjia_id,manjian_amount,youhui_amount,diejia from manjian_fangan_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setString(1,Beanuser.currentLoginUser.get_id());
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
	public Beanrider addrider(String rider_name, Timestamp entry_date, String rider_sf, int oreder_number)
			throws BaseException {
		Connection conn = null;
		int rider_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(rider_id) from rider_information_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				rider_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into rider_information_table(rider_id,rider_name,entry_date,"
					+ "rider_sf,order_number) values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,rider_id);
			pst.setString(2, rider_name);
			pst.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setString(4, rider_sf);
			pst.setInt(5, oreder_number);
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
	public Beanrider deleterider(int rider_id) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();	
			 String sql="delete  from rider_information_table where rider_id=?";
			 java.sql.PreparedStatement pst = conn.prepareStatement(sql);
		
			pst.setInt(1, rider_id);
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
	public Beanrider xiugairider(int rider_id, String rider_name, String rider_xf, int order_number)
			throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
		
			String sql="update rider_information_table set rider_name = ?,rider_sf = ?, order_number = ?where rider_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);

			pst.setString(1, rider_name);
			pst.setString(2, rider_xf);
			pst.setInt(3, order_number);
			pst.setInt(4, rider_id);

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
	public List<Beanrider> loadrider() throws BaseException {
		Connection conn=null;
		List<Beanrider> result=new ArrayList<Beanrider>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select rider_id,rider_name,entry_date,rider_sf,order_number from rider_information_table";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanrider p=new Beanrider();
				p.setRider_id(rs.getInt(1));
				p.setRider_name(rs.getString(2));
				p.setEmtry_date(rs.getTimestamp(3));
				p.setRider_sf(rs.getString(4));
				p.setOrder_number(rs.getInt(5));
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
	public Beanyouhui1 addyouhui(int shangjia_id, float youhui,int requests_number,int time_of_day) throws BaseException {
		Connection conn = null;
		int youhui_id=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select max(youhui_id) from youhui_tbale";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				youhui_id=rs.getInt(1)+1;
				rs.close();
				pst.close();
			}
			rs.close();
			pst.close();
			
			 sql="insert into youhui_tbale(youhui_id,shangjia_id,youhui,requests_number,time_of_day) values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, youhui_id);
			pst.setInt(2, shangjia_id);
			pst.setFloat(3, youhui);
			pst.setInt(4, requests_number);
			pst.setInt(5, time_of_day);
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
	public Beanyouhui1 deleteyouhui(int youhui_id) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();	
			 String sql="delete from youhui_tbale where youhui_id=?";
			 java.sql.PreparedStatement pst = conn.prepareStatement(sql);
		
			pst.setInt(1, youhui_id);
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
	public List<Beanyouhui> loadyouhui(Beanyouhui1 youhui1) throws BaseException {
		Connection conn=null;
		List<Beanyouhui> result=new ArrayList<Beanyouhui>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select user_id,youhui,number,start_time,deadline from youhui_information_table where youhui_id=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, youhui1.getYouhui_id());
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanyouhui p=new Beanyouhui();
				p.setYouhui_id(youhui1.getYouhui_id());
				p.setShangjia_id(youhui1.getShangjia_id());
				p.setUser_id(rs.getString(1));
				p.setYouhui(rs.getFloat(2));
				p.setNumber(rs.getInt(3));
				p.setStart_time(rs.getTimestamp(4));
				p.setDeadline(rs.getTimestamp(5));
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
	public List<Beanyouhui1> loadyouhui1() throws BaseException {
		Connection conn=null;
		List<Beanyouhui1> result=new ArrayList<Beanyouhui1>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select youhui_id,shangjia_id,youhui,requests_number,time_of_day from youhui_tbale";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs =pst.executeQuery();
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanyouhui1 p=new Beanyouhui1();
				p.setYouhui_id(rs.getInt(1));
				p.setShangjia_id(rs.getInt(2));
				p.setYouhui(rs.getFloat(3));
				p.setRequests_number(rs.getInt(4));
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
	public List<Beanshangping_order> loadorder_peisong() throws BaseException {
		Connection conn=null;
		List<Beanshangping_order> result=new ArrayList<Beanshangping_order>();
		try {
			conn=DBUtil.getConnection();
			String sql = "select order_id,address_id,yuanjia,shijijiage,order_time ,required_time from shangping_order_table where order_zhuangtai=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "peisong_ing");
			java.sql.ResultSet rs =pst.executeQuery();
			
			while(rs.next()) { 	
				//System.out.print(rs.getString(2));
				Beanshangping_order p=new Beanshangping_order();
				p.setOrder_id(rs.getInt(1));
				p.setAddress_id(rs.getInt(2));
				p.setYuanjia(rs.getFloat(3));
				p.setShijijiage(rs.getFloat(4));
				p.setOrder_time(rs.getTimestamp(5));
				p.setRequired_time(rs.getTimestamp(6));
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
