package com.framing.pojo;
//操作记录查询
public class Farm_ycjk_czjlcx extends Pages<Farm_ycjk_czjlcx>{
	
	private Integer sid;//sid
	private String sbmc;//设备名称
	private String czzl;//操作指令
	private Integer clzt;//处理状态
	private String clsj;//处理时间
	private String bz;//备注
	private String czym;//操作员名
	private String startDate;//作为接收前端传来的起始时间，并不作为数据库内的属性
	private String endDate;//结束时间

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getCzzl() {
		return czzl;
	}

	public void setCzzl(String czzl) {
		this.czzl = czzl;
	}

	public Integer getClzt() {
		return clzt;
	}

	public void setClzt(Integer clzt) {
		this.clzt = clzt;
	}

	public String getClsj() {
		return clsj;
	}

	public void setClsj(String clsj) {
		this.clsj = clsj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getCzym() {
		return czym;
	}

	public void setCzym(String czym) {
		this.czym = czym;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
