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
import cn.edu.zucc.waimaizhushou.ui.FrmModifyPwd;
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;



public class FrmMain extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_inquire=new JMenu("商品查询");
    private JMenu menu_order=new JMenu("用户下单");
    private JMenu menu_evaluate=new JMenu("商品评价");
    private JMenu menu_consumption=new JMenu("用户消费");
    private JMenu menu_orderdetails=new JMenu("订单详情");
    private JMenu menu_riderevaluate=new JMenu("骑手评价");
    private JMenu menu_holdcoupon=new JMenu("拥有优惠券");
    private JMenu menu_collect=new JMenu("集单情况");
    private JMenu menu_userdetails=new JMenu("当前用户基本情况");
    private JMenu menu_modifypwd=new JMenu("密码修改");
    private JMenu menu_improve=new JMenu("完善个人信息");
    private JMenu menu_more=new JMenu("更多");
    private JMenu menu_Refresh=new JMenu("刷新");
    
    private JMenuItem  menuItem_modpwd=new JMenuItem("修改密码");
    private JMenuItem  menuItem_improved=new JMenuItem("完善个人信息");
    private JMenuItem  menuItem_vip=new JMenuItem("开通会员或续费");
	private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	
	public FrmMain(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("用户系统");
		dlgLogin=new FrmLogin(this,"用户登陆",true);
		dlgLogin.setVisible(true);
	    //菜单
		
		this.menu_modifypwd.add(this.menuItem_modpwd); this.menuItem_modpwd.addActionListener(this);
		this.menu_improve.add(this.menuItem_improved); this.menuItem_improved.addActionListener(this);
		this.menu_more.add(this.menuItem_vip); this.menuItem_vip.addActionListener(this);
	    menubar.add(menu_inquire);
	    menubar.add(menu_order);
	    menubar.add(menu_consumption);
	    menubar.add(menu_evaluate);
	    menubar.add(menu_orderdetails);
	    menubar.add(menu_riderevaluate);
	    menubar.add(menu_holdcoupon);
	    menubar.add(menu_collect);
	    menubar.add(menu_userdetails);
	    menubar.add(menu_modifypwd);
	    menubar.add(menu_improve);
	    menubar.add(menu_more);
	    menubar.add(menu_Refresh);
	    
	    this.setJMenuBar(menubar);
	  
	    
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		  this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.menuItem_modpwd){
			FrmModifyPwd dlg=new FrmModifyPwd(this,"密码修改",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_improved){
			Frmimprovepersonalinfo dlg=new Frmimprovepersonalinfo(this,"个人信息完善",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_vip){
			Frmuservip dlg=new Frmuservip(this,"会员",true);
			dlg.setVisible(true);
		}
	}
}
