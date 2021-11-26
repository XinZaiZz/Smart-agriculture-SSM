//预警策略配置
package com.framing.pojo;

public class Farm_ycjk_yjclpz extends Pages<Farm_ycjk_yjclpz>{
	
	private Integer sid;//sid
	private String yjclmc;//预警策略名称
	private Integer yjdj;//预警等级
	private	String zysj;//作用时间

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getYjclmc() {
		return yjclmc;
	}

	public void setYjclmc(String yjclmc) {
		this.yjclmc = yjclmc;
	}

	public Integer getYjdj() {
		return yjdj;
	}

	public void setYjdj(Integer yjdj) {
		this.yjdj = yjdj;
	}

	public String getZysj() {
		return zysj;
	}

	public void setZysj(String zysj) {
		this.zysj = zysj;
	}
}
