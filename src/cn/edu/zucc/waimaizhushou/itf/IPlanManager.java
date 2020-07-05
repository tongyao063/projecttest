package cn.edu.zucc.waimaizhushou.itf;

import java.util.List;

import cn.edu.zucc.waimaizhushou.model.BeanPlan;
import cn.edu.zucc.waimaizhushou.util.BaseException;

public interface IPlanManager {
	/**
	 * ��Ӽƻ�
	 * Ҫ�������ļƻ��������Ϊ��ǰ�û�������������+1
	 * ע�⣺��ǰ��½�û���ͨ�� BeanUser.currentLoginUser��ȡ
	 * @param name  �ƻ�����
	 * @throws BaseException
	 */
	public BeanPlan addPlan(String name) throws BaseException;
	/**
	 * ��ȡ��ǰ�û����мƻ�
	 * @return
	 * @throws BaseException
	 */
	public List<BeanPlan> loadAll()throws BaseException;
	/**
	 * ɾ���ƻ�������ƻ��´��ڲ��裬������ɾ��
	 * @param plan
	 * @throws BaseException
	 */
	public void deletePlan(BeanPlan plan)throws BaseException;

}
