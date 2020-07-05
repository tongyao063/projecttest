package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beancoupon {
	private int couponid;
	private double coupondiscount;
	private int collectlistcnt;
	private Date couponstartdate;
	private Date couponenddate;
	
	public int getCouponid() {
		return couponid;
	}
	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}
	public double getCoupondiscount() {
		return coupondiscount;
	}
	public void setCoupondiscount(double coupondiscount) {
		this.coupondiscount = coupondiscount;
	}
	public int getCollectlistcnt() {
		return collectlistcnt;
	}
	public void setCollectlistcnt(int collectlistcnt) {
		this.collectlistcnt = collectlistcnt;
	}
	public Date getCouponstartdate() {
		return couponstartdate;
	}
	public void setCouponstartdate(Date couponstartdate) {
		this.couponstartdate = couponstartdate;
	}
	public Date getCouponenddate() {
		return couponenddate;
	}
	public void setCouponenddate(Date couponenddate) {
		this.couponenddate = couponenddate;
	}

}
