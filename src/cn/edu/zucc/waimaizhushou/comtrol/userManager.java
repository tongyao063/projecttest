package cn.edu.zucc.waimaizhushou.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.zucc.waimaizhushou.itf.userImanager;
import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import cn.edu.zucc.waimaizhushou.util.BaseException;
import cn.edu.zucc.waimaizhushou.util.BusinessException;
import cn.edu.zucc.waimaizhushou.util.DBUtil;
import cn.edu.zucc.waimaizhushou.util.DbException;


public class userManager implements userImanager {

	@Override
	public Beanuserd reg(int userid,String useriname, String pwd1,String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		String c=userid+"";
		if("".equals(userid) ){
			throw new BusinessException("注册密码不为空");
		}
			if(useriname==null || "".equals(useriname) || useriname.length()>20){
				throw new BusinessException("登陆账号必须是1-20个字");
			}
			if(pwd1==null || "".equals(pwd1) || pwd1.length()>20){
				throw new BusinessException("登陆密码必须是1-20个字");
			}
			if(! pwd1.equals(pwd2) ){
				throw new BusinessException("确认密码不一致");
			}
			
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from user where userid=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1,userid);
				java.sql.ResultSet rs=pst.executeQuery();
				if(rs.next()) throw new BusinessException("注册账号已经存在");//用户id不重复
				rs.close();
				pst.close();
				if(!pwd1.equals(pwd2)) throw new BusinessException("确认密码不正确");//两次密码一样
				sql="insert into user(userid,username,userpwd,userregisttime) values(?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setInt(1,userid);
				pst.setString(2, useriname);
				pst.setString(3, pwd1);
				pst.setTimestamp(4,new java.sql.Timestamp(System.currentTimeMillis()));
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
	public Beanuserd login(int userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					String sql="select userid,username,usergender,userpwd,userphonenum,useremail,usercity,userregisttime from user where userid=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst.setInt(1,userid);
					java.sql.ResultSet rs=pst.executeQuery();
					if(!rs.next()) throw new BusinessException("登陆账号不 存在");//用户不存在
					Beanuserd u=new Beanuserd();
					u.setUserid(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setUsergender(rs.getString(3));
					u.setUserpwd(rs.getString(4));
					u.setUserphonenum(rs.getString(5));
					u.setUseremail(rs.getString(6));
					u.setUsercity(rs.getString(7));
					u.setUserregisttime(rs.getDate(8));
					if(!pwd.equals(u.getUserpwd())) throw new BusinessException("密码不正确");//密码错误
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
	public void changePwd(String oldPwd, String newPwd,String newPwd2,Beanuserd user) throws BaseException {
		// TODO Auto-generated method stub
				if(oldPwd==null) throw new BusinessException("原始密码不能为空");
				if(!oldPwd.equals(user.getUserpwd())) throw new BusinessException("原始密码错误");
				if(newPwd==null || "".equals(newPwd) || newPwd.length()>16) throw new BusinessException("必须为1-16个字符");
				if(oldPwd.equals(newPwd)) throw new BusinessException("前后密码不能一致");
				if(!newPwd.equals(newPwd2)) throw new BusinessException("确认密码错误");
				Connection conn=null;
				try {
					conn=DBUtil.getConnection();
					String sql="update user set userpwd=? where userid=?";
					java.sql.PreparedStatement pst=conn.prepareStatement(sql);
					pst=conn.prepareStatement(sql);
					pst.setString(1, newPwd);
					pst.setInt(2, user.getUserid());
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
			}
	
	public void improvepersonalinfo(String gender, String phonenum,String email,String city,Beanuserd user) throws BaseException{
		if(gender==null ||"".equals(gender)){
			throw new BusinessException("性别不为空");
		}
			if(phonenum==null || "".equals(phonenum)){
				throw new BusinessException("电话号码不为空");
			}
			if(email==null || "".equals(email) ){
				throw new BusinessException("邮箱不为空");
			}
			if(city==null || "".equals(city)){
				throw new BusinessException("城市不为空");
			}
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="update user set usergender=?,userphonenum=?,useremail=?,usercity=? where userid=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1,gender);
				pst.setString(2, phonenum);
				pst.setString(3, email);
				pst.setString(4,city);	
				pst.setInt(5,user.getUserid());	
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
		
	}
	
	public void vipregistinfo(Beanuserd user) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select vipjud from user where userid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,user.getUserid());
			java.sql.ResultSet rs=pst.executeQuery();
			/*if(rs.next()) {
				if(rs.getBoolean(1)==null)
				sql="update user set vipjud=?,vipdeadline=? where userid=?";
				pst=conn.prepareStatement(sql);
				pst.setBoolean(1, true);
				pst.setTimestamp(2,new java.sql.Timestamp(System.currentTimeMillis()));
				pst.setInt(3,user.getUserid());	
				pst.execute();
				pst.close();
			}*/
			if(rs.next()) {
				boolean c=rs.getBoolean(1);
				if(c==false) {
				sql="update user set vipjud=?,vipdeadline=? where userid=?";
				pst=conn.prepareStatement(sql);
				pst.setBoolean(1, true);
				pst.setTimestamp(2,new java.sql.Timestamp(System.currentTimeMillis()));
				pst.setInt(3,user.getUserid());	
				pst.execute();
				pst.close();
				}
			}
			rs.close();
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
	}
		
	}

