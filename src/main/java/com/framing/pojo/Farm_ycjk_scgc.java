//生产过程
package com.framing.pojo;


public class Farm_ycjk_scgc extends Pages<Farm_ycjk_scgc>{
	
	private Integer sid;//sid
	private String scgcms;//生产过程描述
	private String bzxx;//备注信息
	private String czsj;//操作时间
	private String czry;//操作人员

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getScgcms() {
		return scgcms;
	}

	public void setScgcms(String scgcms) {
		this.scgcms = scgcms;
	}

	public String getBzxx() {
		return bzxx;
	}

	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}

	public String getCzsj() {
		return czsj;
	}

	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}

	public String getCzry() {
		return czry;
	}

	public void setCzry(String czry) {
		this.czry = czry;
	}
}
