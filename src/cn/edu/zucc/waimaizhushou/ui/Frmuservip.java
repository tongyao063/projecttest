package cn.edu.zucc.waimaizhushou.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import cn.edu.zucc.waimaizhushou.WaiMaiUtil;
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;

public class Frmuservip extends JDialog implements ActionListener {
	private JPanel workPane = new JPanel();
	private Button btnOkvip = new Button("开通会员");
	private Button btnRenewal = new Button("续费会员");
	private Button btncancle = new Button("取消");
	public Frmuservip(Frame f, String s, boolean b) {
		super(f, s, b);
		workPane.add(btnOkvip);
		workPane.add(btnRenewal);
		workPane.add(btncancle);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 180);
		this.btnOkvip.addActionListener(this);
		this.btnRenewal.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btncancle)
			this.setVisible(false);
		else if(e.getSource()==this.btnOkvip){
			Frmvipregist adm=new Frmvipregist(this,"开通会员",true);
			adm.setVisible(true);
		}
			
		
	}


}
