package cn.edu.zucc.ttcp.itf;

import cn.edu.zucc.ttcp.model.BeanAddress;
import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanjidan;
import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanorder;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_order;
import cn.edu.zucc.ttcp.util.BaseException;
import java.util.List;
public interface IUserGouwu {
	public Beanshangping_xiangxi addshangping(String name) throws BaseException;
	
	public List<Beanshangjia_xingxi> loadAll()throws BaseException ;
	
	public List<Beanshangping_leibie> loadleibie(Beanshangjia_xingxi shangjia)throws BaseException;
	
	public List<Beanshangping_xiangxi> loadshagnping(Beanshangping_leibie leibie)throws BaseException;
	
	public List<Beangouwuche> loadgouwuche( )throws BaseException;
	
	public  Beangouwuche addshangping(int shangping_id,String shangping_,float price,int number,int shangjia_id) throws BaseException ;
	
	public Beanshangping_xiangxi update_yuliang(int number) throws BaseException;//转移至xiadan ui
	
	public List<Beanyouhui> chakanuser_youhui(String user_id) throws BaseException;//优惠券查看
	
	public List<Beanjidan> chakanuser_jidan(String user_id) throws BaseException;//查看集单情况
	
	public void lingqu_youhui(Beanjidan user_jidan) throws BaseException;//领取优惠券
	
	public List<Beanyouhui > loadyouhui_2(String user_id ,int shangjia_id)throws BaseException;//结算中优惠表
	
	public List<Beanmanjian> loadmanjian_jiesuan(int shangjia_id) throws BaseException;//结算中满减表
// 查看订单
	public List<Beanshangping_order> loadorder(String user_id)  throws BaseException;//订单查看
//订单详细
	public List<Beanorder> loadorder_xiangxi(int order_id)throws BaseException;

}
