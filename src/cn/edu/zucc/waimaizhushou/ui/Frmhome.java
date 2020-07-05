package cn.edu.zucc.waimaizhushou.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import cn.edu.zucc.waimaizhushou.ui.Frmriderlogin;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.waimaizhushou.WaiMaiUtil;
import cn.edu.zucc.waimaizhushou.model.BeanUser;
import cn.edu.zucc.waimaizhushou.util.BaseException;



public class Frmhome extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JButton btnLogin = new JButton("�û�");
	private JButton rider = new JButton("����");
	private JButton merchant = new JButton("�̼�");
	private JButton administrator = new JButton("����Ա");
	private JButton btnCancel = new JButton("�˳�");
	private JLabel  Introduction =new JLabel("��ѡ�����ϵͳ��");
	public Frmhome(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(Introduction);
		toolBar.add(this.btnLogin);
		toolBar.add(this.rider);
		toolBar.add(this.merchant);
		toolBar.add(this.administrator);
		toolBar.add(this.btnCancel);
		
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		this.setSize(320, 140);
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		this.btnCancel.addActionListener(this);
		this.btnLogin.addActionListener(this);
		this.rider.addActionListener(this);
		this.merchant.addActionListener(this);
		this.administrator.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public Frmhome(Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(Introduction);
		toolBar.add(this.btnLogin);
		toolBar.add(this.rider);
		toolBar.add(this.merchant);
		toolBar.add(this.administrator);
		toolBar.add(this.btnCancel);
		
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		this.setSize(320, 140);
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		this.btnCancel.addActionListener(this);
		this.btnLogin.addActionListener(this);
		this.rider.addActionListener(this);
		this.merchant.addActionListener(this);
		this.administrator.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			FrmMain dlg=new FrmMain();
			dlg.setVisible(true);
			
		} else if (e.getSource() == this.btnCancel) {
			System.exit(0);
		} else if(e.getSource()==this.rider){
			Frmriderlogin rig=new Frmriderlogin(this,"����",true);
			rig.setVisible(true);
		}
		else if(e.getSource()==this.merchant){
			Frmmerchantlogin mer=new Frmmerchantlogin(this,"�̼�",true);
			mer.setVisible(true);
		}
		else if(e.getSource()==this.administrator){
			Frmadministratorlogin adm=new Frmadministratorlogin(this,"����Ա",true);
			adm.setVisible(true);
		}

	}
	public Frmhome()
	{
		Frmhome dlg=new Frmhome(this,"��ҳ",true);
		dlg.setVisible(true);
	}

}
