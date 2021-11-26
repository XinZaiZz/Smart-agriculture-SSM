//作物生长历史
package com.framing.pojo;

public class Farm_ycjk_zwszls extends Pages<Farm_ycjk_zwszls>{
	
	private Integer sid;//sid
	private float ymjzs;//叶面积指数
	private float gyhzs;//归一化指数
	private float yphsl;//叶片含水量
	private float ylshl;//叶绿素含量
	private String jlsj;//记录时间
	private String startDate;//作为接收前端传来的起始时间，并不作为数据库内的属性
	private String endDate;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public float getYmjzs() {
		return ymjzs;
	}

	public void setYmjzs(float ymjzs) {
		this.ymjzs = ymjzs;
	}

	public float getGyhzs() {
		return gyhzs;
	}

	public void setGyhzs(float gyhzs) {
		this.gyhzs = gyhzs;
	}

	public float getYphsl() {
		return yphsl;
	}

	public void setYphsl(float yphsl) {
		this.yphsl = yphsl;
	}

	public float getYlshl() {
		return ylshl;
	}

	public void setYlshl(float ylshl) {
		this.ylshl = ylshl;
	}

	public String getJlsj() {
		return jlsj;
	}

	public void setJlsj(String jlsj) {
		this.jlsj = jlsj;
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
