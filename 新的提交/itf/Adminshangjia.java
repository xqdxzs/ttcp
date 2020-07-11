package cn.edu.zucc.ttcp.itf;

import cn.edu.zucc.ttcp.model.Beanshangjia_xingxi;
import cn.edu.zucc.ttcp.model.Beanshangping_leibie;
import cn.edu.zucc.ttcp.model.Beanshangping_xiangxi;
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

}
