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
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import javafx.application.Application;


public class FrmMain extends JFrame implements ActionListener {
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
	
	private Object tblshangpingData[][];
	DefaultTableModel tabshangpingModel=new DefaultTableModel();
	private JTable dataTabshangping=new JTable(tabshangpingModel);
	
	private Beanshangjia_xingxi curshangjia=null;
	private Beanshangping_leibie curleibie=null;
	private Beanshangping_xiangxi curshangping=null;
	
	private Object tblshangjiaData[][];
	DefaultTableModel tabshangjiaModel=new DefaultTableModel();
	private JTable dataTableshangjia=new JTable(tabshangjiaModel);
	
	private Object tblgouwucheData[][];
	DefaultTableModel tabgouwucheModel=new DefaultTableModel();
	private JTable dataTablegouwuche=new JTable(tabgouwucheModel);
	
	private Object tblleibieTitle[]=Beanshangping_leibie.tblStepTitle;	
	
	private Object tblshangpingTitle[]=Beanshangping_xiangxi.tblStepTitle;	

	private Object tblshangjiaTitle[]=Beanshangjia_xingxi.tableTitles;
	
	private Object tblgouwucheTitle[]=Beangouwuche.tblStepTitle;
	List<Beanshangjia_xingxi> allshangjia=null;
	List<Beanshangping_leibie> leibie=null;
	List<Beanshangping_xiangxi> shangping =null;
	List<Beangouwuche> gouwuche = null;
	private Component dataTableStep;
	

