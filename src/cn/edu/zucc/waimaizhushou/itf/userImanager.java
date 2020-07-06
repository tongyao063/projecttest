package cn.edu.zucc.waimaizhushou.itf;

import cn.edu.zucc.waimaizhushou.model.Beanuserd;
import java.util.Date;
import cn.edu.zucc.waimaizhushou.util.BaseException;

public interface userImanager {
	/**
	 * ע�᣺
	 * Ҫ���û��������ظ�������Ϊ��
	 * ����������������һ�£����벻��Ϊ��
	 * ���ע��ʧ�ܣ����׳��쳣
	 * @param userid
	 * @param pwd  ����
	 * @param pwd2 �ظ����������
	 * @return
	 * @throws BaseException
	 */
	public Beanuserd reg(int userid,String useriname, String pwd1,String pwd2) throws BaseException;
	
	
	/**
	 * ��½
	 * 1������û������ڻ�����������׳�һ���쳣
	 * 2�������֤�ɹ����򷵻ص�ǰ�û���Ϣ
	 * @param userid
	 * @param pwd
	 * @return
	 * @throws BaseException
	 */
	public Beanuserd login(int userid,String pwd)throws BaseException;
	/**
	 * �޸�����
	 * ���û�гɹ��޸ģ����׳��쳣
	 * @param currentLoginuser    ��ǰ�û�
	 * @param oldPwd  ԭ����
	 * @param newPwd  ������
	 * @param newPwd2 �ظ������������
	 */
	public void changePwd(String oldPwd, String newPwd,String newPwd2,Beanuserd currentLoginuser) throws BaseException;
	//���Ƹ�����Ϣ
	public void improvepersonalinfo(String gender, String phonenum,String email,String city,Beanuserd user) throws BaseException;
	//��Ա
	public void vipregistinfo(Beanuserd user) throws BaseException;
}
