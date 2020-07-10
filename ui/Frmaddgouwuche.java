package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.ttcp.ttcpUtil;
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

	private JButton button = new JButton("添加");
	private JLabel label = new JLabel("数量：");

	private JLabel lblNewLabel = new JLabel("New label");
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Frmaddgouwuche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		button.setBounds(37, 176, 113, 27);
		contentPane.add(button);
		button.addActionListener(this);
		
		lblNewLabel.setBounds(25, 65, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField.setBounds(93, 121, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label.setBounds(25, 124, 72, 18);
		contentPane.add(label);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.button) {
			
			this.setVisible(false);
		}	
	}
}
