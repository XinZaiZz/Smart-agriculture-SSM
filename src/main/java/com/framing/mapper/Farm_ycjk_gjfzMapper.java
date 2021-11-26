package com.framing.mapper;

import com.framing.pojo.Farm_ycjk_gjfz;

import java.util.List;

public interface Farm_ycjk_gjfzMapper {
	
	public Farm_ycjk_gjfz loginIn(Farm_ycjk_gjfz test);
	public List<Farm_ycjk_gjfz> getFarm_ycjk_gjfz(Farm_ycjk_gjfz test);
	public int addFarm_ycjk_gjfz(Farm_ycjk_gjfz test);
	public int updateFarm_ycjk_gjfz(Farm_ycjk_gjfz test);
	public int deleteFarm_ycjk_gjfz(Integer id);
	public Farm_ycjk_gjfz getOneFarm_ycjk_gjfz(Integer id);
}