	private void reloadshangpinTable(){//商家界面
		try {
			
			allshangjia = ttcpUtil.userGouwu.loadAll();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblshangjiaData =  new Object[allshangjia.size()][Beanshangjia_xingxi.tableTitles.length];
		for(int i=0;i<allshangjia.size();i++){
			for(int j=0;j<Beanshangjia_xingxi.tableTitles.length;j++) {
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
			leibie=ttcpUtil.userGouwu.loadleibie(curshangjia);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblleibieData =new Object[leibie.size()][Beanshangping_leibie.tblStepTitle.length];
		for(int i=0;i<leibie.size();i++){
			for(int j=0;j<Beanshangping_leibie.tblStepTitle.length;j++)
				tblleibieData[i][j]=leibie.get(i).getCell(j);
			
		}
		
		tableibieModel.setDataVector(tblleibieData,tblleibieTitle);
		this.dataTableleibie.validate();
		this.dataTableleibie.repaint();
	}
	private void reloadshangping_xiangxi(int planIdx){//各种商品
		if(planIdx<0) return;
		curleibie=leibie.get(planIdx);
		try {
			shangping=ttcpUtil.userGouwu.loadshagnping(curleibie);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblshangpingData =new Object[shangping.size()][Beanshangping_xiangxi.tblStepTitle.length];
		for(int i=0;i<shangping.size();i++){
			for(int j=0;j<Beanshangping_xiangxi.tblStepTitle.length;j++) {
				tblshangpingData[i][j]=shangping.get(i).getCell(j);				
			
			}		
			
		}
		
		tabshangpingModel.setDataVector(tblshangpingData,tblshangpingTitle);
		this.dataTabshangping.validate();
		this.dataTabshangping.repaint();
	}
	private void reloadgouwuche(){//购物车

		try {
			gouwuche=ttcpUtil.userGouwu.loadgouwuche();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblgouwucheData =new Object[gouwuche.size()][Beangouwuche.tblStepTitle.length];
		for(int i=0;i<gouwuche.size();i++){
			for(int j=0;j<Beangouwuche.tblStepTitle.length;j++) {
				tblgouwucheData[i][j]=gouwuche.get(i).getCell(j);				
			
			}		
			
		}
		
		tabgouwucheModel.setDataVector(tblgouwucheData,tblgouwucheTitle);
		this.dataTablegouwuche.validate();
		this.dataTablegouwuche.repaint();
	}
	public FrmMain(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("ttcp外卖管理系统");
//		dlgLogin=new FrmLogin(this,"登陆",true);
//		dlgLogin.setVisible(true);
	    //菜单
		
	    this.menu_plan.add(this.menuItem_AddPlan); this.menuItem_AddPlan.addActionListener(this);
	    this.menu_plan.add(this.menuItem_DeletePlan); this.menuItem_DeletePlan.addActionListener(this);
	    this.menu_plan.add(this.menuItem_xiadan); this.menuItem_xiadan.addActionListener(this);
	    this.menu_step.add(this.menuItem_Addaddress); this.menuItem_Addaddress.addActionListener(this);
	    this.menu_step.add(this.menuItem_Deleteaddress); this.menuItem_Deleteaddress.addActionListener(this);
	    this.menu_step.add(this.menuItem_startStep); this.menuItem_startStep.addActionListener(this);
	    this.menu_step.add(this.menuItem_finishStep); this.menuItem_finishStep.addActionListener(this);
	    this.menu_step.add(this.menuItem_moveUpStep); this.menuItem_moveUpStep.addActionListener(this);
	    this.menu_step.add(this.menuItem_moveDownStep); this.menuItem_moveDownStep.addActionListener(this);
	    this.menu_static.add(this.menuItem_static1); this.menuItem_static1.addActionListener(this);
	    this.menu_more.add(this.menuItem_modifyPwd); this.menuItem_modifyPwd.addActionListener(this);
	    this.menu_more.add(this.menuItem_modifyvip); this.menuItem_modifyvip.addActionListener(this);
	    this.menu_more.add(this.menuItem_modifyF5); this.menuItem_modifyF5.addActionListener(this);

	    menubar.add(menu_plan);
	    menubar.add(menu_step);
	    menubar.add(menu_static);
	    menubar.add(menu_more);
	    this.setJMenuBar(menubar);
	    
	    this.getContentPane().add(new JScrollPane(this.dataTableshangjia), BorderLayout.WEST);//商家
	    this.reloadshangpinTable();
	    this.dataTableshangjia.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.print("2222");
				int i=FrmMain.this.dataTableshangjia.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmMain.this.reloadshangping_fenlei(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableleibie), BorderLayout.CENTER);//商品分类
	    
	    this.dataTableleibie.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.print("1111");
				int i=FrmMain.this.dataTableleibie.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmMain.this.reloadshangping_xiangxi(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTabshangping), BorderLayout.EAST);//商品详细
	    this.reloadgouwuche();
	    this.dataTabshangping.addMouseListener(new MouseAdapter (){//商品选择

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmMain.this.dataTabshangping.getSelectedRow();
				if(i<0) {
					return;
				}
				curshangping=shangping.get(i);
			}
			
	    });
	    
	    this.getContentPane().add(new JScrollPane(this.dataTablegouwuche), BorderLayout.SOUTH);//购物车
	    
	    
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!尊敬的:"+Beanuser.currentLoginUser.getName());//修改成   您好！+登陆用户名
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
		 if(e.getSource()==this.menuItem_modifyPwd){
				FrmModifyPwd dlg=new FrmModifyPwd(this,"密码修改",true);
				dlg.setVisible(true);
			}
		 if(e.getSource()==this.menuItem_modifyvip) {//vip
			 	frmuservip vip = new frmuservip() ;
			 	vip.setVisible(true);
		 }
		 if (e.getSource()==this.menuItem_modifyF5) {//刷新
			 this.setVisible(false);
			 
			 FrmMain newui= new FrmMain();
			 newui.setVisible(true);
		      
		}
		if(e.getSource()==this.menuItem_AddPlan){//购物车
			Frmaddgouwuche add = new Frmaddgouwuche();
			add.setShangping_id(curshangping.getShangping_id());
			add.setShangping_name(curshangping.getShangping_name());
			add.setPrice(curshangping.getPrice());
			add.setShangjia_id(curshangjia.getShangjia_id());
			add.setVisible(true);	
		}
		if(e.getSource()==this.menuItem_xiadan) {//结算
			
			
			
		}
		if(e.getSource()==this.menuItem_Addaddress) {//添加地址
			Frmadd_address addaddress = new Frmadd_address();
			addaddress.setVisible(true);
		}
		if(e.getSource()==this.menuItem_startStep) {//查看地址
			FrmChakan_address chakan_address =new FrmChakan_address();
			chakan_address.setVisible(true);
			}
		if (e.getSource()==this.menuItem_Deleteaddress) {//
			Frmdelete_address delete = new Frmdelete_address();
			delete.setVisible(true);
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
