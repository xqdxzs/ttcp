package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmadmin_add_shangjia extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField=new JTextField();
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
	public Frmadmin_add_shangjia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("商家序号：");
		label.setBounds(14, 41, 97, 18);
		contentPane.add(label);
		

		textField.setBounds(125, 38, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("商家名称：");
		lblNewLabel.setBounds(238, 41, 97, 18);
		contentPane.add(lblNewLabel);

		textField_1.setBounds(349, 38, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("商家星级：");
		lblNewLabel_1.setBounds(14, 89, 97, 18);
		contentPane.add(lblNewLabel_1);

		textField_2.setBounds(125, 86, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		label_1 = new JLabel("人均消费：");
		label_1.setBounds(234, 89, 75, 18);
		contentPane.add(label_1);
		

		textField_3.setBounds(349, 86, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		button.setBounds(72, 143, 113, 27);
		contentPane.add(button);
		button.addActionListener(this);

		button_1.setBounds(280, 143, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.button) {
			
		}
		else if(arg0.getSource() == this.button_1) {
			this.setVisible(false);
		}
	}

}
