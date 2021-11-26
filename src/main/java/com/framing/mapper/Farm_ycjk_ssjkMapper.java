package com.framing.mapper;

import java.util.List;

import com.framing.pojo.Farm_ycjk_ssjk;

public interface Farm_ycjk_ssjkMapper {
	
	public Farm_ycjk_ssjk loginIn(Farm_ycjk_ssjk test);
	public List<Farm_ycjk_ssjk> getFarm_ycjk_ssjk(Farm_ycjk_ssjk test);
	public int addFarm_ycjk_ssjk(Farm_ycjk_ssjk test);
	public int updateFarm_ycjk_ssjk(Farm_ycjk_ssjk test);
	public int deleteFarm_ycjk_ssjk(Integer id);
	public Farm_ycjk_ssjk getOneFarm_ycjk_ssjk(Integer id);
}
