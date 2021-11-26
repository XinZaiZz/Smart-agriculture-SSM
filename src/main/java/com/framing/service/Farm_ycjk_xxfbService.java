package com.framing.service;

import com.framing.mapper.Farm_ycjk_xxfbMapper;
import com.framing.pojo.Farm_ycjk_xxfb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_xxfbService {
	@Autowired
	Farm_ycjk_xxfbMapper farm_ycjk_xxfbMapper;

	public List<Farm_ycjk_xxfb> findAll(){
		return farm_ycjk_xxfbMapper.findAll();
	}
	public Farm_ycjk_xxfb loginIn(Farm_ycjk_xxfb test){
		return farm_ycjk_xxfbMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_xxfb> getFarm_ycjk_xxfb(Farm_ycjk_xxfb test){
		return farm_ycjk_xxfbMapper.getFarm_ycjk_xxfb(test);
	}
	
	public boolean addFarm_ycjk_xxfb(Farm_ycjk_xxfb test) {
		boolean flag = false;
		int result = farm_ycjk_xxfbMapper.addFarm_ycjk_xxfb(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_xxfb(Farm_ycjk_xxfb test) {
		boolean flag = false;
		int result = farm_ycjk_xxfbMapper.updateFarm_ycjk_xxfb(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_xxfb(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_xxfbMapper.deleteFarm_ycjk_xxfb(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_xxfb getOneFarm_ycjk_xxfb(Integer id) {
		return farm_ycjk_xxfbMapper.getOneFarm_ycjk_xxfb(id);
	}

}
