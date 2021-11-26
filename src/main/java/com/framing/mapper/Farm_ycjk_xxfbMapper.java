package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_xxfb;

import java.util.List;

public interface Farm_ycjk_xxfbMapper {

	public List<Farm_ycjk_xxfb> findAll();
	public Farm_ycjk_xxfb loginIn(Farm_ycjk_xxfb test);
	public List<Farm_ycjk_xxfb> getFarm_ycjk_xxfb(Farm_ycjk_xxfb test);
	public int addFarm_ycjk_xxfb(Farm_ycjk_xxfb test);
	public int updateFarm_ycjk_xxfb(Farm_ycjk_xxfb test);
	public int deleteFarm_ycjk_xxfb(Integer id);
	public Farm_ycjk_xxfb getOneFarm_ycjk_xxfb(Integer id);
}
