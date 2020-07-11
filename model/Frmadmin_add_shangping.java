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

public class Frmadmin_add_shangping extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_1= new JTextField();
	private JLabel lblNewLabel_1;
	private JTextField textField_2=new JTextField();
	private JLabel label_1;
	private JTextField textField_3=new JTextField();
	private JButton button=new JButton("确认添加");
	private JButton button_1=new JButton("退出");
	private  JLabel lblNewLabel_2 = new JLabel("  余量：");
	private  JTextField textField_4 = new JTextField();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frmadmin_add_shangjia frame = new Frmadmin_add_shangjia();
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
	public Frmadmin_add_shangping() {
		textField_4.setBounds(125, 165, 86, 24);
		textField_4.setColumns(10);
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("类别序号：");
		lblNewLabel.setBounds(14, 41, 97, 18);
		contentPane.add(lblNewLabel);

		textField_1.setBounds(125, 38, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel(" 商品名：");
		lblNewLabel_1.setBounds(14, 89, 97, 18);
		contentPane.add(lblNewLabel_1);

		textField_2.setBounds(125, 86, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		label_1 = new JLabel("  价格：");
		label_1.setBounds(14, 135, 75, 18);
		contentPane.add(label_1);
		

		textField_3.setBounds(125, 123, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		button.setBounds(14, 202, 97, 35);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(131, 202, 112, 35);
		contentPane.add(button_1);
		lblNewLabel_2.setBounds(14, 171, 72, 18);
		
		contentPane.add(lblNewLabel_2);
		
		contentPane.add(textField_4);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.button) {
			try {
				ttcpUtil.adminshangjiaguanli.addshangping(Integer.valueOf(this.textField_1.getText()),this.textField_2.getText(),Float.parseFloat(this.textField_3.getText()),Integer.valueOf(this.textField_4.getText()));
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
