package cn.edu.zucc.ttcp.ui;

import java.awt.BorderLayout;

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

import cn.edu.zucc.ttcp.util.BusinessException;
import cn.edu.zucc.ttcp.util.DbException;
import cn.edu.zucc.ttcp.ttcpUtil;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;


//import cn.edu.zucc.personplan.PersonPlanUtil;
//import cn.edu.zucc.personplan.model.BeanPlan;
//import cn.edu.zucc.personplan.model.BeanStep;
//import cn.edu.zucc.personplan.util.BaseException;


public class FrmMainadmin extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_plan=new JMenu("商家管理");
    private JMenu menu_step=new JMenu("优惠管理");   
    private JMenu menu_static=new JMenu("骑手订单管理");    
    private JMenu menu_more=new JMenu("更多");
    
    private JMenuItem  menuItem_AddPlan=new JMenuItem("新建商家");
    private JMenuItem  menuItem_DeletePlan=new JMenuItem("删改商家");
    private JMenuItem  menuItem_addleibie = new JMenuItem("新增类别");
    private JMenuItem  menuItem_shangaileibie = new JMenuItem("删改类别");
    private JMenuItem  menuItem_addshangping = new JMenuItem("新增商品");
    private JMenuItem  menuItem_shangaishangping = new JMenuItem("删改商品");
    
    private JMenuItem  menuItem_AddStep=new JMenuItem("添加满减方案");
    private JMenuItem  menuItem_DeleteStep=new JMenuItem("删改满减方案");
    private JMenuItem  menuItem_startStep=new JMenuItem("查看满减方案");
    
    private JMenuItem  menuItem_addyouhui=new JMenuItem("新增/删除优惠券");
   // private JMenuItem  menuItem_deleteyouhui=new JMenuItem("删除优惠券");
    private JMenuItem  menuItem_chakan_user_youhui=new JMenuItem("查看用户优惠券");
    
