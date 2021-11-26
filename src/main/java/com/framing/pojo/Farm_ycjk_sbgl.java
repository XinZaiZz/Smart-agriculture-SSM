package com.framing.pojo;

//设备管理
public class Farm_ycjk_sbgl extends Pages<Farm_ycjk_sbgl>{
	
	private Integer sid;//sid
	private Integer sbid;//设备id
	private String sbmc;//设备名称
	private String sblx;//设备类型
	private String trqk;//投入情况
	private String sbzt;//设备状态
	private String szwz;//所在位置
	private String qtxx;//其他信息

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getSbid() {
		return sbid;
	}

	public void setSbid(Integer sbid) {
		this.sbid = sbid;
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getSblx() {
		return sblx;
	}

	public void setSblx(String snlx) {
		this.sblx = snlx;
	}

	public String getTrqk() {
		return trqk;
	}

	public void setTrqk(String trqk) {
		this.trqk = trqk;
	}

	public String getSbzt() {
		return sbzt;
	}

	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}

	public String getSzwz() {
		return szwz;
	}

	public void setSzwz(String szwz) {
		this.szwz = szwz;
	}

	public String getQtxx() {
		return qtxx;
	}

	public void setQtxx(String qtxx) {
		this.qtxx = qtxx;
	}
}
