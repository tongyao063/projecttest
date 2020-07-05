package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beanmerchant {
	private int merchantid;
	private String merchantname;
	private int merchantgrade;
	private double perconsumption;
	private int totalsales;
	private String merchanpwd;
	private Date merchantregistertime;
	
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public String getMerchantname() {
		return merchantname;
	}
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}
	public int getMerchantgrade() {
		return merchantgrade;
	}
	public void setMerchantgrade(int merchantgrade) {
		this.merchantgrade = merchantgrade;
	}
	public double getPerconsumption() {
		return perconsumption;
	}
	public void setPerconsumption(double perconsumption) {
		this.perconsumption = perconsumption;
	}
	public int getTotalsales() {
		return totalsales;
	}
	public void setTotalsales(int totalsales) {
		this.totalsales = totalsales;
	}
	public String getMerchanpwd() {
		return merchanpwd;
	}
	public void setMerchanpwd(String merchanpwd) {
		this.merchanpwd = merchanpwd;
	}
	public Date getMerchantregistertime() {
		return merchantregistertime;
	}
	public void setMerchantregistertime(Date merchantregistertime) {
		this.merchantregistertime = merchantregistertime;
	}
	
	
}
