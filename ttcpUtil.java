package cn.edu.zucc.ttcp;


import cn.edu.zucc.ttcp.comtrol.example.ExampleUserManager;

import cn.edu.zucc.ttcp.itf.IUserManager;

public class ttcpUtil {
	public static IUserManager userManager=new ExampleUserManager();//需要换成自行设计的实现类
}
