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
import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beanadmin;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import javafx.application.Application;


public class Frmchakan_manjian extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_plan=new JMenu("商品购买");
    private JMenu menu_step=new JMenu("地址管理");
    private JMenu menu_static=new JMenu("查询统计");
    private JMenu menu_more=new JMenu("更多");
    
    private JMenuItem  menuItem_AddPlan=new JMenuItem("商品添加");
    private JMenuItem  menuItem_DeletePlan=new JMenuItem("删除商品");//没做
    private JMenuItem  menuItem_xiadan=new JMenuItem("下单");//没做
    private JMenuItem  menuItem_Addaddress=new JMenuItem("添加配送地址");
    private JMenuItem  menuItem_Deleteaddress=new JMenuItem("删除配送地址");
    private JMenuItem  menuItem_startStep=new JMenuItem("查看地址");
    private JMenuItem  menuItem_finishStep=new JMenuItem("结束步骤");
    private JMenuItem  menuItem_moveUpStep=new JMenuItem("步骤上移");
    private JMenuItem  menuItem_moveDownStep=new JMenuItem("步骤下移");
    
    private JMenuItem  menuItem_modifyPwd=new JMenuItem("密码修改");
    private JMenuItem  menuItem_modifyvip=new JMenuItem("充值vip");
    private JMenuItem  menuItem_modifyF5=new JMenuItem("刷新");
    private JMenuItem  menuItem_static1=new JMenuItem("统计1");

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
	

	
	private Beanshangjia_xingxi curshangjia=null;
	
	private Object tblmanjianData[][];
	DefaultTableModel tabmanjianModel=new DefaultTableModel();
	private JTable dataTablemanjian=new JTable(tabmanjianModel);

	

	private Object tblmanjianTitle[]=Beanmanjian.tableTitles;
	
	List<Beanmanjian> alladdmanjian=null;
	
	private Component dataTableStep;
	

	private void reloadshangpinTable(){//商家界面
		try {
			
			alladdmanjian = ttcpUtil.adminshangjiaguanli.loadmanjian();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblmanjianData =  new Object[alladdmanjian.size()][Beanmanjian.tableTitles.length];
		for(int i=0;i<alladdmanjian.size();i++){
			for(int j=0;j<Beanmanjian.tableTitles.length;j++) {
				tblmanjianData[i][j]=alladdmanjian.get(i).getCell(j);
			}
		}
		
		tabmanjianModel.setDataVector(tblmanjianData,tblmanjianTitle);
		this.dataTablemanjian.validate();
		this.dataTablemanjian.repaint();
	}
	public Frmchakan_manjian(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	//	this.setExtendedState(Frame.DISPOSE_ON_CLPSE);
		this.setTitle("满减信息");
//		dlgLogin=new FrmLogin(this,"登陆",true);
//		dlgLogin.setVisible(true);
	    //菜单
		

	    
	    this.getContentPane().add(new JScrollPane(this.dataTablemanjian), BorderLayout.CENTER);
	    this.reloadshangpinTable();
	    
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!尊敬的管理员:"+Beanadmin.currentLoginUser.getAdmin_name()+"满减方案如下：");
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.NORTH);
//	    this.addWindowListener(new WindowAdapter(){   //结束整个系统
//	    	public void windowClosing(WindowEvent e){ 
//	    		System.exit(0);
//             }
//        });
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
//		 if(e.getSource()==this.menuItem_modifyPwd){
//				FrmModifyPwd dlg=new FrmModifyPwd(this,"密码修改",true);
//				dlg.setVisible(true);
//			}
//		 if(e.getSource()==this.menuItem_modifyvip) {//vip
//			 	frmuservip vip = new frmuservip() ;
//			 	vip.setVisible(true);
//		 }
//		 if (e.getSource()==this.menuItem_modifyF5) {//刷新
//			 this.reloadshangpinTable();
//		      this.reloadshangpinTable();
//		      this.validate();
//		   this.repaint();
//		      this.setVisible(false);
//		   this.setVisible(true);
//		      
//		}
//		if(e.getSource()==this.menuItem_AddPlan){//购物车
//			Frmaddgouwuche add = new Frmaddgouwuche();
//			add.setShangping_id(curshangping.getShangping_id());
//			add.setShangping_name(curshangping.getShangping_name());
//			add.setPrice(curshangping.getPrice());
//			add.setShangjia_id(curshangjia.getShangjia_id());
//			add.setVisible(true);	
//		}
//		if(e.getSource()==this.menuItem_xiadan) {//结算
//			
//			
//			
//		}
//		if(e.getSource()==this.menuItem_Addaddress) {//添加地址
//			Frmadd_address addaddress = new Frmadd_address();
//			addaddress.setVisible(true);
//		}
//		if(e.getSource()==this.menuItem_startStep) {//查看地址
			
		}
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
		
//	}
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
