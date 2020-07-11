package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.comtrol.example.ExampleUserGouwu;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frmaddgouwuche extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField=new JTextField();
	private int shangping_id;
	private String shangping_name;
	private float price;
	private JButton button = new JButton("添加");
	private JLabel label = new JLabel("请选择数量：");
	private JButton button_1 = new JButton("返回界面");
	/**
	 * Launch the application.
	 */
	private int shangjia_id;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frmaddgouwuche frame = new Frmaddgouwuche();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public int getShangjia_id() {
		return shangjia_id;
	}
	public void setShangjia_id(int shangjia_id) {
		this.shangjia_id = shangjia_id;
	}
	/**
	 * Create the frame.
	 */
	public Frmaddgouwuche() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		button.setBounds(8, 92, 113, 27);
		contentPane.add(button);
		button.addActionListener(this);
		
		
		textField.setBounds(141, 38, 119, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label.setBounds(8, 41, 119, 18);
		contentPane.add(label);
		
		
		button_1.setBounds(147, 92, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(this);
	}
	public int getShangping_id() {
		return shangping_id;
	}
	public void setShangping_id(int shangping_id) {
		this.shangping_id = shangping_id;
	}
	public String getShangping_name() {
		return shangping_name;
	}
	public void setShangping_name(String shangping_name) {
		this.shangping_name = shangping_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int loadnumber() {
		return Integer.valueOf(this.textField.getText());
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.button) {
			//System.out.print(this.shangping_id+ this.shangping_name+this.price+this.loadnumber());
			try {
				ttcpUtil.userGouwu.addshangping(this.shangping_id, this.shangping_name,this.price, this.loadnumber(),this.shangjia_id);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//ExampleUserGouwu.this.addshangping(shangping_id, shangping_name, price, this.loadnumber());
		//	ExampleUserGouwu.this.addshangping(this.getShangping_id(),this.getShangping_name(),this.getPrice(),this.loadnumber());
			this.setVisible(false);
		}
		else if(e.getSource() == this.button_1) {
			this.setVisible(false);
		}
	}
}
