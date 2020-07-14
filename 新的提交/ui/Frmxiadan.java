package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Frmxiadan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton = new JButton("立即下单");
	
	private Object tbladdressData[][];
	DefaultTableModel tabaddressModel=new DefaultTableModel();
	private JTable dataTableaddress=new JTable(tabaddressModel);
	private Object tbladdressTitle[]=BeanAddress.tableTitles;
	
	List<BeanAddress> alladdress = null;
	private BeanAddress curaddress = null;
	private void reloadshangpinTable1(){//地址
		try {
			
			alladdress= ttcpUtil.userManager.loadaddresss();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tbladdressData =  new Object[alladdress.size()][BeanAddress.tableTitles.length];
		for(int i=0;i<alladdress.size();i++){
			for(int j=0;j<BeanAddress.tableTitles.length;j++) {
				tbladdressData[i][j]=alladdress.get(i).getCell(j);
			}
		}
		
		tabaddressModel.setDataVector(tbladdressData,tbladdressTitle);
		this.dataTableaddress.validate();
		this.dataTableaddress.repaint();
	}
	
	private Beanyouhui curyouhui = null;
	private Beanmanjian curmanjian = null;
	private int shangjia_idd=0 ;
	private float sum;
	private float youhuijiage;
	JScrollPane scrollPane = new JScrollPane(dataTableaddress);
	private int as[] = new int [20];
	public Frmxiadan(float youhui,float heji,Beanyouhui youhuiquan,Beanmanjian manjian, int shangjia_id) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		curyouhui = youhuiquan;
		curmanjian = manjian;
		shangjia_idd=shangjia_id;
		youhuijiage=youhui;
		sum=heji;
		setBounds(100, 100, 663, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("优惠共计："+youhui+"元");
		lblNewLabel.setBounds(30, 31, 155, 44);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("实际支付："+(heji-youhui) +"元");
		label.setBounds(30, 79, 196, 44);
		contentPane.add(label);
		
		
		btnNewButton.setBounds(487, 386, 113, 27);
		contentPane.add(btnNewButton);
		
		
		scrollPane.setBounds(30, 171, 601, 174);
		contentPane.add(scrollPane);
		
		JLabel label_1 = new JLabel("地址选择：");
		label_1.setBounds(30, 140, 121, 18);
		contentPane.add(label_1);
		btnNewButton.addActionListener(this);
		
		this.reloadshangpinTable1();
		 this.dataTableaddress.addMouseListener(new MouseAdapter (){//优惠选择

				@Override
				public void mouseClicked(MouseEvent e) {
					int i=Frmxiadan.this.dataTableaddress.getSelectedRow();
					if(i<0) {
						return;
					}
					curaddress =alladdress.get(i);
				}
				
		    });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnNewButton) {
			
			if (curaddress == null) {
				JOptionPane.showMessageDialog(null,"请选择配送地址", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Connection conn=null;
			int order_id=1;
			try {
				conn=DBUtil.getConnection();
				
				String sql ="select max(order_id) from shangping_order_table";//查看订单号
				java.sql.PreparedStatement pst = conn.prepareStatement(sql);
				java.sql.ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					order_id=rs.getInt(1)+1;
				}
				rs.close();
				pst.close();
//
				List<Beangouwuche> gouwuch =new  ArrayList<Beangouwuche>();
				sql = "select shangping_id,price,number from gouwuche_table where user_id=? ";
				pst=conn.prepareStatement(sql);
				pst.setString(1, Beanuser.currentLoginUser.getUser_id());
				 rs =pst.executeQuery();
				 int count=0;
				while(rs.next()) {
					Beangouwuche p = new Beangouwuche();
					p.setShangping_id(rs.getInt(1));
					p.setPrice(rs.getFloat(2));
					p.setNumber(rs.getInt(3));
					gouwuch.add(p);
					count++;
				}
				pst.execute();
				pst.close();
				rs.close();
				///余量修改
				for(int i=0;i<count;i++) {
					sql = "select yuliang from shangping_xiangxi_table where shangping_id=?";
					pst=conn.prepareStatement(sql);
					pst.setInt(1,gouwuch.get(i).getShangping_id() );
					rs = pst.executeQuery();
					while(rs.next()){
					as[i]=rs.getInt(1);
					//System.out.print(as[i]);
					if(rs.getInt(1)<gouwuch.get(i).getNumber()) {
						JOptionPane.showMessageDialog(null,"商品余量不足，请修改购物数量", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					}
					pst.execute();
					pst.close();
					rs.close();
					for(int j=0;j<=i;j++) {
						sql = "update shangping_xiangxi_table set yuliang =? where shangping_id=?";
						pst=conn.prepareStatement(sql);
						pst.setInt(1, as[j]-gouwuch.get(j).getNumber());
						pst.setInt(2, gouwuch.get(j).getShangping_id());
						pst.execute();
						pst.close();
					}
					
				}
				//扣除优惠券
				try {
					if(curyouhui!=null)
					if (curyouhui.getNumber()==1) {
						 sql ="delete from youhui_information_table where user_youhui_id=?";
						 pst = conn.prepareStatement(sql);	
						pst.setInt(1, curyouhui.getUser_youhui_id());
						pst.execute();
						pst.close();
					}
					else if (curyouhui.getNumber()>1) {
					 sql="update youhui_information_table set number = ? where user_youhui_id=?";
						 pst =conn.prepareStatement(sql);
						pst.setInt(1,curyouhui.getNumber()-1);
						pst.setInt(2, curyouhui.getUser_youhui_id());
						pst.execute();
						pst.close();
					}					


				}catch (Exception e1) {
					e1.printStackTrace();
				}
				//新增订单详细
				sql = "insert into shangping_order_table(order_id,address_id,manjian_id,user_id,youhui_id,yuanjia,shijijiage,order_time,required_time,order_zhuangtai) values(?,?,?,?,?,?,?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, order_id);
				pst.setInt(2, curaddress.getAddress_id());
				if (curmanjian==null) {
					pst.setNull(3, 0);
				}
				else {
					pst.setInt(3, curmanjian.getManjian_id());
				}
				pst.setString(4, Beanuser.currentLoginUser.getUser_id());
				if (curyouhui==null) {
					pst.setNull(5, 0);
				}
				else {
					pst.setInt(5, curyouhui.getYouhui_id());
				}
				pst.setFloat(6, sum);
				pst.setFloat(7, sum-youhuijiage);
				Timestamp A = new java.sql.Timestamp(System.currentTimeMillis());
				Timestamp B = new java.sql.Timestamp(System.currentTimeMillis()+30*60*1000L);
 				pst.setTimestamp(8,A );
				pst.setTimestamp(9, B);
				pst.setString(10, "peisong_ing");
				pst.execute();
				pst.close();
				this.setVisible(false);//加订单表
				
				
				
				//添加商品订单表
				sql = "insert into order_table(order_id,shangping_id,number,price) values(?,?,?,?)";
				
				for(int i=0;i<count;i++) {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, order_id);
				pst.setInt(2, gouwuch.get(i).getShangping_id());
				pst.setInt(3, gouwuch.get(i).getNumber());
				pst.setFloat(4, gouwuch.get(i).getPrice());
				pst.execute();
				}
				//清空购物车
				sql = "delete from gouwuche_table where user_id=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, Beanuser.currentLoginUser.getUser_id());;
				pst.execute();
				pst.close();
				//
				sql = "select shangjia_id from jidan_songquan_table where user_id=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, Beanuser.currentLoginUser.getUser_id());;
				 rs =pst.executeQuery();
				 int flag=0;
				 while(rs.next()) {
					 if(shangjia_idd==rs.getInt(1)) {
						 flag=1;
					 }
				 }
				 rs.close();
				 pst.close();
				  if(flag==1) {
					  sql="update jidan_songquan_table set order_number=order_number+1 where user_id=? and shangjia_id=?";
					  pst = conn.prepareStatement(sql);
					  pst.setString(1, Beanuser.currentLoginUser.getUser_id());;
					  pst.setInt(2, shangjia_idd);
					  pst.execute();
					  pst.close();
				  }
				  else {
					  
					  int day=0;int requests=0;int youhui_idd = 0; 
					  sql="select time_of_day,requests_number,youhui_id from youhui_tbale where shangjia_id=? ";
					  pst = conn.prepareStatement(sql);
					  pst.setInt(1, shangjia_idd);
					  rs =pst.executeQuery();
					  while(rs.next()) {
						  day=rs.getInt(1);
						  requests=rs.getInt(2);
						  youhui_idd=rs.getInt(3);
					  }
					  rs.close();
					  pst.close();
					  sql="insert into jidan_songquan_table"
					  		+ "(user_id,youhui_id,shangjia_id,requests_number,order_number,time_of_day) "
					  		+ "values(?,?,?,?,?,?)";
					  pst = conn.prepareStatement(sql);
					  pst.setString(1, Beanuser.currentLoginUser.getUser_id());
					  pst.setInt(2, youhui_idd);
					  pst.setInt(3, shangjia_idd);
					  pst.setInt(4, requests);
					  pst.setInt(5, 1);
					  pst.setInt(6, day);
					  pst.execute();
					  pst.close();
					 // System.out.print(youhui_idd+"   ");
				  }
				  //商家增加销量
				  	sql= "update shangjia_xingxi_table set total_sales=total_sales+1 where shangjia_id=?";
				  	 pst = conn.prepareStatement(sql);
				  	 pst.setInt(1, shangjia_idd);
				  	 pst.execute();
				  	 pst.close();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
			//System.out.print(shangjia_idd+"   ");
			
		}
	}
}
