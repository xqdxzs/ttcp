package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xpath.internal.operations.And;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.itf.IUserManager;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.BusinessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class frmuizhuce extends JFrame implements ActionListener{

	private JPanel contentPane= new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	private JTextField textField_5;
	private JLabel label_5;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JRadioButton radioButton;
	private JRadioButton rdbtnNewRadioButton;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frmuizhuce frame = new frmuizhuce();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public frmuizhuce() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 510);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户注册");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		label.setBounds(92, -13, 122, 59);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("账号:");
		label_1.setBounds(14, 54, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("密码:");
		label_2.setBounds(14, 98, 72, 18);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(98, 51, 204, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 95, 204, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 140, 204, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("二次确认:");
		label_3.setBounds(14, 143, 72, 18);
		contentPane.add(label_3);
		
		label_4 = new JLabel("昵称：");
		label_4.setBounds(14, 184, 72, 18);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 181, 204, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel = new JLabel("电话号码:");
		lblNewLabel.setBounds(14, 227, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(98, 224, 204, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_1 = new JLabel("邮箱:");
		lblNewLabel_1.setBounds(14, 270, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(98, 267, 204, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		label_5 = new JLabel("城市:");
		label_5.setBounds(14, 315, 72, 18);
		contentPane.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(98, 312, 204, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnNewButton = new JButton("立即注册");
		btnNewButton.setBounds(89, 406, 113, 27);
		contentPane.add(btnNewButton);
		
		radioButton = new JRadioButton("男");
		radioButton.setBounds(84, 365, 83, 27);
		contentPane.add(radioButton);
		
		 rdbtnNewRadioButton = new JRadioButton("女");
		rdbtnNewRadioButton.setBounds(173, 365, 72, 27);
		contentPane.add(rdbtnNewRadioButton);
		btnNewButton.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(rdbtnNewRadioButton);//将按钮绑定在一起，只能选中一个
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnNewButton) {
			String userid = this.textField.getText();
			String pwd = this.textField_1.getText();
			String pwd2 = this.textField_2.getText();
			String name = this.textField_3.getText();
			String telepohone = this.textField_4.getText();
			String email = this.textField_5.getText();
			String city = this.textField_6.getText();
			String sex="";
			//System.out.println(this.radioButton);
			if(radioButton.isSelected()) {
				 sex ="nan";
			}
			else if (btnNewButton.isSelected()){
				 sex ="nv";
			}
			else {
				sex="";
			}
			
			try {
				Beanuser user =ttcpUtil.userManager.reg(userid, pwd, pwd2, name, telepohone, email, city, sex );
				JOptionPane.showMessageDialog(null,"注册成功");
			}catch (BaseException e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e1.getMessage(),"发生错误，输入格式不正确", JOptionPane.ERROR_MESSAGE);
				return ;
			}
		}	
	}
}
