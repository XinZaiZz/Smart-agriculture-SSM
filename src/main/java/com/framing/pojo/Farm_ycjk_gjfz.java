package com.framing.pojo;
//告警阀值
public class Farm_ycjk_gjfz extends Pages<Farm_ycjk_gjfz>{
	
	private Integer sid;//sid
	private float kqwd_max;//空气温度上限值
	private float kqwd_min;//空气温度下限值
	private float kqsd_max;//空气湿度上限值
	private float kqsd_min;//空气湿度下限值
	private float co2_max;//co2浓度上限值
	private float co2_min;//co2浓度下限值
	private float gzqd_max;//光照强度上限值
	private float gzqd_min;//光照强度下限值

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public float getKqwd_max() {
		return kqwd_max;
	}

	public void setKqwd_max(float kqwd_max) {
		this.kqwd_max = kqwd_max;
	}

	public float getKqwd_min() {
		return kqwd_min;
	}

	public void setKqwd_min(float kqwd_min) {
		this.kqwd_min = kqwd_min;
	}

	public float getKqsd_max() {
		return kqsd_max;
	}

	public void setKqsd_max(float kqsd_max) {
		this.kqsd_max = kqsd_max;
	}

	public float getKqsd_min() {
		return kqsd_min;
	}

	public void setKqsd_min(float kqsd_min) {
		this.kqsd_min = kqsd_min;
	}

	public float getCo2_max() {
		return co2_max;
	}

	public void setCo2_max(float co2_max) {
		this.co2_max = co2_max;
	}

	public float getCo2_min() {
		return co2_min;
	}

	public void setCo2_min(float co2_min) {
		this.co2_min = co2_min;
	}

	public float getGzqd_max() {
		return gzqd_max;
	}

	public void setGzqd_max(float gzqd_max) {
		this.gzqd_max = gzqd_max;
	}

	public float getGzqd_min() {
		return gzqd_min;
	}

	public void setGzqd_min(float gzqd_min) {
		this.gzqd_min = gzqd_min;
	}


}
