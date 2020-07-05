package cn.edu.zucc.waimaizhushou.model;

public class Beangood {
	private int goodid;
	private int classificationid;
	private String  goodname;
	private double goodprice;
	private double discountprice;
	private int sales;
	private int inventory;
	
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public int getClassificationid() {
		return classificationid;
	}
	public void setClassificationid(int classificationid) {
		this.classificationid = classificationid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public double getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(double goodprice) {
		this.goodprice = goodprice;
	}
	public double getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(double discountprice) {
		this.discountprice = discountprice;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	
}
