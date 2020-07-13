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

import javax.swing.JButton;
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
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanjidan;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.util.BaseException;
import javafx.application.Application;


public class Frmuser_chakan_jidan extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JButton menu_plan=new JButton("领取优惠券");
    
    private JMenu menu_step=new JMenu("地址管理");
    private JMenu menu_static=new JMenu("查询统计");
    private JMenu menu_more=new JMenu("更多");
    
    private JMenuItem  menuItem_AddPlan=new JMenuItem("领取优惠券");
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
	
	private Object tbladdressData[][];
	DefaultTableModel tabaddressModel=new DefaultTableModel();
	private JTable dataTableaddress=new JTable(tabaddressModel);

	

	private Object tbladdressTitle[]=Beanjidan.tableTitles;
	
	List<Beanjidan> alladdress=null;
	
	Beanjidan curaddress =null;
	private Component dataTableStep;
	

	private void reloadshangpinTable(){//集单界面
		try {
			
			alladdress = ttcpUtil.userGouwu.chakanuser_jidan(Beanuser.currentLoginUser.getUser_id());
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tbladdressData =  new Object[alladdress.size()][Beanjidan.tableTitles.length];
		for(int i=0;i<alladdress.size();i++){
			for(int j=0;j<Beanjidan.tableTitles.length;j++) {
				tbladdressData[i][j]=alladdress.get(i).getCell(j);
			}
		}
		
		tabaddressModel.setDataVector(tbladdressData,tbladdressTitle);
		this.dataTableaddress.validate();
		this.dataTableaddress.repaint();
	}
	public Frmuser_chakan_jidan(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	//	this.setExtendedState(Frame.DISPOSE_ON_CLPSE);
		this.setTitle("集单表(优惠券领取)");
//		dlgLogin=new FrmLogin(this,"登陆",true);
//		dlgLogin.setVisible(true);
	    //菜单
	   // this.menu_plan.add(this.menuItem_AddPlan); this.menuItem_AddPlan.addActionListener(this);
	    menubar.add(menu_plan);
	    this.setJMenuBar(menubar);
	    this.menu_plan.addActionListener(this);
	    
	    this.getContentPane().add(new JScrollPane(this.dataTableaddress), BorderLayout.CENTER);
	    this.reloadshangpinTable();
	    this.dataTableaddress.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.print("2222");
				int i=Frmuser_chakan_jidan.this.dataTableaddress.getSelectedRow();
				if(i<0) {
					return;
				}
				curaddress=alladdress.get(i);
				curaddress.setUser_id(Beanuser.currentLoginUser.getUser_id());
			}
	    	
	    });
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!尊敬的用户:"+Beanuser.currentLoginUser.getName()+"您的集单情况如下：");
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
		if (e.getSource() == this.menu_plan) {
			if(curaddress == null) {
				JOptionPane.showMessageDialog(null, "请选择优惠券");
				return;
			}
			try {
				ttcpUtil.userGouwu.lingqu_youhui(curaddress);
				JOptionPane.showMessageDialog(null, "领取成功");
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
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
