package cn.edu.zucc.waimaizhushou.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import cn.edu.zucc.waimaizhushou.itf.IStepManager;
import cn.edu.zucc.waimaizhushou.model.BeanPlan;
import cn.edu.zucc.waimaizhushou.model.BeanStep;
import cn.edu.zucc.waimaizhushou.model.BeanUser;
import cn.edu.zucc.waimaizhushou.util.BaseException;
import cn.edu.zucc.waimaizhushou.util.BusinessException;
import cn.edu.zucc.waimaizhushou.util.DBUtil;
import cn.edu.zucc.waimaizhushou.util.DbException;

public class ExampleStepManager implements IStepManager {

	@Override
	public void add(BeanPlan plan, String name, String planstartdate,
			String planfinishdate) throws BaseException {
		if(name==null || "".equals(name) || name.length()>50){
			throw new BusinessException("名称必须是1-50个字");
		}
		Connection conn=null;
		
		try {
			conn=DBUtil.getConnection();
			String sql="select count(*) from tbl_step where plan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,plan.getPlan_id());
			java.sql.ResultSet rs=pst.executeQuery();
			int c=0;
			if(rs.next()) 
				c=rs.getInt(1);	
			c++;
			rs.close();
			pst.close();//序号递增
			sql="insert into tbl_step(plan_id,step_order,step_name,plan_begin_time,plan_end_time) values(?,?,?,?,?)";
			java.text.SimpleDateFormat t =new java.text.SimpleDateFormat("yyyy-MM-dd");
			Date t1=t.parse(planstartdate);
			Date t2=t.parse(planfinishdate);
			pst=conn.prepareStatement(sql);			
			
			pst.setInt(1,plan.getPlan_id());
			pst.setInt(2, c);
			pst.setString(3, name);
			pst.setDate(4, new java.sql.Date(t1.getTime()));
			pst.setDate(5,new java.sql.Date(t2.getTime()));
			pst.execute();
			pst.close();
			
			pst=conn.prepareStatement("update tbl_plan set step_count=step_count+1 where plan_id=?");//创建一个步骤，count+1
			//pst.setInt(1, step.getStep_id());
			pst.setInt(1, plan.getPlan_id());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
	//	return null;
	}

	@Override
	public List<BeanStep> loadSteps(BeanPlan plan) throws BaseException {
		List<BeanStep> result=new ArrayList<BeanStep>();
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			java.text.SimpleDateFormat t=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sql="select * from tbl_step where plan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, plan.getPlan_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				BeanStep p=new BeanStep();
				p.setStep_id(rs.getInt(1));
				p.setPlan_id(rs.getInt(2));
				p.setStep_order(rs.getInt(3));
				p.setStep_name(rs.getString(4));
				p.setPlan_begin_time(rs.getDate(5));
				p.setPlan_end_time(rs.getDate(6));
				p.setReal_begin_time(rs.getDate(7));
				p.setReal_end_time(rs.getDate(8));
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
	public void deleteStep(BeanStep step) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_step where step_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, step.getStep_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("记录不存在");
			rs.close();
			pst.close();
			pst=conn.prepareStatement("delete from tbl_step where step_id=?");
			pst.setInt(1, step.getStep_id());
			pst.execute();
			pst=conn.prepareStatement("update tbl_plan set step_count=step_count-1 where plan_id=?");//删除一个步骤count-1
			//pst.setInt(1, step.getStep_id());
			pst.setInt(1, step.getPlan_id());
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

	@Override
	public void startStep(BeanStep step) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_step where step_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, step.getStep_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("记录不存在");
			rs.close();
			pst.close();
			pst=conn.prepareStatement("update tbl_step set real_begin_time=? where step_id=? and plan_id=?");
			pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setInt(2, step.getStep_id());
			pst.setInt(3, step.getPlan_id());
			pst.execute();
			pst.close();
			pst=conn.prepareStatement("update tbl_plan set start_step_count=start_step_count+1 where plan_id=?");//startstep+1
			pst.setInt(1, step.getPlan_id());
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

	@Override
	public void finishStep(BeanStep step) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_step where step_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, step.getStep_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("记录不存在");
			rs.close();
			pst.close();
			pst=conn.prepareStatement("update tbl_step set real_end_time=? where step_id=? and plan_id=?");
			pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setInt(2, step.getStep_id());
			pst.setInt(3, step.getPlan_id());
			pst.execute();
			pst.close();
			pst=conn.prepareStatement("update tbl_plan set finished_step_count=finished_step_count+1 where plan_id=?");//finishedstep+1
			pst.setInt(1, step.getPlan_id());
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

	@Override
	public void moveUp(BeanStep step) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_step where step_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, step.getStep_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("记录不存在");
			rs.close();
			pst.close();
			int i=step.getStep_id();
			int j=step.getPlan_id();
			int m=step.getStep_order();
			pst=conn.prepareStatement("update tbl_step set step_id=-1,step_order=-1 where step_id=? and plan_id=?");
			pst.setInt(1, i);
			pst.setInt(2, j);
			pst.execute();
			pst=conn.prepareStatement("update tbl_step set step_id=step_id+1,step_order=step_order+1 where step_id=? and plan_id=?");
			pst.setInt(1, i-1);
			pst.setInt(2, j);
			pst.execute();
			pst=conn.prepareStatement("update tbl_step set step_id=?,step_order=? where step_id=-1 and plan_id=?");
			pst.setInt(1, i-1);
			pst.setInt(2, m-1);
			pst.setInt(3, j);
			pst.execute();

			
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

	@Override
	public void moveDown(BeanStep step) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tbl_step where step_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, step.getStep_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("记录不存在");
			rs.close();
			pst.close();
			int i=step.getStep_id();
			int j=step.getPlan_id();
			int m=step.getStep_order();
			pst=conn.prepareStatement("update tbl_step set step_id=-1,step_order=-1 where step_id=? and plan_id=?");
			pst.setInt(1, i);
			pst.setInt(2, j);
			pst.execute();
			pst=conn.prepareStatement("update tbl_step set step_id=step_id-1,step_order=step_order-1 where step_id=? and plan_id=?");
			pst.setInt(1, i+1);
			pst.setInt(2, j);
			pst.execute();
			pst=conn.prepareStatement("update tbl_step set step_id=?,step_order=? where step_id=-1 and plan_id=?");
			pst.setInt(1, i+1);
			pst.setInt(2, m+1);
			pst.setInt(3, j);
			pst.execute();

			
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
