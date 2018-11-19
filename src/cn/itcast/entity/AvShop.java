package cn.itcast.entity;

import java.util.Date;

public class AvShop {
	 private Integer avid;
	 private String avname;
	 private String avtitle;

	 private String avdesc;
	 private Date avcreatetime;
	 private String avimgsrc;
	 private String avvideosrc;
	 private boolean avstatus;
	 
	public AvShop() {
	}
	public AvShop(Integer avid, String avname, String avtitle, String avdesc,
			Date avcreatetime, String avimgsrc, String avvideosrc,
			boolean avstatus) {
		this.avid = avid;
		this.avname = avname;
		this.avtitle = avtitle;
		this.avdesc = avdesc;
		this.avcreatetime = avcreatetime;
		this.avimgsrc = avimgsrc;
		this.avvideosrc = avvideosrc;
		this.avstatus = avstatus;
	}
	public Integer getAvid() {
		return avid;
	}
	public void setAvid(Integer avid) {
		this.avid = avid;
	}
	public String getAvname() {
		return avname;
	}
	public void setAvname(String avname) {
		this.avname = avname;
	}
	public String getAvtitle() {
		return avtitle;
	}
	public void setAvtitle(String avtitle) {
		this.avtitle = avtitle;
	}
	public String getAvdesc() {
		return avdesc;
	}
	public void setAvdesc(String avdesc) {
		this.avdesc = avdesc;
	}
	public Date getAvcreatetime() {
		return avcreatetime;
	}
	public void setAvcreatetime(Date avcreatetime) {
		this.avcreatetime = avcreatetime;
	}
	public String getAvimgsrc() {
		return avimgsrc;
	}
	public void setAvimgsrc(String avimgsrc) {
		this.avimgsrc = avimgsrc;
	}
	public String getAvvideosrc() {
		return avvideosrc;
	}
	public void setAvvideosrc(String avvideosrc) {
		this.avvideosrc = avvideosrc;
	}
	public boolean isAvstatus() {
		return avstatus;
	}
	public void setAvstatus(boolean avstatus) {
		this.avstatus = avstatus;
	}
	 
	
	 
}
