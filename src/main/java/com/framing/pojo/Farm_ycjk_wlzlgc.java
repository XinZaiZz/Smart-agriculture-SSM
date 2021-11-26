//物流质量过程
package com.framing.pojo;

public class Farm_ycjk_wlzlgc extends Pages<Farm_ycjk_wlzlgc>{
	
	private Integer sid;//sid
	private String cphm;//产品号码
	private String zslb;//追溯类别
	private String czmc;//操作名称
	private String czsj;//操作时间

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getCphm() {
		return cphm;
	}

	public void setCphm(String cphm) {
		this.cphm = cphm;
	}

	public String getZslb() {
		return zslb;
	}

	public void setZslb(String zslb) {
		this.zslb = zslb;
	}

	public String getCzmc() {
		return czmc;
	}

	public void setCzmc(String czmc) {
		this.czmc = czmc;
	}

	public String getCzsj() {
		return czsj;
	}

	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
}
