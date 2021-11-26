//系统日志
package com.framing.pojo;

public class Farm_ycjk_xtrz extends Pages<Farm_ycjk_xtrz>{
	
	private Integer sid;//sid
	private String rzlx;//日志类型
	private String rznr;//日志内容
	private String jlsj;//记录时间
	private String czry;//操作人员
	private String startDate;//前端查询的起始时间
	private String endDate;//结束时间

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getRzlx() {
		return rzlx;
	}

	public void setRzlx(String rzlx) {
		this.rzlx = rzlx;
	}

	public String getRznr() {
		return rznr;
	}

	public void setRznr(String rznr) {
		this.rznr = rznr;
	}

	public String getJlsj() {
		return jlsj;
	}

	public void setJlsj(String jlsj) {
		this.jlsj = jlsj;
	}

	public String getCzry() {
		return czry;
	}

	public void setCzry(String czry) {
		this.czry = czry;
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
