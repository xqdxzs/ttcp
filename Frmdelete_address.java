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

public class Frmdelete_address extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField=new JTextField();
	private JButton button = new JButton("确认删除");
	private JButton button_1 = new JButton("放弃删除");

	public Frmdelete_address() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入你想删除的地址编号：");
		label.setBounds(40, 13, 243, 44);
		contentPane.add(label);
		

		textField.setBounds(265, 23, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		button.setBounds(51, 83, 113, 27);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_1.setBounds(214, 83, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button) {
			try {
				ttcpUtil.userManager.delete_address(Integer.valueOf(this.textField.getText()));
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_1) {
			this.setVisible(false);
		}
	}

}
