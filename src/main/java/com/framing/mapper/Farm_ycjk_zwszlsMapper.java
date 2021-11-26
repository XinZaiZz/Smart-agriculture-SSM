package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_zwszls;

import java.util.List;

public interface Farm_ycjk_zwszlsMapper {

	public List<Farm_ycjk_zwszls> findAll();
	public Farm_ycjk_zwszls loginIn(Farm_ycjk_zwszls test);
	public List<Farm_ycjk_zwszls> getFarm_ycjk_zwszls(Farm_ycjk_zwszls test);
	public int addFarm_ycjk_zwszls(Farm_ycjk_zwszls test);
	public int updateFarm_ycjk_zwszls(Farm_ycjk_zwszls test);
	public int deleteFarm_ycjk_zwszls(Integer id);
	public Farm_ycjk_zwszls getOneFarm_ycjk_zwszls(Integer id);
}
