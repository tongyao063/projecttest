package cn.edu.zucc.waimaizhushou.model;
import java.util.Date;

public class Beangoodreview {
	private int goodid;
	private int userid;
	private int merchantid;
	private String reviewcontent;
	private Date reviewdate;
	private int reviewgrade;
	private int reviewphoto;
	
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public String getReviewcontent() {
		return reviewcontent;
	}
	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}
	public Date getReviewdate() {
		return reviewdate;
	}
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	public int getReviewgrade() {
		return reviewgrade;
	}
	public void setReviewgrade(int reviewgrade) {
		this.reviewgrade = reviewgrade;
	}
	public int getReviewphoto() {
		return reviewphoto;
	}
	public void setReviewphoto(int reviewphoto) {
		this.reviewphoto = reviewphoto;
	}
	
	
}
