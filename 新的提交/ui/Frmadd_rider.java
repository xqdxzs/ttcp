package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

public class Frmadd_rider extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_1= new JTextField();
	private JLabel lblNewLabel_1;
	private JTextField textField_2=new JTextField();
	private JLabel label_1;
	private JButton button=new JButton("确认添加");
	private JButton button_1=new JButton("退出");
	private JComboBox comboBox = new JComboBox();
	private final JLabel lblyymm = new JLabel("格式：yyyy-MM-dd HH:mm:ss");
	

	/**
	 * Create the frame.
	 */
	public Frmadd_rider() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("骑手姓名：");
		lblNewLabel.setBounds(14, 41, 97, 18);
		contentPane.add(lblNewLabel);

		textField_1.setBounds(125, 38, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("入职时间：");
		lblNewLabel_1.setBounds(14, 89, 97, 18);
		contentPane.add(lblNewLabel_1);

		textField_2.setBounds(125, 86, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		label_1 = new JLabel("骑手身份：");
		label_1.setBounds(14, 159, 75, 18);
		contentPane.add(label_1);

		button.setBounds(14, 190, 97, 35);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(125, 190, 112, 35);
		contentPane.add(button_1);
		

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Meng_xin", "regular_employee", "Dan_wang"}));
		comboBox.setBounds(125, 156, 86, 24);
		contentPane.add(comboBox);
		lblyymm.setBounds(14, 128, 276, 18);
		
		contentPane.add(lblyymm);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.button) {
			Timestamp T1 = Timestamp.valueOf(this.textField_2.getText());
			String a = String.valueOf(comboBox.getSelectedItem());
			//System.out.print(a);
			try {
				ttcpUtil.adminshangjiaguanli.addrider(this.textField_1.getText(), T1 ,a,0);
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
