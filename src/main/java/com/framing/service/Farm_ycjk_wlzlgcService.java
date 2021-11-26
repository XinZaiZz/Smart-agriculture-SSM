package com.framing.service;

import com.framing.mapper.Farm_ycjk_wlzlgcMapper;
import com.framing.pojo.Farm_ycjk_wlzlgc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_wlzlgcService {
	@Autowired
	Farm_ycjk_wlzlgcMapper farm_ycjk_wlzlgcMapper;

	public List<Farm_ycjk_wlzlgc> findAll(){
		return farm_ycjk_wlzlgcMapper.findAll();
	}
	public Farm_ycjk_wlzlgc loginIn(Farm_ycjk_wlzlgc test){
		return farm_ycjk_wlzlgcMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_wlzlgc> getFarm_ycjk_wlzlgc(Farm_ycjk_wlzlgc test){
		return farm_ycjk_wlzlgcMapper.getFarm_ycjk_wlzlgc(test);
	}
	
	public boolean addFarm_ycjk_wlzlgc(Farm_ycjk_wlzlgc test) {
		boolean flag = false;
		int result = farm_ycjk_wlzlgcMapper.addFarm_ycjk_wlzlgc(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_wlzlgc(Farm_ycjk_wlzlgc test) {
		boolean flag = false;
		int result = farm_ycjk_wlzlgcMapper.updateFarm_ycjk_wlzlgc(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_wlzlgc(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_wlzlgcMapper.deleteFarm_ycjk_wlzlgc(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_wlzlgc getOneFarm_ycjk_wlzlgc(Integer id) {
		return farm_ycjk_wlzlgcMapper.getOneFarm_ycjk_wlzlgc(id);
	}

}
