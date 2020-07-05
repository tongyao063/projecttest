package cn.edu.zucc.waimaizhushou.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import cn.edu.zucc.waimaizhushou.itf.IPlanManager;
import cn.edu.zucc.waimaizhushou.itf.IUserManager;
import cn.edu.zucc.waimaizhushou.model.BeanPlan;
import cn.edu.zucc.waimaizhushou.model.BeanUser;
import cn.edu.zucc.waimaizhushou.util.BaseException;
import cn.edu.zucc.waimaizhushou.util.BusinessException;
import cn.edu.zucc.waimaizhushou.util.DBUtil;
import cn.edu.zucc.waimaizhushou.util.DbException;

public class ExamplePlanManager implements IPlanManager {

	@Override
	public BeanPlan addPlan(String name) throws BaseException {
		// TODO Auto-generated method stub

		if(name==null || "".equals(name) || name.length()>50){
			throw new BusinessException("名称必须是1-50个字");
		}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			//conn=DBPool.getInstance().getConnection();//连接池
			String sql="select count(*) from tbl_plan where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,BeanUser.currentLoginUser.getUser_id() );
			java.sql.ResultSet rs=pst.executeQuery();
			int c=0;
			if(rs.next()) 
				c=rs.getInt(1);
			c++;
			rs.close();
			pst.close();//序号递增
			
			sql="select * from tbl_plan where plan_name=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("该计划已存在");
			rs.close();
			pst.close();
			
			sql="insert into tbl_plan(user_id,plan_order,plan_name,create_time,step_count,start_step_count,finished_step_count) values(?,?,?,?,3,2,1);";
			pst=conn.prepareStatement(sql);
			pst.setString(1, BeanUser.currentLoginUser.getUser_id());//当前登入用户
			pst.setInt(2, c);
			pst.setString(3, name);
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
	public List<BeanPlan> loadAll() throws BaseException {
		List<BeanPlan> result=new ArrayList<BeanPlan>();
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			java.text.SimpleDateFormat t=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sql="select * from tbl_plan";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				BeanPlan p=new BeanPlan();
				p.setPlan_id(rs.getInt(1));
				p.setUser_id(rs.getString(2));
				p.setPlan_order(rs.getInt(3));
				p.setPlan_name(rs.getString(4));
				p.setCreate_time(rs.getDate(5));
				p.setStep_count(rs.getInt(6));
				p.setStart_step_count(rs.getInt(7));
				p.setFinished_step_count(rs.getInt(8));
			//	System.out.println(p.getPlan_id()+" "+p.getUser_id()+" "+p.getPlan_order()+" "+p.getPlan_name()+" "+t.format(p.getCreate_time())+" "+p.getStep_count()+" "+p.getStart_step_count()+" "+p.getFinished_step_count());
				result.add(p);
			}
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
		return result;
	}

	@Override
	public void deletePlan(BeanPlan plan) throws BaseException {
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from tbl_plan where plan_id=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, plan.getPlan_id());
				java.sql.ResultSet rs=pst.executeQuery();
				if(!rs.next()) throw new BusinessException("计划不存在");
				rs.close();
				pst.close();
				if(plan.getStep_count()-plan.getFinished_step_count()>0) throw new BusinessException("计划有步骤不能删除");//还有步骤的计划不能删除
		
				sql="delete from tbl_plan where plan_id=?";
				pst=conn.prepareStatement(sql);
				pst.setInt(1,plan.getPlan_id());
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
	
}
