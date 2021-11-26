package com.framing.mapper;



import com.framing.pojo.Farm_ycjk_czjlcx;

import java.util.List;

public interface Farm_ycjk_czjlcxMapper {

	public List<Farm_ycjk_czjlcx> findAll();
	public Farm_ycjk_czjlcx loginIn(Farm_ycjk_czjlcx test);
	public List<Farm_ycjk_czjlcx> getFarm_ycjk_czjlcx(Farm_ycjk_czjlcx test);
	public int addFarm_ycjk_czjlcx(Farm_ycjk_czjlcx test);
	public int updateFarm_ycjk_czjlcx(Farm_ycjk_czjlcx test);
	public int deleteFarm_ycjk_czjlcx(Integer id);
	public Farm_ycjk_czjlcx getOneFarm_ycjk_czjlcx(Integer id);
}
