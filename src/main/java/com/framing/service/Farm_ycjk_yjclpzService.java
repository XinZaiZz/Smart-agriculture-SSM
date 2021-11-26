package com.framing.service;

import com.framing.mapper.Farm_ycjk_yjclpzMapper;
import com.framing.pojo.Farm_ycjk_yjclpz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_yjclpzService {
	@Autowired
	Farm_ycjk_yjclpzMapper farm_ycjk_yjclpzMapper;

	public List<Farm_ycjk_yjclpz> findAll(){
		return farm_ycjk_yjclpzMapper.findAll();
	}
	public Farm_ycjk_yjclpz loginIn(Farm_ycjk_yjclpz test){
		return farm_ycjk_yjclpzMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_yjclpz> getFarm_ycjk_yjclpz(Farm_ycjk_yjclpz test){
		return farm_ycjk_yjclpzMapper.getFarm_ycjk_yjclpz(test);
	}
	
	public boolean addFarm_ycjk_yjclpz(Farm_ycjk_yjclpz test) {
		boolean flag = false;
		int result = farm_ycjk_yjclpzMapper.addFarm_ycjk_yjclpz(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_yjclpz(Farm_ycjk_yjclpz test) {
		boolean flag = false;
		int result = farm_ycjk_yjclpzMapper.updateFarm_ycjk_yjclpz(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_yjclpz(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_yjclpzMapper.deleteFarm_ycjk_yjclpz(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_yjclpz getOneFarm_ycjk_yjclpz(Integer id) {
		return farm_ycjk_yjclpzMapper.getOneFarm_ycjk_yjclpz(id);
	}

}
