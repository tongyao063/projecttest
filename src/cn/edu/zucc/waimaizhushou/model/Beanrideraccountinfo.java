package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beanrideraccountinfo {
	private int riderid;
	private int ordersid;
	private Date accountdate;
	private String ridercomment;
	private double singleincome;
	
	public int getRiderid() {
		return riderid;
	}
	public void setRiderid(int riderid) {
		this.riderid = riderid;
	}
	public int getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}
	public Date getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}
	public String getRidercomment() {
		return ridercomment;
	}
	public void setRidercomment(String ridercomment) {
		this.ridercomment = ridercomment;
	}
	public double getSingleincome() {
		return singleincome;
	}
	public void setSingleincome(double singleincome) {
		this.singleincome = singleincome;
	}
	
}
