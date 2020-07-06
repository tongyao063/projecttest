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



public class FrmriderMain extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_riderorder=new JMenu("���ֽӵ�");
    private JMenu menu_riderevaluate=new JMenu("��������");
    private JMenu menu_cnt=new JMenu("���ֽӵ�����");
    private JMenu menu_income=new JMenu("��������");
    private JMenu menu_riderdetails=new JMenu("���ֻ������");

    private JMenu menu_modifypwd=new JMenu("�����޸�");
    private JMenu menu_Refresh=new JMenu("ˢ��");
    
    
    
	private Frmriderlogin ridLogin=null;
	private JPanel statusBar = new JPanel();
	
	
	public FrmriderMain(){
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("����ϵͳ");
		ridLogin=new Frmriderlogin(this,"���ֵ�½",true);
		ridLogin.setVisible(true);
	    //�˵�
	   
	    
	    menubar.add(menu_riderorder);
	    menubar.add(menu_riderevaluate);
	    menubar.add(menu_cnt);
	    menubar.add(menu_income);
	    menubar.add(menu_riderdetails);

	    menubar.add(menu_modifypwd);
	    menubar.add(menu_Refresh);
	    
	    this.setJMenuBar(menubar);
	    
	   
	    	

	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
