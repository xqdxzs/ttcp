package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xml.internal.security.keys.content.x509.XMLX509Certificate;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beanorder;
import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.util.DBUtil;
import cn.edu.zucc.ttcp.util.DbException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;



public class Frmuser_chakan_order extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton button = new JButton("填写商家评价");
	private JButton button_1 = new JButton("查看商品详情");
	private JButton btnNewButton = new JButton("填写骑手评价");
	private Object tblaorderData[][];
	DefaultTableModel taborderModel=new DefaultTableModel();
	private JTable dataTableorder=new JTable(taborderModel);
	private Object tblorderTitle[]=Beanshangping_order.tableTitles;
	
	List<Beanshangping_order> allorder = null;
	private Beanshangping_order curorder = null;
	private void reloadshangpinTable1(){//地址
		try {
			
			allorder= ttcpUtil.userGouwu.loadorder(Beanuser.currentLoginUser.getUser_id());
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblaorderData =  new Object[allorder.size()][Beanshangping_order.tableTitles.length];
		for(int i=0;i<allorder.size();i++){
			for(int j=0;j<Beanshangping_order.tableTitles.length;j++) {
				tblaorderData[i][j]=allorder.get(i).getCell(j);
			}
		}
		
		taborderModel.setDataVector(tblaorderData,tblorderTitle);
		this.dataTableorder.validate();
		this.dataTableorder.repaint();
	}
	private JScrollPane scrollPane = new JScrollPane(dataTableorder);
	public Frmuser_chakan_order() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 824, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		scrollPane.setBounds(25, 72, 744, 299);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("您的订单如下：");
		label.setBounds(54, 33, 167, 21);
		contentPane.add(label);
		
		
		button.setBounds(94, 419, 196, 52);
		contentPane.add(button);
		button.addActionListener(this);
		
		button_1.setBounds(485, 419, 196, 88);
		contentPane.add(button_1);
		button_1.addActionListener(this);
		JLabel lblTip = new JLabel("tip：请先选中订单");
		lblTip.setBounds(66, 386, 182, 21);
		contentPane.add(lblTip);
		
		
		btnNewButton.setBounds(104, 507, 186, 41);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		JLabel lblNewLabel = new JLabel("tip:订单状态需要是“songda”");
		lblNewLabel.setBounds(61, 484, 229, 18);
		contentPane.add(lblNewLabel);
		this.reloadshangpinTable1();
		 this.dataTableorder.addMouseListener(new MouseAdapter (){//优惠选择

				@Override
				public void mouseClicked(MouseEvent e) {
					int i=Frmuser_chakan_order.this.dataTableorder.getSelectedRow();
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
			if (curorder==null) {
				JOptionPane.showMessageDialog(null,"请选中订单", "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Frmwrite_shangjia_pingjia write = new Frmwrite_shangjia_pingjia(curorder);
			write.setVisible(true);
		}
		else if (e.getSource() == this.button_1) {
			Frm_order_xiangxi order =new Frm_order_xiangxi(curorder.getOrder_id());
			order.setVisible(true);
			
		}
		else if(e.getSource() == this.btnNewButton) {
			Frmwrite_rider_pingjia xx = new Frmwrite_rider_pingjia(curorder);
			xx.setVisible(true);
		}
		
	}
}
