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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Frmshangai_rider extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField();
	private JTextField textField_1 = new JTextField();
	private JTextField textField_3 = new JTextField();
	private JButton btnNewButton = new JButton("直接删除");
	private JButton btnNewButton_1 = new JButton("确认修改");
	private JButton btnNewButton_2 = new JButton("退出");
	private final JLabel lblTip = new JLabel("tip：直接删除只需要输入骑手号后按删除键");
	private final JComboBox comboBox = new JComboBox();


	
	public Frmshangai_rider() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("输入要删改的骑手号：");
		lblNewLabel.setBounds(14, 49, 154, 25);
		contentPane.add(lblNewLabel);
		
		textField.setBounds(182, 49, 131, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("骑手姓名：");
		lblNewLabel_3.setBounds(14, 140, 94, 18);
		contentPane.add(lblNewLabel_3);
		
		textField_1.setBounds(92, 137, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("骑手身份：");
		lblNewLabel_4.setBounds(192, 140, 98, 18);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton.setBounds(24, 261, 108, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("订单数：");
		lblNewLabel_2.setBounds(14, 196, 94, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_3.setBounds(92, 193, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		

		btnNewButton_1.setBounds(147, 261, 108, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_2.setBounds(263, 261, 108, 24);
		contentPane.add(btnNewButton_2);
		lblTip.setBounds(24, 94, 299, 18);
		
		contentPane.add(lblTip);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Meng_xin", "regular_employee", "Dan_wang"}));
		comboBox.setBounds(263, 137, 86, 24);
		
		contentPane.add(comboBox);
		btnNewButton_2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnNewButton) {
			try {
				ttcpUtil.adminshangjiaguanli.deleterider(Integer.valueOf(this.textField.getText()));
			} catch (NumberFormatException | BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
		else if (e.getSource() == this.btnNewButton_1) {
			try {
				ttcpUtil.adminshangjiaguanli.xiugairider(Integer.valueOf(this.textField.getText()),String.valueOf(textField_1.getText()), String.valueOf(comboBox.getSelectedItem()), Integer.valueOf(this.textField_3.getText()));
			} catch (NumberFormatException | BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			this.setVisible(false);
		}
		else if (e.getSource() == this.btnNewButton_2) {
			this.setVisible(false);
		}
	}

}
