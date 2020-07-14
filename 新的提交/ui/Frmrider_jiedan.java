package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.DBUtil;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Frmrider_jiedan extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton button = new JButton("确认接单");
	private Object tblaorderData[][];
	DefaultTableModel taborderModel=new DefaultTableModel();
	private JTable dataTableorder=new JTable(taborderModel);
	private Object tblorderTitle[]=Beanshangping_order.tableTitles1;
	
	List<Beanshangping_order> allorder = null;
	private Beanshangping_order curorder = null;
	private void reloadshangpinTable1(){//地址
		try {
			
			allorder= ttcpUtil.adminshangjiaguanli.loadorder_peisong();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblaorderData =  new Object[allorder.size()][Beanshangping_order.tableTitles1.length];
		for(int i=0;i<allorder.size();i++){
			for(int j=0;j<Beanshangping_order.tableTitles1.length;j++) {
				tblaorderData[i][j]=allorder.get(i).getCell1(j);
			}
		}
		
		taborderModel.setDataVector(tblaorderData,tblorderTitle);
		this.dataTableorder.validate();
		this.dataTableorder.repaint();
	}
	private JScrollPane scrollPane = new JScrollPane(dataTableorder);
	public Frmrider_jiedan() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		scrollPane.setBounds(15, 115, 734, 265);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("订单表");
		label.setBounds(27, 67, 81, 21);
		contentPane.add(label);
		
		
		button.setBounds(498, 472, 105, 29);
		contentPane.add(button);
		button.addActionListener(this);
		JLabel label_1 = new JLabel("骑手编号：");
		label_1.setBounds(27, 31, 107, 21);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(149, 28, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		this.reloadshangpinTable1();
		 this.dataTableorder.addMouseListener(new MouseAdapter (){//优惠选择

				@Override
				public void mouseClicked(MouseEvent e) {
					int i=Frmrider_jiedan.this.dataTableorder.getSelectedRow();
					if(i<0) {
						return;
					}
					curorder =allorder.get(i);
				}
				
		    });
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.button) {
			Connection conn=null;
			try {
				if (curorder==null) {
					JOptionPane.showMessageDialog(null,"请选择订单", "错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				conn=DBUtil.getConnection();
				float a=(float) 3.0;
				String sql = "update shangping_order_table set order_zhuangtai=? where order_id=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, "songda");
				pst.setInt(2, curorder.getOrder_id());
				
			
				pst.execute();
				pst.close();
				
				sql="insert into rider_order_table(rider_id,order_id,order_time,order_money) values(?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, Integer.valueOf(this.textField.getText()));
				pst.setInt(2, curorder.getOrder_id());
				pst.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
				pst.setFloat(4,a);
				pst.execute();
				pst.close();
				
				sql="update rider_information_table set order_number=order_number+1 where rider_id=?";
				pst=conn.prepareStatement(sql);
				pst.setInt(1, Integer.valueOf(this.textField.getText()));
				pst.execute();
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,"接单完毕");
		}
	}

}
