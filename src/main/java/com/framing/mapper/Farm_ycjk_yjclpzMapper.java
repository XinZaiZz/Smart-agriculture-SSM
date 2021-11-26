package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_yjclpz;

import java.util.List;

public interface Farm_ycjk_yjclpzMapper {

	public List<Farm_ycjk_yjclpz> findAll();
	public Farm_ycjk_yjclpz loginIn(Farm_ycjk_yjclpz test);
	public List<Farm_ycjk_yjclpz> getFarm_ycjk_yjclpz(Farm_ycjk_yjclpz test);
	public int addFarm_ycjk_yjclpz(Farm_ycjk_yjclpz test);
	public int updateFarm_ycjk_yjclpz(Farm_ycjk_yjclpz test);
	public int deleteFarm_ycjk_yjclpz(Integer id);
	public Farm_ycjk_yjclpz getOneFarm_ycjk_yjclpz(Integer id);
}
