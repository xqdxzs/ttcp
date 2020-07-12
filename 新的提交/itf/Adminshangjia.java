package cn.edu.zucc.ttcp.itf;

import java.sql.Timestamp;
import java.util.List;import com.sun.org.apache.xml.internal.security.utils.UnsyncByteArrayOutputStream;

import cn.edu.zucc.ttcp.model.Beanmanjian;
import cn.edu.zucc.ttcp.model.Beanrider;
import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
import cn.edu.zucc.ttcp.model.Beanyouhui1;
import cn.edu.zucc.ttcp.model.Beanyouhui;
import cn.edu.zucc.ttcp.util.BaseException;

public interface  Adminshangjia {
	public Beanshangjia_xingxi addshagnjia(String shangjia_name,int shangjia_star,float renjunxf)throws BaseException;//添加商家

	public Beanshangjia_xingxi deleteshangjia(int shangjia_id)throws BaseException;//删除商家
	
	public Beanshangjia_xingxi xiugaishangjia(int shangjia_id,String name,int shangjia_star,float renjunxf)throws BaseException;//删除商家
//
	public Beanshangping_leibie addleibie(int shangjia_id,String category_name,int number)throws BaseException;

	public Beanshangping_leibie deleteleibie(int category_id)throws BaseException;

	public Beanshangping_leibie xiugaileibie(int shangjia_id,String category_name,int category_id,int shangping_number)throws BaseException;
//
	public Beanshangping_xiangxi addshangping(int category_id,String shangping_name,float price,int yuliang)throws BaseException;

	public Beanshangping_xiangxi deleteshangping(int shangping_id)throws BaseException;

	public Beanshangping_xiangxi xiugaishangping(int shangping_id,int category_id,String shangping_name,float price,int yuliang)throws BaseException;
//
	public Beanmanjian addmanjian(int shangjia_id,int manjian_amount,int youhui_amount,int diejia)throws BaseException;
	
	public Beanmanjian deletemanjian(int manjian_id)throws BaseException;
	
	public Beanmanjian xiugaimanjian(int manjian_id,int shangjia_id,int manjian_amount,int youhui_amount,int diejia)throws BaseException;

	public List<Beanmanjian > loadmanjian( )throws BaseException;
//
	public Beanrider addrider(String rider_name,Timestamp entry_date,String rider_sf,int oreder_number)throws BaseException;
	
	public Beanrider deleterider(int rider_id)throws BaseException;
	
	public Beanrider xiugairider(int rider_id,String rider_name,String rider_xf,int order_number)throws BaseException;
	
	public List<Beanrider > loadrider( )throws BaseException;
//
	public  Beanyouhui1 addyouhui(int shangjia_id,float youhui )throws BaseException;
	
	public Beanyouhui1 deleteyouhui(int youhui_id) throws BaseException;
	
	public List<Beanyouhui1 > loadyouhui1( )throws BaseException;
	
	public List<Beanyouhui > loadyouhui(Beanyouhui1 youhui1)throws BaseException;
	
	
}

