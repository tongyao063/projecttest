package cn.edu.zucc.waimaizhushou.model;

public class Beanordersdetails {
	private int goodid;
	private int ordersid;
	private int ordergoodcnt;
	private double oedergoodprice;
	private double singlegooddiscount;
	
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public int getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}
	public int getOrdergoodcnt() {
		return ordergoodcnt;
	}
	public void setOrdergoodcnt(int ordergoodcnt) {
		this.ordergoodcnt = ordergoodcnt;
	}
	public double getOedergoodprice() {
		return oedergoodprice;
	}
	public void setOedergoodprice(double oedergoodprice) {
		this.oedergoodprice = oedergoodprice;
	}
	public double getSinglegooddiscount() {
		return singlegooddiscount;
	}
	public void setSinglegooddiscount(double singlegooddiscount) {
		this.singlegooddiscount = singlegooddiscount;
	}
}
