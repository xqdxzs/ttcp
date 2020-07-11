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

public class Frmadmin_add_leibie extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_1= new JTextField();
	private JLabel lblNewLabel_1;
	private JTextField textField_2=new JTextField();
	private JLabel label_1;
	private JTextField textField_3=new JTextField();
	private JButton button=new JButton("确认添加");
	private JButton button_1=new JButton("退出");

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
	public Frmadmin_add_leibie() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 301);
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
		
		lblNewLabel_1 = new JLabel("类别名称：");
		lblNewLabel_1.setBounds(14, 89, 97, 18);
		contentPane.add(lblNewLabel_1);

		textField_2.setBounds(125, 86, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		label_1 = new JLabel("商品数量：");
		label_1.setBounds(14, 135, 75, 18);
		contentPane.add(label_1);
		

		textField_3.setBounds(125, 132, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		button.setBounds(14, 190, 97, 35);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(125, 190, 112, 35);
		contentPane.add(button_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.button) {
			try {
				ttcpUtil.adminshangjiaguanli.addleibie(Integer.valueOf(this.textField_1.getText()), this.textField_2.getText(),Integer.valueOf(this.textField_3.getText()));
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
