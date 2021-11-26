package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_xtrz;

import java.util.List;

public interface Farm_ycjk_xtrzMapper {

	public List<Farm_ycjk_xtrz> findAll();
	public Farm_ycjk_xtrz loginIn(Farm_ycjk_xtrz test);
	public List<Farm_ycjk_xtrz> getFarm_ycjk_xtrz(Farm_ycjk_xtrz test);
	public int addFarm_ycjk_xtrz(Farm_ycjk_xtrz test);
	public int updateFarm_ycjk_xtrz(Farm_ycjk_xtrz test);
	public int deleteFarm_ycjk_xtrz(Integer id);
	public Farm_ycjk_xtrz getOneFarm_ycjk_xtrz(Integer id);
}
