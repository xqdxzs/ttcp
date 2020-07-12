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
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Frmadmin_add_manjian extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField();;
	private JTextField textField_1 = new JTextField();;
	private JTextField textField_2 = new JTextField();;
	private JButton button = new JButton("确认添加");
	private JButton button_1 = new JButton("退出");
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("可叠加优惠券");
	private Object textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmadmin_add_manjian frame = new Frmadmin_add_manjian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frmadmin_add_manjian() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("输入需要添加满减方案的商家序号：");
		label.setBounds(14, 24, 304, 27);
		contentPane.add(label);
		
		textField.setBounds(266, 25, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("满足满减的初始金额：");
		label_1.setBounds(14, 64, 153, 24);
		contentPane.add(label_1);
		
		textField_1.setBounds(266, 64, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("优惠金额：");
		label_2.setBounds(14, 109, 153, 18);
		contentPane.add(label_2);
		
		
		rdbtnNewRadioButton.setBounds(108, 136, 187, 52);
		contentPane.add(rdbtnNewRadioButton);
		
		textField_2.setBounds(266, 101, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		button.setBounds(14, 197, 113, 27);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(206, 197, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.button) {
			int diejia=0;
			if (rdbtnNewRadioButton.isSelected())  
				 diejia=1;
	
			try {
				ttcpUtil.adminshangjiaguanli.addmanjian(Integer.valueOf(this.textField.getText()), Integer.valueOf(this.textField_1.getText()),Integer.valueOf(this.textField_2.getText()),diejia);
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
