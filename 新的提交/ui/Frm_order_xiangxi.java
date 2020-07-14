package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beanorder;
import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Frm_order_xiangxi extends JFrame implements ActionListener{

	private JPanel contentPane;

	private Object tblaorderData[][];
	DefaultTableModel taborderModel=new DefaultTableModel();
	private JTable dataTableorder=new JTable(taborderModel);
	private Object tblorderTitle[]=Beanorder.tableTitles;
	
	List<Beanorder> allorder = null;
	private int order_id;
	private void reloadshangpinTable1(){//地址
		try {
			
			allorder= ttcpUtil.userGouwu.loadorder_xiangxi(order_id);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblaorderData =  new Object[allorder.size()][Beanorder.tableTitles.length];
		for(int i=0;i<allorder.size();i++){
			for(int j=0;j<Beanorder.tableTitles.length;j++) {
				tblaorderData[i][j]=allorder.get(i).getCell(j);
			}
		}
		
		taborderModel.setDataVector(tblaorderData,tblorderTitle);
		this.dataTableorder.validate();
		this.dataTableorder.repaint();
	}


	public Frm_order_xiangxi(int id) {
		// TODO Auto-generated constructor stubsetDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		order_id=id;
		setBounds(100, 100, 519, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(dataTableorder);
		scrollPane.setBounds(27, 81, 427, 183);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("商品详细：");
		label.setBounds(27, 46, 81, 21);
		contentPane.add(label);
		this.reloadshangpinTable1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
