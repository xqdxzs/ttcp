package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;
public class frmui extends JFrame implements ActionListener{

	private JPanel contentPane=new JPanel();
//	private JTextField textField_2;
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frmui frame = new frmui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	private JLabel label_1 = new JLabel(" 密码:");
	JButton button_1 = new JButton("用户登录");
	JButton button = new JButton("管理员登录");
	JButton button_2 = new JButton("注册");
	JLabel label = new JLabel("用户名:");
	JLabel lblTtcp = new JLabel("ttcp外卖");
	
	
	
	public frmui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 220);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label_1.setToolTipText("密码不可为空，长度不可大于20");
		label_1.setBounds(25, 90, 72, 18);
		contentPane.add(label_1);
		

		button_1.setBounds(141, 126, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(this);

		button.setBounds(14, 126, 113, 27);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_2.setForeground(Color.BLACK);
		button_2.setBounds(268, 126, 113, 27);
		contentPane.add(button_2);
		button_2.addActionListener(this);
		

		label.setBounds(25, 54, 72, 18);
		contentPane.add(label);
		

		textField_1.setBounds(90, 50, 244, 27);
		contentPane.add(textField_1);
		textField_2.setColumns(10);
		
		textField_2.setBounds(90, 86, 244, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblTtcp.setFont(new Font("宋体", Font.PLAIN, 18));
		lblTtcp.setBounds(163, 13, 101, 31);
		contentPane.add(lblTtcp);
		
		contentPane.add(textField_2);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.button_2) {
			frmuizhuce frame1 = new frmuizhuce();
			frame1.setVisible(true);
		}
		else if(e.getSource()==this.button){
			System.out.print("111111111");
		}
		else if(e.getSource()==this.button_1) {
			System.out.print("2222222");
		}
	}
}
