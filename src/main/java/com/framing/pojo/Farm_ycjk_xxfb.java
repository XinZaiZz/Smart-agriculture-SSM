//信息发布实体
package com.framing.pojo;

//设备管理
public class Farm_ycjk_xxfb extends Pages<Farm_ycjk_xxfb>{
	
	private Integer sid;//sid
	private String xxbt;//信息标题
	private String xxnr;//信息内容
	private String bcsj;//保存时间

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getXxbt() {
		return xxbt;
	}

	public void setXxbt(String xxbt) {
		this.xxbt = xxbt;
	}

	public String getXxnr() {
		return xxnr;
	}

	public void setXxnr(String xxnr) {
		this.xxnr = xxnr;
	}

	public String getBcsj() {
		return bcsj;
	}

	public void setBcsj(String bcsj) {
		this.bcsj = bcsj;
	}
}
