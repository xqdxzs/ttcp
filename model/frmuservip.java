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

import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.glass.events.WindowEvent;

import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmuservip extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField=new JTextField();
	private JButton button = new JButton("确认充值");
	private JButton button_1 = new JButton("我选择白嫖");
	private final JLabel lblrday = new JLabel("1R/day");
	private final JLabel lblNewLabel = new JLabel(this.xianshi());


	public frmuservip() {
		
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 337, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("充值金额：");
		label.setBounds(14, 68, 82, 18);
		contentPane.add(label);
		
		
		textField.setBounds(119, 65, 175, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblVip = new JLabel("vip到期时间：");
		lblVip.setBounds(14, 109, 105, 18);
		contentPane.add(lblVip);
		
		
		button.setBounds(14, 156, 113, 27);
		contentPane.add(button);
		button.addActionListener( this);
		
		button_1.setBounds(163, 156, 113, 27);
		contentPane.add(button_1);
		lblrday.setBounds(105, 23, 122, 24);
		
		contentPane.add(lblrday);
		lblNewLabel.setBounds(129, 109, 165, 18);
		
		contentPane.add(lblNewLabel);
		button_1.addActionListener(this);
	
	}
	public String xianshi() {
			String str = null;
			if (Beanuser.currentLoginUser.getVip()==0) {
				str = "你还不是vip";
			}
			else {
				str=Beanuser.currentLoginUser.getVip_deadline();
			}
		return str;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.button) {
			int day=Integer.parseInt(textField.getText());
			
			Timestamp A =Timestamp.valueOf(Beanuser.currentLoginUser.getVip_deadline());
			A=new Timestamp(A.getTime()+day*86400000);
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
				String sql="update user_information_table set vip_deadline=? where vip=1";
				java.sql.PreparedStatement pst =conn.prepareStatement(sql);
				pst=conn.prepareStatement(sql);
				pst.setTimestamp(1, A);
			
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
