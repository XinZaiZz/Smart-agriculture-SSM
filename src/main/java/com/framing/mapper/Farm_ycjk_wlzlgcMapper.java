package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_wlzlgc;

import java.util.List;

public interface Farm_ycjk_wlzlgcMapper {

	public List<Farm_ycjk_wlzlgc> findAll();
	public Farm_ycjk_wlzlgc loginIn(Farm_ycjk_wlzlgc test);
	public List<Farm_ycjk_wlzlgc> getFarm_ycjk_wlzlgc(Farm_ycjk_wlzlgc test);
	public int addFarm_ycjk_wlzlgc(Farm_ycjk_wlzlgc test);
	public int updateFarm_ycjk_wlzlgc(Farm_ycjk_wlzlgc test);
	public int deleteFarm_ycjk_wlzlgc(Integer id);
	public Farm_ycjk_wlzlgc getOneFarm_ycjk_wlzlgc(Integer id);
}
