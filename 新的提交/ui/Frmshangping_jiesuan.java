package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Util;
import com.sun.glass.ui.TouchInputSupport;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Frmshangping_jiesuan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table = new JTable();
	private JTable table_1 = new JTable();
	private JLabel lblNewLabel = new JLabel();
	private JButton btnNewButton = new JButton("优惠显示");
	private JLabel lblNewLabel_2 = new JLabel("件商品");
	
	private int shangjia_id;

	private float sum = sum();
	private int id;
	private float youhui;
	private int number =number();
	
	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
	}
	private JLabel lblNewLabel_1 = new JLabel();
	
	private Object tblyouhuiData[][];
	DefaultTableModel tabyouhuiModel=new DefaultTableModel();
	private JTable dataTableyouhui=new JTable(tabyouhuiModel);
	private Object tblyouhuiTitle[]=Beanyouhui.tableTitles2;
	
	private Object tblmanjianDate[][];
	DefaultTableModel tabmanjianModel=new DefaultTableModel();
	private JTable dataTablemanjian=new JTable(tabmanjianModel);
	private Object tblmanjianTitle[]=Beanmanjian.tableTitles;
	
	List<Beanyouhui> allyouhjui = null;
	List<Beanmanjian> allmanjian = null;
	
	private Beanyouhui curyouhui = null;
	private Beanmanjian curmanjian = null;

	//float youhui1;
	JScrollPane scrollPane_1 = new JScrollPane(this.dataTableyouhui);
	JScrollPane scrollPane_2 = new JScrollPane(this.dataTablemanjian);
	private void reloadshangpinTable1(){//优惠
		try {
			
			allyouhjui= ttcpUtil.userGouwu.loadyouhui_2(Beanuser.currentLoginUser.getUser_id(),id);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblyouhuiData =  new Object[allyouhjui.size()][Beanyouhui.tableTitles2.length];
		for(int i=0;i<allyouhjui.size();i++){
			for(int j=0;j<Beanyouhui.tableTitles2.length;j++) {
				tblyouhuiData[i][j]=allyouhjui.get(i).getCell2(j);
			}
		}
		
		tabyouhuiModel.setDataVector(tblyouhuiData,tblyouhuiTitle);
		this.dataTableyouhui.validate();
		this.dataTableyouhui.repaint();
	}
	private void reloadshangpinTable2(){//满减
		try {
			
			allmanjian = ttcpUtil.userGouwu.loadmanjian_jiesuan(id);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblmanjianDate =  new Object[allmanjian.size()][Beanmanjian.tableTitles.length];
		for(int i=0;i<allmanjian.size();i++){
			for(int j=0;j<Beanmanjian.tableTitles.length;j++) {
				tblmanjianDate[i][j]=allmanjian.get(i).getCell(j);
			}
		}
		
		tabmanjianModel.setDataVector(tblmanjianDate,tblmanjianTitle);
		this.dataTablemanjian.validate();
		this.dataTablemanjian.repaint();
	}
	
	public Frmshangping_jiesuan(int shangjia_id) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		lblNewLabel_1.setText("商家id："+String.valueOf(shangjia_id));
		this.id=shangjia_id;
		
		lblNewLabel.setText("合计:"+sum+"元");
		
		lblNewLabel_2.setText(this.number+"件商品");
		setBounds(100, 100, 798, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		lblNewLabel.setBounds(158, 45, 222, 41);
		contentPane.add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(14, 13, 103, 18);
		contentPane.add(lblNewLabel_1);
		
		
//		table.setBounds();
//		contentPane.add(table);
		
		JLabel label = new JLabel("优惠券：");
		label.setBounds(14, 134, 72, 18);
		contentPane.add(label);
		
//		table_1 = new JTable();
//		table_1.setBounds();
//		contentPane.add(table_1);
		
		JLabel label_1 = new JLabel("满减方案选择:");
		label_1.setBounds(445, 134, 128, 18);
		contentPane.add(label_1);
		
		btnNewButton.setBounds(303, 461, 179, 52);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		lblNewLabel_2.setBounds(95, 45, 134, 41);
		contentPane.add(lblNewLabel_2);
		
		
		scrollPane_1.setBounds(24, 165, 351, 266);
		contentPane.add(scrollPane_1);
		this.reloadshangpinTable1();
		this.reloadshangpinTable2();
		 this.dataTableyouhui.addMouseListener(new MouseAdapter (){//优惠选择

				@Override
				public void mouseClicked(MouseEvent e) {
					int i=Frmshangping_jiesuan.this.dataTableyouhui.getSelectedRow();
					if(i<0) {
						return;
					}
					curyouhui =allyouhjui.get(i);
				}
				
		    });
		 this.dataTablemanjian.addMouseListener(new MouseAdapter (){//满减选择

				@Override
				public void mouseClicked(MouseEvent e) {
					int i=Frmshangping_jiesuan.this.dataTablemanjian.getSelectedRow();
					if(i<0) {
						return;
					}
					curmanjian=allmanjian.get(i);
				}
				
		    });
		this.getContentPane().add(scrollPane_1);
		
		scrollPane_2.setBounds(389, 165, 391, 266);
		contentPane.add(scrollPane_2);
		
		this.getContentPane().add(scrollPane_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnNewButton) {
			youhui();
			Frmxiadan xiadan =new Frmxiadan(youhui,sum-youhui,curyouhui);
			//System.out.print(curyouhui.getUser_youhui_id());
			xiadan.setVisible(true);
			youhui=0;
		}
	}
	public float sum() {
			float sum=0;
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select price,number from gouwuche_table where user_id=?";
				java.sql.PreparedStatement pst =conn.prepareStatement(sql);
				pst.setString(1, Beanuser.currentLoginUser.getUser_id());
				java.sql.ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					sum=sum+rs.getFloat(1)*rs.getInt(2);
				}
				pst.execute();
				pst.close();
				
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return sum;
	}
	public int number() {
		int number=0;
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="select price,number from gouwuche_table where user_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, Beanuser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				number = number +rs.getInt(2);
			}
			pst.execute();
			pst.close();
			
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return number;
}
	public float youhui() {
		
		Connection conn=null;
		if (curyouhui==null ) {
			if (curmanjian.getManjian_amount()<sum) {
				youhui=youhui+curmanjian.getYouhui_amount();
			}
			else {
				JOptionPane.showMessageDialog(null,"不满足满减要求", "错误",JOptionPane.ERROR_MESSAGE);

			}
			return youhui;
		}
		if (curmanjian==null) {
			Timestamp a = new java.sql.Timestamp(System.currentTimeMillis());
			Timestamp b = new java.sql.Timestamp(curyouhui.getDeadline().getTime());
			if(a.before(a)) {
				JOptionPane.showMessageDialog(null,"优惠券已经过期", "错误",JOptionPane.ERROR_MESSAGE);
			}
			else  {
				youhui=youhui+curyouhui.getYouhui();
		
			}
			return youhui;
		}
		if (curmanjian==null & curyouhui==null) {
			return 0;
		}
		Timestamp a = new java.sql.Timestamp(System.currentTimeMillis());
		Timestamp b = new java.sql.Timestamp(curyouhui.getDeadline().getTime());
		if(a.before(a)) {
			JOptionPane.showMessageDialog(null,"优惠券已经过期", "错误",JOptionPane.ERROR_MESSAGE);
		}
		else  {
			youhui=youhui+curyouhui.getYouhui();
		
		}
		if (curmanjian.getManjian_amount()<sum) {
			youhui=youhui+curmanjian.getYouhui_amount();
		}
		else {
			JOptionPane.showMessageDialog(null,"不满足满减要求", "错误",JOptionPane.ERROR_MESSAGE);

		}
		return youhui;
		
	}
	public void adduser_youhui_id(){
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="select price,number from gouwuche_table where user_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, Beanuser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				number = number +rs.getInt(2);
			}
			pst.execute();
			pst.close();
			
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
