package cn.edu.zucc.waimaizhushou;

import cn.edu.zucc.waimaizhushou.comtrol.ExamplePlanManager;
import cn.edu.zucc.waimaizhushou.comtrol.ExampleStepManager;
import cn.edu.zucc.waimaizhushou.comtrol.ExampleUserManager;
import cn.edu.zucc.waimaizhushou.comtrol.userManager;
import cn.edu.zucc.waimaizhushou.itf.IPlanManager;
import cn.edu.zucc.waimaizhushou.itf.IStepManager;
import cn.edu.zucc.waimaizhushou.itf.IUserManager;
import cn.edu.zucc.waimaizhushou.itf.userImanager;

public class WaiMaiUtil {
	public static IPlanManager planManager=new ExamplePlanManager();//��Ҫ����������Ƶ�ʵ����
	public static IStepManager stepManager=new ExampleStepManager();//��Ҫ����������Ƶ�ʵ����
	public static IUserManager userManager=new ExampleUserManager();
	public static userImanager useriManager=new userManager();
}
