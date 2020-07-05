package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beangoodorders {
	private int ordersid;
	private int fullreduceid;
	private int merchantid;
	private int addressid;
	private int couponid;
	private int userid;
	private int riderid;
	private double originalamount;
	private double settlementamount;
	private Date orderstime;
	private Date requesttime;
	private String ordersstatus;
	
	public int getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}
	public int getFullreduceid() {
		return fullreduceid;
	}
	public void setFullreduceid(int fullreduceid) {
		this.fullreduceid = fullreduceid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getCouponid() {
		return couponid;
	}
	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRiderid() {
		return riderid;
	}
	public void setRiderid(int riderid) {
		this.riderid = riderid;
	}
	public double getOriginalamount() {
		return originalamount;
	}
	public void setOriginalamount(double originalamount) {
		this.originalamount = originalamount;
	}
	public double getSettlementamount() {
		return settlementamount;
	}
	public void setSettlementamount(double settlementamount) {
		this.settlementamount = settlementamount;
	}
	public Date getOrderstime() {
		return orderstime;
	}
	public void setOrderstime(Date orderstime) {
		this.orderstime = orderstime;
	}
	public Date getRequesttime() {
		return requesttime;
	}
	public void setRequesttime(Date requesttime) {
		this.requesttime = requesttime;
	}
	public String getOrdersstatus() {
		return ordersstatus;
	}
	public void setOrdersstatus(String ordersstatus) {
		this.ordersstatus = ordersstatus;
	}
	
	
}
