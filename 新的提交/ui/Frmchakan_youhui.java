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


public class Frmchakan_youhui extends JFrame implements ActionListener {
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
	
	private Object tblleibieTitle[]=Beanyouhui.tableTitles;	
	
	private Object tblshangpingTitle[]=Beanshangping_xiangxi.tblStepTitle;	

	private Object tblshangjiaTitle[]=Beanyouhui1.tableTitles;
	
	private Object tblgouwucheTitle[]=Beangouwuche.tblStepTitle;
	
	List<Beanyouhui1> allshangjia=null;
	List<Beanyouhui> leibie=null;

	private Component dataTableStep;
	

	private void reloadshangpinTable(){//商家界面
		try {
			
			allshangjia = ttcpUtil.adminshangjiaguanli.loadyouhui1();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblshangjiaData =  new Object[allshangjia.size()][Beanyouhui1.tableTitles.length];
		for(int i=0;i<allshangjia.size();i++){
			for(int j=0;j<Beanyouhui1.tableTitles.length;j++) {
				tblshangjiaData[i][j]=allshangjia.get(i).getCell(j);
			}
		}
		
		tabshangjiaModel.setDataVector(tblshangjiaData,tblshangjiaTitle);
		this.dataTableshangjia.validate();
		this.dataTableshangjia.repaint();
	}
	private void reloadshangping_fenlei(int planIdx){//商品类别
		if(planIdx<0) return;
		curshangjia=allshangjia.get(planIdx);
		try {
			leibie=ttcpUtil.adminshangjiaguanli.loadyouhui(curshangjia);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblleibieData =new Object[leibie.size()][Beanyouhui.tableTitles.length];
		for(int i=0;i<leibie.size();i++){
			for(int j=0;j<Beanyouhui.tableTitles.length;j++)
				tblleibieData[i][j]=leibie.get(i).getCell(j);
			
		}
		
		tableibieModel.setDataVector(tblleibieData,tblleibieTitle);
		this.dataTableleibie.validate();
		this.dataTableleibie.repaint();
	}
	
	public Frmchakan_youhui(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("优惠券信息情况");
//		dlgLogin=new FrmLogin(this,"登陆",true);
//		dlgLogin.setVisible(true);
	    //菜单
		


	    this.setJMenuBar(menubar);
	    
	    this.getContentPane().add(new JScrollPane(this.dataTableshangjia), BorderLayout.WEST);//商家
	    this.reloadshangpinTable();
	    this.dataTableshangjia.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.print("2222");
				int i=Frmchakan_youhui.this.dataTableshangjia.getSelectedRow();
				if(i<0) {
					return;
				}
				Frmchakan_youhui.this.reloadshangping_fenlei(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableleibie), BorderLayout.CENTER);//商品分类
	
	   
	    
	    
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!尊敬的管理员:"+Beanadmin.currentLoginUser.getAdmin_name()+"所有优惠券信息如下：");
		    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.NORTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		System.exit(0);
             }
        });
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
		 
//		else if(e.getSource()==this.menuItem_DeletePlan){
//			if(this.curPlan==null) {
//				JOptionPane.showMessageDialog(null, "请选择计划", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			try {
//				PersonPlanUtil.planManager.deletePlan(this.curPlan);
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		}
//		else if(e.getSource()==this.menuItem_AddStep){
//			FrmAddStep dlg=new FrmAddStep(this,"添加步骤",true);
//			dlg.plan=curPlan;
//			dlg.setVisible(true);
//		}
//		else if(e.getSource()==this.menuItem_DeleteStep){
//			int i=FrmMain.this.dataTableStep.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null, "请选择步骤", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			try {
//				PersonPlanUtil.stepManager.deleteStep(this.planSteps.get(i));
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		}
//		else if(e.getSource()==this.menuItem_startStep){
//			int i=FrmMain.this.dataTableStep.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null, "请选择步骤", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			try {
//				PersonPlanUtil.stepManager.startStep(this.planSteps.get(i));
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		}
//		else if(e.getSource()==this.menuItem_finishStep){
//			int i=FrmMain.this.dataTableStep.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null, "请选择步骤", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			try {
//				PersonPlanUtil.stepManager.finishStep(this.planSteps.get(i));
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		}
//		else if(e.getSource()==this.menuItem_moveUpStep){
//			int i=FrmMain.this.dataTableStep.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null, "请选择步骤", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			try {
//				PersonPlanUtil.stepManager.moveUp(this.planSteps.get(i));
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		}
//		else if(e.getSource()==this.menuItem_moveDownStep){
//			int i=FrmMain.this.dataTableStep.getSelectedRow();
//			if(i<0) {
//				JOptionPane.showMessageDialog(null, "请选择步骤", "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			try {
//				PersonPlanUtil.stepManager.moveDown(this.planSteps.get(i));
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		}
//		else if(e.getSource()==this.menuItem_static1){
//			
//		}
		
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
