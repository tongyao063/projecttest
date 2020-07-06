package cn.edu.zucc.waimaizhushou.ui;

import java.awt.BorderLayout;
import java.awt.Button;
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
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;


public class Frmimprovepersonalinfo extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnvip = new JButton("是否会员");
	private JButton btndetermine = new JButton("确定");
	private JButton btnCancel = new JButton("退出");

	private JLabel labelgender = new JLabel("性别：");
	private JLabel labelphone = new JLabel("电话号码：");
	private JLabel labelemail = new JLabel("邮箱：");
	private JLabel labelcity = new JLabel("城市：");
	private JTextField edtgender = new JTextField(20);
	private JTextField edtphone = new JTextField(20);
	private JTextField edtemail = new JTextField(30);
	private JTextField edtcity = new JTextField(20);
	private JTextField edtvip = new JTextField(20);

	
	public Frmimprovepersonalinfo(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnvip);
		toolBar.add(this.btndetermine);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelgender);
		workPane.add(edtgender);
		workPane.add(labelphone);
		workPane.add(edtphone);
		workPane.add(labelemail);
		workPane.add(edtemail);
		workPane.add(labelcity);
		workPane.add(edtcity);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(320, 140);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		
		this.btnvip.addActionListener(this);
		this.btndetermine.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btndetermine){
			try {
				String gender=new String(this.edtgender.getText());
				String phonenum=new String(this.edtphone.getText());
				String email=new String(this.edtemail.getText());
				String city=new String(this.edtcity.getText());
				WaiMaiUtil.useriManager.improvepersonalinfo(gender, phonenum, email, city,Beanuserd.currentLoginuser);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

}
