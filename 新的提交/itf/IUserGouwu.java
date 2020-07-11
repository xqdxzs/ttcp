package cn.edu.zucc.ttcp.itf;

import cn.edu.zucc.ttcp.model.Beangouwuche;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanuser;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.util.BaseException;
import java.util.List;
public interface IUserGouwu {
	public Beanshangping_xiangxi addshangping(String name) throws BaseException;
	
	public List<Beanshangjia_xingxi> loadAll()throws BaseException ;
	
	public List<Beanshangping_leibie> loadleibie(Beanshangjia_xingxi shangjia)throws BaseException;
	
	public List<Beanshangping_xiangxi> loadshagnping(Beanshangping_leibie leibie)throws BaseException;
	
	public List<Beangouwuche> loadgouwuche( )throws BaseException;
	
	public  Beangouwuche addshangping(int shangping_id,String shangping_,float price,int number,int shangjia_id) throws BaseException ;
	
	public Beanshangping_xiangxi update_yuliang(int number) throws BaseException;
}
