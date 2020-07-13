package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beanadmin;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.model.Beanyouhui1;
import cn.edu.zucc.ttcp.util.BaseException;
import javafx.application.Application;


public class Frmchakan_user_youhui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    

	private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
//	private Object tblPlanTitle[]=BeanPlan.tableTitles;
	private Object tblPlanData[][];
	DefaultTableModel tabPlanModel=new DefaultTableModel();
	private JTable dataTablePlan2=new JTable(tabPlanModel);
	private JTable dataTablePlan3=new JTable(tabPlanModel);
	
//	private Object tblStepTitle[]=BeanStep.tblStepTitle;
	private Object tblleibieData[][];
	DefaultTableModel tableibieModel=new DefaultTableModel();
	private JTable dataTableleibie=new JTable(tableibieModel);
	
	private Object tblshangpingData[][];
	DefaultTableModel tabshangpingModel=new DefaultTableModel();
	private JTable dataTabshangping=new JTable(tabshangpingModel);
	
	private Beanyouhui1 curshangjia=null;
	private Beanshangping_leibie curleibie=null;
	private Beanshangping_xiangxi curshangping=null;
	
	private Object tblshangjiaData[][];
	DefaultTableModel tabshangjiaModel=new DefaultTableModel();
	private JTable dataTableshangjia=new JTable(tabshangjiaModel);
	
	private Object tblgouwucheData[][];
	DefaultTableModel tabgouwucheModel=new DefaultTableModel();
	private JTable dataTablegouwuche=new JTable(tabgouwucheModel);
	
	private Object tblleibieTitle[]=Beanyouhui.tableTitles1;	
	
	private Object tblshangpingTitle[]=Beanshangping_xiangxi.tblStepTitle;	

	private Object tblshangjiaTitle[]=Beanyouhui1.tableTitles;
	
	private Object tblgouwucheTitle[]=Beangouwuche.tblStepTitle;
	
	List<Beanyouhui1> allshangjia=null;
	List<Beanyouhui> leibie=null;

	private Component dataTableStep;
	


	private void reloadshangping_fenlei(){//商品类别

		try {
			leibie=ttcpUtil.userGouwu.chakanuser_youhui(Beanuser.currentLoginUser.getUser_id());
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblleibieData =new Object[leibie.size()][Beanyouhui.tableTitles1.length];
		for(int i=0;i<leibie.size();i++){
			for(int j=0;j<Beanyouhui.tableTitles1.length;j++)
				tblleibieData[i][j]=leibie.get(i).getCell1(j);
			
		}
		
		tableibieModel.setDataVector(tblleibieData,tblleibieTitle);
		this.dataTableleibie.validate();
		this.dataTableleibie.repaint();
	}
	
	public Frmchakan_user_youhui(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("用户优惠券信息情况");
//		dlgLogin=new FrmLogin(this,"登陆",true);
//		dlgLogin.setVisible(true);
	    //菜单
		


	    this.setJMenuBar(menubar);
	    
	    this.getContentPane().add(new JScrollPane(this.dataTableleibie), BorderLayout.CENTER);
	    this.reloadshangping_fenlei();
//	    this.dataTableshangjia.addMouseListener(new MouseAdapter (){
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				//System.out.print("2222");
//				int i=Frmchakan_user_youhui.this.dataTableshangjia.getSelectedRow();
//				if(i<0) {
//					return;
//				}
//				Frmchakan_user_youhui.this.reloadshangping_fenlei(i);
//			}
//	    	
//	    });
//	    this.getContentPane().add(new JScrollPane(this.dataTableleibie), BorderLayout.CENTER);//商品分类
	
	   
	    
	    
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!用户:"+Beanuser.currentLoginUser.getName()+"所有优惠券信息如下：");
		    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.NORTH);
	
	    this.setVisible(true);
	}

	protected void dataTableleibie(int i) {
	// TODO Auto-generated method stub
	
}
	protected void dataTablePlan2(int i) {
		// TODO Auto-generated method stub
		
	}
	private void reloadPlanTable() {
		// TODO Auto-generated method stub
		
	}
	private void reloadShoppingCarTable() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 		
	}
	private void addshangping(int shangping_id, String shangping_name, float price, int loadnumber) {
		// TODO Auto-generated method stub
		
	}
	
//	private void reloadPlanStepTabel(int planIdx){
//		if(planIdx<0) return;
//		curPlan=allPlan.get(planIdx);
//		try {
//			planSteps=PersonPlanUtil.stepManager.loadSteps(curPlan);
//		} catch (BaseException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		tblStepData =new Object[planSteps.size()][BeanStep.tblStepTitle.length];
//		for(int i=0;i<planSteps.size();i++){
//			for(int j=0;j<BeanStep.tblStepTitle.length;j++)
//				tblStepData[i][j]=planSteps.get(i).getCell(j);
//		}
//		
//		tabStepModel.setDataVector(tblStepData,tblStepTitle);
//		this.dataTableStep.validate();
//		this.dataTableStep.repaint();
//	}
	
}
