package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmadd_delete_youhui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_1= new JTextField();
	private JLabel lblNewLabel_1;
	private JTextField textField_2=new JTextField();
	private JButton button=new JButton("确认添加");
	private JButton button_1=new JButton("退出");
	private  JButton btnNewButton = new JButton("删除优惠券");
	private final JLabel label = new JLabel("优惠券序号：");
	private  JTextField textField = new JTextField();
	private final JLabel label_1 = new JLabel("————————————————");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Frmadd_delete_youhui() {
		textField.setBounds(125, 211, 86, 24);
		textField.setColumns(10);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("商家序号：");
		lblNewLabel.setBounds(14, 41, 97, 18);
		contentPane.add(lblNewLabel);

		textField_1.setBounds(125, 38, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("优惠金额：");
		lblNewLabel_1.setBounds(14, 89, 97, 18);
		contentPane.add(lblNewLabel_1);

		textField_2.setBounds(125, 86, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		button.setBounds(14, 140, 97, 35);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(137, 140, 112, 35);
		contentPane.add(button_1);
		
		btnNewButton.setBounds(37, 257, 141, 35);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		label.setBounds(14, 214, 97, 18);
		
		contentPane.add(label);
		
		contentPane.add(textField);
		label_1.setBounds(14, 183, 250, 18);
		
		contentPane.add(label_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.button) {
			try {
				ttcpUtil.adminshangjiaguanli.addyouhui(Integer.valueOf(this.textField_1.getText()),Integer.valueOf(this.textField_2.getText()) );
			} catch (NumberFormatException | BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
		}
		else if(arg0.getSource() == this.btnNewButton) {
			try {
				ttcpUtil.adminshangjiaguanli.deleteyouhui(Integer.valueOf(this.textField.getText()));
			} catch (NumberFormatException | BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
		}
		else if(arg0.getSource() == this.button_1) {
			this.setVisible(false);
		}
	}

}
