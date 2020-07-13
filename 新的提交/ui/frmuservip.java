package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.hibernate.loader.plan.exec.query.internal.SelectStatementBuilder;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.glass.events.WindowEvent;

import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;
import sun.security.timestamp.Timestamper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class frmuservip extends JFrame implements ActionListener {

	private static final Timestamp NullPointerException = null;
	private JPanel contentPane;
	private JButton button = new JButton("确认充值");
	private JButton button_1 = new JButton("我选择白嫖");
	private final JLabel lblrday = new JLabel("15R/month(获得4张vip券）");
	private final JLabel lblNewLabel = new JLabel(this.xianshi());
	private final JRadioButton radioButton = new JRadioButton("30天");


	public frmuservip() {
		
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 352, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("充值时间:");
		label.setBounds(14, 68, 82, 18);
		contentPane.add(label);
		
		JLabel lblVip = new JLabel("vip到期时间：");
		lblVip.setBounds(14, 109, 105, 18);
		contentPane.add(lblVip);
		
		
		button.setBounds(14, 156, 113, 27);
		contentPane.add(button);
		button.addActionListener( this);
		
		button_1.setBounds(163, 156, 113, 27);
		contentPane.add(button_1);
		lblrday.setBounds(27, 27, 224, 24);
		
		contentPane.add(lblrday);
		lblNewLabel.setBounds(129, 109, 157, 18);
		
		contentPane.add(lblNewLabel);
		radioButton.setBounds(106, 64, 59, 27);
		
		contentPane.add(radioButton);
		button_1.addActionListener(this);
	
	}
	Timestamp A = NullPointerException;
	public String xianshi() {
			String str = null;
			if (Beanuser.currentLoginUser.getVip()==0) {
				str = "你还不是vip";
				A = new java.sql.Timestamp(System.currentTimeMillis());
			}
			else {
				str=Beanuser.currentLoginUser.getVip_deadline();
				A =Timestamp.valueOf(Beanuser.currentLoginUser.getVip_deadline());
			}
		return str;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.button) {
			int day=0;
			if(radioButton.isSelected()) {
				day=30;
			}
			else {
				JOptionPane.showMessageDialog(null,"您未勾选时间","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			xianshi();
			A=new java.sql.Timestamp(A.getTime()+30*86400000L);
			JOptionPane.showMessageDialog(null,String.valueOf(A));
			try {
				ttcpUtil.userManager.loginuser(Beanuser.currentLoginUser.getUser_id(), Beanuser.currentLoginUser.getPassword());
			} catch (BaseException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}////尝试刷新未遂
			this.setVisible(false);
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="update user_information_table set vip_deadline=? ,vip=1";
				java.sql.PreparedStatement pst =conn.prepareStatement(sql);
				pst.setTimestamp(1, A);
				pst.execute();
				pst.close();
				
				sql ="select max(user_youhui_id) from youhui_information_table";
				int user_youhui_id=1;
				pst=conn.prepareStatement(sql);
				java.sql.ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					user_youhui_id= rs.getInt(1)+1;
				}
				rs.close();
				pst.close();
				//System.out.print(user_youhui_id);
				
				sql="insert into youhui_information_table(user_youhui_id,user_id,youhui_id,shangjia_id,youhui,number,start_time,deadline) values(?,?,0,0,6.6,4,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, user_youhui_id);
				pst.setString(2, Beanuser.currentLoginUser.getUser_id());
				Timestamp B = new java.sql.Timestamp(System.currentTimeMillis());
				Timestamp C = new java.sql.Timestamp(System.currentTimeMillis()+30*86400000L);
				pst.setTimestamp(3, B);
				pst.setTimestamp(4, C);
				pst.execute();
				pst.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
				try {
					throw new DbException(e2);
				} catch (DbException e1) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			finally{
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
		}
		else if(e.getSource()==this.button_1) {
			JOptionPane.showMessageDialog(null,"不充钱怎么变强？");
			this.setVisible(false);
		}
	}
	
}
