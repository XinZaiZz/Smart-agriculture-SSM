package com.framing.service;

import com.framing.mapper.Farm_ycjk_gjfzMapper;
import com.framing.pojo.Farm_ycjk_gjfz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_gjfzService {
	@Autowired
	Farm_ycjk_gjfzMapper farm_ycjk_gjfzMapper;
	
	public Farm_ycjk_gjfz loginIn(Farm_ycjk_gjfz test){
		return farm_ycjk_gjfzMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_gjfz> getFarm_ycjk_gjfz(Farm_ycjk_gjfz test){
		return farm_ycjk_gjfzMapper.getFarm_ycjk_gjfz(test);
	}
	
	public boolean addFarm_ycjk_gjfz(Farm_ycjk_gjfz test) {
		boolean flag = false;
		int result = farm_ycjk_gjfzMapper.addFarm_ycjk_gjfz(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_gjfz(Farm_ycjk_gjfz test) {
		boolean flag = false;
		int result = farm_ycjk_gjfzMapper.updateFarm_ycjk_gjfz(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_gjfz(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_gjfzMapper.deleteFarm_ycjk_gjfz(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_gjfz getOneFarm_ycjk_gjfz(Integer id) {
		return farm_ycjk_gjfzMapper.getOneFarm_ycjk_gjfz(id);
	}

}
