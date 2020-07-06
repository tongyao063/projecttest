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



public class FrmmerchantMain extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_inquire=new JMenu("商品查询");
    private JMenu menu_order=new JMenu("接单");
    private JMenu menu_evaluate=new JMenu("查看商品评价");
    private JMenu menu_collect=new JMenu("集单送券优惠");
    private JMenu menu_orderdetails=new JMenu("订单详情");
    private JMenu menu_coupon=new JMenu("发放优惠券");
    private JMenu menu_merchantdetails=new JMenu("商家基本情况");
    private JMenu menu_modifypwd=new JMenu("密码修改");
    private JMenu menu_Refresh=new JMenu("刷新");
    
    
    
	private Frmmerchantlogin merLogin=null;
	private JPanel statusBar = new JPanel();
	
	
	public FrmmerchantMain(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("商家系统");
		merLogin=new Frmmerchantlogin(this,"商家登陆",true);
		merLogin.setVisible(true);
	    //菜单
	   
	    
	    menubar.add(menu_inquire);
	    menubar.add(menu_order);
	    menubar.add(menu_collect);
	    menubar.add(menu_evaluate);
	    menubar.add(menu_orderdetails);
	    menubar.add(menu_coupon);
	    menubar.add(menu_merchantdetails);
	    menubar.add(menu_modifypwd);
	    menubar.add(menu_Refresh);
	    
	    this.setJMenuBar(menubar);
	    
	   
	    	

	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
