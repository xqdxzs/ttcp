package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmxiadan extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton = new JButton("立即下单");

	public Frmxiadan(float youhui,float heji,Beanyouhui youhuiquan) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("优惠共计："+youhui+"元");
		lblNewLabel.setBounds(30, 31, 121, 44);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("实际支付："+heji +"元");
		label.setBounds(30, 79, 121, 44);
		contentPane.add(label);
		
		
		btnNewButton.setBounds(199, 165, 113, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//try {
//	conn=DBUtil.getConnection();
//	if (curyouhui.getNumber()==1) {
//		String sql ="delete from youhui_information_table where user_youhui_id=?";
//		java.sql.PreparedStatement pst = conn.prepareStatement(sql);	
//		pst.setInt(1, curyouhui.getUser_youhui_id());
//		pst.execute();
//		pst.close();
//	}
//	else if (curyouhui.getNumber()>1) {
//		String sql="update youhui_information_table set number = ? where user_youhui_id=?";
//		java.sql.PreparedStatement pst =conn.prepareStatement(sql);
//		pst.setInt(1,curyouhui.getNumber()-1);
//		pst.setInt(2, curyouhui.getUser_youhui_id());
//		pst.execute();
//		pst.close();
//	}
//
//
//}catch (Exception e1) {
//	e1.printStackTrace();
//}