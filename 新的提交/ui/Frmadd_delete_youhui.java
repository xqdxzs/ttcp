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
	private final JLabel label_2 = new JLabel("集单要求数：");
	private final JTextField textField_3 = new JTextField();
	private final JLabel label_3 = new JLabel("优惠券时间（天）:");
	private final JTextField textField_4 = new JTextField();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Frmadd_delete_youhui() {
		textField_4.setBounds(188, 160, 86, 24);
		textField_4.setColumns(10);
		textField_3.setBounds(188, 123, 86, 24);
		textField_3.setColumns(10);
		textField.setBounds(152, 282, 86, 24);
		textField.setColumns(10);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("商家序号：");
		lblNewLabel.setBounds(14, 41, 97, 18);
		contentPane.add(lblNewLabel);

		textField_1.setBounds(188, 38, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("优惠金额：");
		lblNewLabel_1.setBounds(14, 89, 97, 18);
		contentPane.add(lblNewLabel_1);

		textField_2.setBounds(188, 86, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		button.setBounds(14, 206, 97, 35);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(152, 206, 112, 35);
		contentPane.add(button_1);
		
		btnNewButton.setBounds(76, 327, 141, 35);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		label.setBounds(14, 285, 97, 18);
		
		contentPane.add(label);
		
		contentPane.add(textField);
		label_1.setBounds(14, 254, 250, 18);
		
		contentPane.add(label_1);
		label_2.setBounds(14, 126, 112, 18);
		
		contentPane.add(label_2);
		
		contentPane.add(textField_3);
		label_3.setBounds(14, 163, 178, 18);
		
		contentPane.add(label_3);
		
		contentPane.add(textField_4);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.button) {
			try {
				ttcpUtil.adminshangjiaguanli.addyouhui(Integer.valueOf(this.textField_1.getText()),Integer.valueOf(this.textField_2.getText()),Integer.valueOf(this.textField_3.getText()) ,Integer.valueOf(this.textField_4.getText()));
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
