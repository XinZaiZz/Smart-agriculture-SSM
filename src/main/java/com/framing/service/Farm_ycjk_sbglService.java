package com.framing.service;

import com.framing.mapper.Farm_ycjk_sbglMapper;
import com.framing.pojo.Farm_ycjk_sbgl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_sbglService {
	@Autowired
	Farm_ycjk_sbglMapper farm_ycjk_sbglMapper;

	public List<Farm_ycjk_sbgl> findAll(){
		return farm_ycjk_sbglMapper.findAll();
	}
	public Farm_ycjk_sbgl loginIn(Farm_ycjk_sbgl test){
		return farm_ycjk_sbglMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_sbgl> getFarm_ycjk_sbgl(Farm_ycjk_sbgl test){
		return farm_ycjk_sbglMapper.getFarm_ycjk_sbgl(test);
	}
	
	public boolean addFarm_ycjk_sbgl(Farm_ycjk_sbgl test) {
		boolean flag = false;
		int result = farm_ycjk_sbglMapper.addFarm_ycjk_sbgl(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_sbgl(Farm_ycjk_sbgl test) {
		boolean flag = false;
		int result = farm_ycjk_sbglMapper.updateFarm_ycjk_sbgl(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_sbgl(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_sbglMapper.deleteFarm_ycjk_sbgl(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_sbgl getOneFarm_ycjk_sbgl(Integer id) {
		return farm_ycjk_sbglMapper.getOneFarm_ycjk_sbgl(id);
	}

}
