package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_scgc;

import java.util.List;

public interface Farm_ycjk_scgcMapper {

	public List<Farm_ycjk_scgc> findAll();
	public Farm_ycjk_scgc loginIn(Farm_ycjk_scgc test);
	public List<Farm_ycjk_scgc> getFarm_ycjk_scgc(Farm_ycjk_scgc test);
	public int addFarm_ycjk_scgc(Farm_ycjk_scgc test);
	public int updateFarm_ycjk_scgc(Farm_ycjk_scgc test);
	public int deleteFarm_ycjk_scgc(Integer id);
	public Farm_ycjk_scgc getOneFarm_ycjk_scgc(Integer id);
}
