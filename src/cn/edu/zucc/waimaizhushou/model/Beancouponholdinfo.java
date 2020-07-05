package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beancouponholdinfo {
	private int userid;
	private int meuchantid;
	private int conpunid;
	private double discountinfo;
	private int couponholdcnt;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMeuchantid() {
		return meuchantid;
	}
	public void setMeuchantid(int meuchantid) {
		this.meuchantid = meuchantid;
	}
	public int getConpunid() {
		return conpunid;
	}
	public void setConpunid(int conpunid) {
		this.conpunid = conpunid;
	}
	public double getDiscountinfo() {
		return discountinfo;
	}
	public void setDiscountinfo(double discountinfo) {
		this.discountinfo = discountinfo;
	}
	public int getCouponholdcnt() {
		return couponholdcnt;
	}
	public void setCouponholdcnt(int couponholdcnt) {
		this.couponholdcnt = couponholdcnt;
	}
	public Date getCouponholddeadline() {
		return couponholddeadline;
	}
	public void setCouponholddeadline(Date couponholddeadline) {
		this.couponholddeadline = couponholddeadline;
	}
	private Date couponholddeadline;
}
