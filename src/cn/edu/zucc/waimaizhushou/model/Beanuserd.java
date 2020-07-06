package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beanuserd {
	public static Beanuserd currentLoginuser=null;
	private int userid;
	private String username;
	private String usergender;
	private String userpwd;
	private String userphonenum;
	private String useremail;
	private String usercity;
	private Date userregisttime;
	private String vipjud;
	private Date vipdeadline;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public static Beanuserd getCurrentLoginuser() {
		return currentLoginuser;
	}
	public static void setCurrentLoginuser(Beanuserd currentLoginuser) {
		Beanuserd.currentLoginuser = currentLoginuser;
	}
	public String getVipjud() {
		return vipjud;
	}
	public void setVipjud(String vipjud) {
		this.vipjud = vipjud;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUserphonenum() {
		return userphonenum;
	}
	public void setUserphonenum(String userphonenum) {
		this.userphonenum = userphonenum;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsercity() {
		return usercity;
	}
	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}
	public Date getUserregisttime() {
		return userregisttime;
	}
	public void setUserregisttime(Date userregisttime) {
		this.userregisttime = userregisttime;
	}
	public Date getVipdeadline() {
		return vipdeadline;
	}
	public void setVipdeadline(Date vipdeadline) {
		this.vipdeadline = vipdeadline;
	}
	
}
