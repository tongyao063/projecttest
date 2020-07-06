package cn.edu.zucc.waimaizhushou.ui;

import java.awt.BorderLayout;
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

import cn.edu.zucc.waimaizhushou.WaiMaiUtil;
import cn.edu.zucc.waimaizhushou.model.BeanPlan;
import cn.edu.zucc.waimaizhushou.model.BeanStep;
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;



public class FrmadministratorMain extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_usernmanage=new JMenu("用户管理");
    private JMenu menu_merchantmanage=new JMenu("商家管理");
    private JMenu menu_ridermanage=new JMenu("骑手管理");
    private JMenu menu_discountmanage=new JMenu("优惠金额管理");
    private JMenu menu_administratormanage=new JMenu("管理员管理");
    private JMenu menu_administratordetails=new JMenu("管理员信息");
    private JMenu menu_modifypwd=new JMenu("密码修改");
    private JMenu menu_Refresh=new JMenu("刷新");
    
    
    
	private Frmadministratorlogin adLogin=null;
	private JPanel statusBar = new JPanel();
	
	
	public FrmadministratorMain(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("管理员系统");
		adLogin=new Frmadministratorlogin(this,"管理员登陆",true);
		adLogin.setVisible(true);
	    //菜单
	   
	    
	    menubar.add(menu_usernmanage);
	    menubar.add(menu_merchantmanage);
	    menubar.add(menu_ridermanage);
	    menubar.add(menu_discountmanage);
	    menubar.add(menu_administratormanage);
	    menubar.add(menu_administratordetails);
	    menubar.add(menu_modifypwd);
	    menubar.add(menu_Refresh);
	    
	    this.setJMenuBar(menubar);
	    
	   
	    	

	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
