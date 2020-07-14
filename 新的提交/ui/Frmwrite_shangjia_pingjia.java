package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmwrite_shangjia_pingjia extends JFrame implements ActionListener{
	private JTextField textField = new JTextField();;
	private JButton button = new JButton("确认添加");
	private final JLabel label_1 = new JLabel("星级评价:");
	private final JTextField textField_1 = new JTextField();
	private Beanshangping_order curorder=null;
	public Frmwrite_shangjia_pingjia(Beanshangping_order order) {
		curorder =order;
		textField_1.setBounds(130, 236, 96, 27);
		textField_1.setColumns(10);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 390);
		getContentPane().setLayout(null);
		
		
		textField.setBounds(15, 104, 499, 89);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("填写评价");
		label.setBounds(15, 53, 81, 21);
		getContentPane().add(label);
		
		
		button.setBounds(371, 265, 123, 29);
		getContentPane().add(button);
		label_1.setBounds(30, 239, 123, 21);
		
		getContentPane().add(label_1);
		
		getContentPane().add(textField_1);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.button) {
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="insert into shangjia_pingjia_table(order_id,user_id,pingjia_neirong,pingjia_date,satr) values(?,?,?,?,?) ";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1,curorder.getOrder_id());
				pst.setString(2, Beanuser.currentLoginUser.getUser_id());
				pst.setString(3, this.textField.getText());
				pst.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
				pst.setInt(5, Integer.valueOf(this.textField_1.getText()));
				pst.execute();
				pst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
	}
}
