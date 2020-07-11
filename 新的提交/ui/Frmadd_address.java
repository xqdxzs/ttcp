package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmadd_address extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField();
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField();
	private JTextField textField_4 = new JTextField();
	private JButton button = new JButton("确认添加");
	private JButton button_1 = new JButton("放弃编辑");
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Frmadd_address() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("省：");
		label.setBounds(31, 38, 112, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(165, 39, 130, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("市：");
		lblNewLabel.setBounds(31, 96, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("区：");
		label_1.setBounds(31, 149, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("联系电话：");
		label_2.setBounds(31, 210, 112, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("具体地址：");
		label_3.setBounds(31, 257, 112, 18);
		contentPane.add(label_3);
		
		
		button.setBounds(30, 327, 130, 27);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_1.setBounds(182, 327, 130, 27);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		
		textField_1.setBounds(165, 93, 130, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		

		textField_2.setBounds(165, 146, 130, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

		textField_3.setBounds(165, 207, 130, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		

		textField_4.setBounds(165, 254, 130, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.button) {
			
	try {
		ttcpUtil.userManager.add_address(Beanuser.currentLoginUser.getUser_id(), this.textField.getText(), this.textField_1.getText(), this.textField_2.getText(),this.textField_3.getText(),this.textField_4.getText());
	} catch (BaseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	this.setVisible(false);
		}
		else if(e.getSource() == this.button_1) {
			this.setVisible(false);
		}
	}
}
