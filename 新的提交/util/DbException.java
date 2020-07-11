package cn.edu.zucc.ttcp.util;

public class DbException extends BaseException {
	public DbException(java.lang.Throwable ex){
		super("���ݿ��������"+ex.getMessage());
	}
}
