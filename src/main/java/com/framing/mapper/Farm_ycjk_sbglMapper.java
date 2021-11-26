package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_sbgl;

import java.util.List;

public interface Farm_ycjk_sbglMapper {

	public List<Farm_ycjk_sbgl> findAll();
	public Farm_ycjk_sbgl loginIn(Farm_ycjk_sbgl test);
	public List<Farm_ycjk_sbgl> getFarm_ycjk_sbgl(Farm_ycjk_sbgl test);
	public int addFarm_ycjk_sbgl(Farm_ycjk_sbgl test);
	public int updateFarm_ycjk_sbgl(Farm_ycjk_sbgl test);
	public int deleteFarm_ycjk_sbgl(Integer id);
	public Farm_ycjk_sbgl getOneFarm_ycjk_sbgl(Integer id);
}
