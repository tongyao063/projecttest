package cn.edu.zucc.waimaizhushou.comtrol;

import java.sql.Connection;
import java.sql.SQLException;

import cn.edu.zucc.waimaizhushou.itf.IUserManager;
import cn.edu.zucc.waimaizhushou.model.BeanUser;
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;
import cn.edu.zucc.waimaizhushou.util.BusinessException;
import cn.edu.zucc.waimaizhushou.util.DBUtil;
import cn.edu.zucc.waimaizhushou.util.DbException;


public class BeanuserdManager implements IUserManager {
	//public static BeanUser currentLoginUser=null;

	@Override
	public Beanuserd regist(String userid, String pwd,String pwd2) throws BaseException {
		// TODO Auto-generated method stub
	
		if(userid==null || "".equals(userid) || userid.length()>20){
			throw new BusinessException("��½�˺ű�����1-20����");
		}
		if(pwd==null || "".equals(pwd) || pwd.length()>20){
			throw new BusinessException("��½���������1-20����");
		}
		if(! pwd.equals(pwd2) ){
			throw new BusinessException("ȷ�����벻һ��");
		}
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("ע���˺��Ѿ�����");//�û������ظ�
			rs.close();
			pst.close();
			if(!pwd.equals(pwd2)) throw new BusinessException("ȷ�����벻��ȷ");//��������һ��
			sql="insert into tbl_user(user_id,user_pwd,register_time) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			pst.setString(2, pwd);
			pst.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
		

	
	@Override
	public BeanUser login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_id,user_pwd,register_time from tbl_user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("��½�˺Ų� ����");//�û�������
			BeanUser u=new BeanUser();
			u.setUser_id(rs.getString(1));
			u.setUser_pwd(rs.getString(2));
			u.setRegister_time(rs.getDate(3));
			if(!pwd.equals(u.getUser_pwd())) throw new BusinessException("���벻��ȷ");//�������
			rs.close();
			pst.close();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		//return null;
	}


	@Override
	public void changePwd(BeanUser user, String oldPwd, String newPwd,String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd==null) throw new BusinessException("ԭʼ���벻��Ϊ��");
		if(newPwd==null || "".equals(newPwd) || newPwd.length()>16) throw new BusinessException("����Ϊ1-16���ַ�");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select user_pwd from tbl_user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,user.getUser_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("��½�˺Ų� ����");
			if(!oldPwd.equals(rs.getString(1))) throw new BusinessException("ԭʼ�������");
			rs.close();
			pst.close();
			sql="update tbl_user set user_pwd=? where user_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getUser_id());
			pst.execute();
			pst.close();
			if(!newPwd.equals(newPwd2)) throw new BusinessException("ȷ�����벻��ȷ");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
}
