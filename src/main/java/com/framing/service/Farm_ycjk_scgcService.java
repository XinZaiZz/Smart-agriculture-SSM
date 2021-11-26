package com.framing.service;

import com.framing.mapper.Farm_ycjk_scgcMapper;
import com.framing.pojo.Farm_ycjk_scgc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_scgcService {
	@Autowired
	Farm_ycjk_scgcMapper farm_ycjk_scgcMapper;

	public List<Farm_ycjk_scgc> findAll(){
		return farm_ycjk_scgcMapper.findAll();
	}
	public Farm_ycjk_scgc loginIn(Farm_ycjk_scgc test){
		return farm_ycjk_scgcMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_scgc> getFarm_ycjk_scgc(Farm_ycjk_scgc test){
		return farm_ycjk_scgcMapper.getFarm_ycjk_scgc(test);
	}
	
	public boolean addFarm_ycjk_scgc(Farm_ycjk_scgc test) {
		boolean flag = false;
		int result = farm_ycjk_scgcMapper.addFarm_ycjk_scgc(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_scgc(Farm_ycjk_scgc test) {
		boolean flag = false;
		int result = farm_ycjk_scgcMapper.updateFarm_ycjk_scgc(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_scgc(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_scgcMapper.deleteFarm_ycjk_scgc(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_scgc getOneFarm_ycjk_scgc(Integer id) {
		return farm_ycjk_scgcMapper.getOneFarm_ycjk_scgc(id);
	}

}
