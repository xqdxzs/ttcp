package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Frmxiadan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmxiadan frame = new Frmxiadan();
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
	public Frmxiadan() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("所以商品共计：");
		lblNewLabel.setBounds(31, 32, 306, 44);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnvip = new JRadioButton("使用vip优惠券");
		rdbtnvip.setBounds(31, 129, 157, 27);
		contentPane.add(rdbtnvip);
		
		JLabel label = new JLabel("合计：");
		label.setBounds(28, 179, 72, 18);
		contentPane.add(label);
	}
}