//    private JMenuItem  menuItem_finishStep=new JMenuItem("结束步骤");
//    private JMenuItem  menuItem_moveUpStep=new JMenuItem("步骤上移");
//    private JMenuItem  menuItem_moveDownStep=new JMenuItem("步骤下移");
    
    private JMenuItem  menuItem_static1=new JMenuItem("添加骑手");
    private JMenuItem menuItem_static2 = new JMenuItem("删改骑手");
    private JMenuItem menuItem_static3 = new JMenuItem("查看骑手信息");
    private JMenuItem menuItem_static4 = new JMenuItem("接单");
    
    private JMenuItem  menuItem_modifyPwd=new JMenuItem("管理员密码修改");
    private JMenuItem  menuItem_modifyF5=new JMenuItem("刷新");
    

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
	

	public FrmMainadmin(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("管理员系统");
//		dlgLogin=new FrmLogin(this,"登陆",true);
//		dlgLogin.setVisible(true);
	    //菜单
	    this.menu_plan.add(this.menuItem_AddPlan); this.menuItem_AddPlan.addActionListener(this);
	    this.menu_plan.add(this.menuItem_DeletePlan); this.menuItem_DeletePlan.addActionListener(this);
	    this.menu_plan.add(this.menuItem_addleibie); this.menuItem_addleibie.addActionListener(this);
	    this.menu_plan.add(this.menuItem_shangaileibie); this.menuItem_shangaileibie.addActionListener(this);
	    this.menu_plan.add(this.menuItem_addshangping); this.menuItem_addshangping.addActionListener(this);
	    this.menu_plan.add(this.menuItem_shangaishangping); this.menuItem_shangaishangping.addActionListener(this);
	    
	    this.menu_step.add(this.menuItem_AddStep); this.menuItem_AddStep.addActionListener(this);
	    this.menu_step.add(this.menuItem_DeleteStep); this.menuItem_DeleteStep.addActionListener(this);
	    this.menu_step.add(this.menuItem_startStep); this.menuItem_startStep.addActionListener(this);
	    this.menu_step.add(this.menuItem_addyouhui); this.menuItem_addyouhui.addActionListener(this);
	    this.menu_step.add(this.menuItem_chakan_user_youhui); this.menuItem_chakan_user_youhui.addActionListener(this);
	    
	    this.menu_static.add(this.menuItem_static1); this.menuItem_static1.addActionListener(this);
	    this.menu_static.add(this.menuItem_static2); this.menuItem_static2.addActionListener(this);
	    this.menu_static.add(this.menuItem_static3); this.menuItem_static3.addActionListener(this);
	    this.menu_static.add(this.menuItem_static4); this.menuItem_static4.addActionListener(this);
	    
	    this.menu_more.add(this.menuItem_modifyPwd); this.menuItem_modifyPwd.addActionListener(this);
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
				int i=FrmMainadmin.this.dataTableshangjia.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmMainadmin.this.reloadshangping_fenlei(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableleibie), BorderLayout.CENTER);//商品分类
	    
	    this.dataTableleibie.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.print("1111");
				int i=FrmMainadmin.this.dataTableleibie.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmMainadmin.this.reloadshangping_xiangxi(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTabshangping), BorderLayout.EAST);//商品详细
	   // this.reloadgouwuche();
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好，管理员");//修改成   您好！+登陆用户名
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.NORTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		System.exit(0);
             }
        });
	    this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==this.menuItem_modifyPwd){
				FrmModifyPwd dlg=new FrmModifyPwd(this,"密码修改",true);
				dlg.setVisible(true);
			}

		 if (e.getSource()==this.menuItem_modifyF5) {//刷新
			 this.reloadshangpinTable();
		      this.reloadshangpinTable();
		      this.validate();
		   this.repaint();
		      this.setVisible(false);
		   this.setVisible(true);
		      
		}
		if(e.getSource()==this.menuItem_AddPlan){//商家添加	
			Frmadmin_add_shangjia add_shangjia = new Frmadmin_add_shangjia();
			add_shangjia.setVisible(true);
			
		}
		if (e.getSource() == this.menuItem_DeletePlan) {//删改商家
			Frmadmin_shangai_shangjia shangai = new Frmadmin_shangai_shangjia();
			shangai.setVisible(true);
		}
		if (e.getSource() == this.menuItem_addleibie) {//类别
			Frmadmin_add_leibie  add_leibie = new Frmadmin_add_leibie();
			add_leibie.setVisible(true);
		}
		if (e.getSource() == this.menuItem_shangaileibie) {
			Frmadminshangai_leibie leibie = new Frmadminshangai_leibie();
			leibie.setShangjia_id(curshangjia.getShangjia_id());
			if(curshangjia==null) { //throw new BusinessException("请选择商品类型后再进行该操作！");
				JOptionPane.showMessageDialog(null,"请选择商家后再进行该操作！","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			leibie.setVisible(true);
		}
		if (e.getSource() == this.menuItem_addshangping) {//商品
			Frmadmin_add_shangping add_shangping = new Frmadmin_add_shangping();
			add_shangping.setVisible(true);
		}
		if (e.getSource() == this.menuItem_shangaishangping) {
			Frmadmin_shangai_shangping shangping = new Frmadmin_shangai_shangping();
			if(curleibie==null) { //throw new BusinessException("请选择商品类型后再进行该操作！");
				JOptionPane.showMessageDialog(null,"请选择商品类型后再进行该操作！","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			shangping.setCategory_id(curleibie.getCategory_id());
			shangping.setVisible(true);
		}
		if (e.getSource() == this.menuItem_AddStep) {
			Frmadmin_add_manjian add_manjian = new Frmadmin_add_manjian();
			add_manjian.setVisible(true);
			
		}
		if (e.getSource() == this.menuItem_DeleteStep) {
			Frmadmin_shangai_manjian manjian = new Frmadmin_shangai_manjian();
			manjian.setVisible(true);
		}
		if (e.getSource() == this.menuItem_startStep) {
			Frmchakan_manjian list_manjian = new Frmchakan_manjian();
			list_manjian.setVisible(true);
		}
		if (e.getSource() == this.menuItem_static1) {
			Frmadd_rider add_rider = new Frmadd_rider();
			add_rider.setVisible(true);
		}
		if (e.getSource() == this.menuItem_static2) {
			Frmshangai_rider rider = new Frmshangai_rider();
			rider.setVisible(true);
		}
		if (e.getSource() == this.menuItem_static3) {
			FrmChakan_rider list_rider = new FrmChakan_rider();
			list_rider.setVisible(true);
		}
		if (e.getSource() == this.menuItem_static4) {//接单
			Frmrider_jiedan rFrmrider_jiedan = new Frmrider_jiedan();
			rFrmrider_jiedan.setVisible(true);
		}
		if (e.getSource() == this.menuItem_addyouhui) {
			Frmadd_delete_youhui youhui = new Frmadd_delete_youhui();
			youhui.setVisible(true);
		}
		if (e.getSource() == this.menuItem_chakan_user_youhui ) {
			Frmchakan_youhui list_youhui = new Frmchakan_youhui();
			list_youhui.setVisible(true);
		}
	}
}

