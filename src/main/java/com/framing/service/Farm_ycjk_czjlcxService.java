package com.framing.service;

import com.framing.mapper.Farm_ycjk_czjlcxMapper;
import com.framing.pojo.Farm_ycjk_czjlcx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_czjlcxService {
	@Autowired
	Farm_ycjk_czjlcxMapper farm_ycjk_czjlcxMapper;

	public List<Farm_ycjk_czjlcx> findAll(){
		return farm_ycjk_czjlcxMapper.findAll();
	}
	public Farm_ycjk_czjlcx loginIn(Farm_ycjk_czjlcx test){
		return farm_ycjk_czjlcxMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_czjlcx> getFarm_ycjk_czjlcx(Farm_ycjk_czjlcx test){
		return farm_ycjk_czjlcxMapper.getFarm_ycjk_czjlcx(test);
	}
	
	public boolean addFarm_ycjk_czjlcx(Farm_ycjk_czjlcx test) {
		boolean flag = false;
		int result = farm_ycjk_czjlcxMapper.addFarm_ycjk_czjlcx(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_czjlcx(Farm_ycjk_czjlcx test) {
		boolean flag = false;
		int result = farm_ycjk_czjlcxMapper.updateFarm_ycjk_czjlcx(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_czjlcx(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_czjlcxMapper.deleteFarm_ycjk_czjlcx(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_czjlcx getOneFarm_ycjk_czjlcx(Integer id) {
		return farm_ycjk_czjlcxMapper.getOneFarm_ycjk_czjlcx(id);
	}

}
