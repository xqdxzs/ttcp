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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.persistence.criteria.Order;
import javax.swing.DefaultComboBoxModel;

public class Frmwrite_rider_pingjia extends JFrame implements ActionListener{;
	private JButton button = new JButton("确认添加");
	private Beanshangping_order curorder=null;
	private JComboBox comboBox = new JComboBox();
	public Frmwrite_rider_pingjia(Beanshangping_order order) {
		curorder =order;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 246);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("填写评价");
		label.setBounds(15, 53, 81, 21);
		getContentPane().add(label);
		
		
		button.setBounds(112, 116, 123, 29);
		getContentPane().add(button);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"好评", "差评"}));
		
		comboBox.setBounds(127, 51, 90, 24);
		getContentPane().add(comboBox);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.button) {
			Connection conn=null;
			try {
				if (curorder==null) {
					JOptionPane.showMessageDialog(null,"未选择订单", "错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int flag=0;
				if("好评".equals(comboBox.getSelectedItem().toString())) {
					flag=1;
				}
				else {
					flag=0;
				}
				conn=DBUtil.getConnection();//"songda".equals(curorder.getOrder_zhuangtai())
//				
//					System.out.print(curorder.getOrder_zhuangtai());
//					//JOptionPane.showMessageDialog(null,"该订单还没有被接单", "错误",JOptionPane.ERROR_MESSAGE);
//				//	return;
				
				String sql="update rider_order_table set user_pingjia=? where order_id=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, flag);
				pst.setInt(2,curorder.getOrder_id());
				
				pst.execute();
				pst.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
	}
}
