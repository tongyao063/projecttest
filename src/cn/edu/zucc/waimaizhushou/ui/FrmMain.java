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
    private JMenu menu_inquire=new JMenu("��Ʒ��ѯ");
    private JMenu menu_order=new JMenu("�û��µ�");
    private JMenu menu_evaluate=new JMenu("��Ʒ����");
    private JMenu menu_consumption=new JMenu("�û�����");
    private JMenu menu_orderdetails=new JMenu("��������");
    private JMenu menu_riderevaluate=new JMenu("��������");
    private JMenu menu_holdcoupon=new JMenu("ӵ���Ż�ȯ");
    private JMenu menu_collect=new JMenu("�������");
    private JMenu menu_userdetails=new JMenu("��ǰ�û��������");
    private JMenu menu_modifypwd=new JMenu("�����޸�");
    private JMenu menu_improve=new JMenu("���Ƹ�����Ϣ");
    private JMenu menu_more=new JMenu("����");
    private JMenu menu_Refresh=new JMenu("ˢ��");
    
    private JMenuItem  menuItem_modpwd=new JMenuItem("�޸�����");
    private JMenuItem  menuItem_improved=new JMenuItem("���Ƹ�����Ϣ");
    private JMenuItem  menuItem_vip=new JMenuItem("��ͨ��Ա������");
	private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	
	public FrmMain(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("�û�ϵͳ");
		dlgLogin=new FrmLogin(this,"�û���½",true);
		dlgLogin.setVisible(true);
	    //�˵�
		
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
			FrmModifyPwd dlg=new FrmModifyPwd(this,"�����޸�",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_improved){
			Frmimprovepersonalinfo dlg=new Frmimprovepersonalinfo(this,"������Ϣ����",true);
			dlg.setVisible(true);
		}else if(e.getSource()==this.menuItem_vip){
			Frmuservip dlg=new Frmuservip(this,"��Ա",true);
			dlg.setVisible(true);
		}
	}
}
