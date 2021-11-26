package com.framing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framing.mapper.Farm_ycjk_ssjkMapper;
import com.framing.pojo.Farm_ycjk_ssjk;

@Service
public class Farm_ycjk_ssjkService {
	@Autowired
	Farm_ycjk_ssjkMapper farm_ycjk_ssjkMapper;
	
	public Farm_ycjk_ssjk loginIn(Farm_ycjk_ssjk test){
		return farm_ycjk_ssjkMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_ssjk> getFarm_ycjk_ssjk(Farm_ycjk_ssjk test){
		return farm_ycjk_ssjkMapper.getFarm_ycjk_ssjk(test);
	}
	
	public boolean addFarm_ycjk_ssjk(Farm_ycjk_ssjk test) {
		boolean flag = false;
		int result = farm_ycjk_ssjkMapper.addFarm_ycjk_ssjk(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_ssjk(Farm_ycjk_ssjk test) {
		boolean flag = false;
		int result = farm_ycjk_ssjkMapper.updateFarm_ycjk_ssjk(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_ssjk(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_ssjkMapper.deleteFarm_ycjk_ssjk(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_ssjk getOneFarm_ycjk_ssjk(Integer id) {
		return farm_ycjk_ssjkMapper.getOneFarm_ycjk_ssjk(id);
	}

}
