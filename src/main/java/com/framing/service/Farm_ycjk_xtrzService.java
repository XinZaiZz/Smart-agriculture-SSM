package com.framing.service;

import com.framing.mapper.Farm_ycjk_xtrzMapper;
import com.framing.pojo.Farm_ycjk_xtrz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_xtrzService {
	@Autowired
	Farm_ycjk_xtrzMapper farm_ycjk_xtrzMapper;

	public List<Farm_ycjk_xtrz> findAll(){
		return farm_ycjk_xtrzMapper.findAll();
	}
	public Farm_ycjk_xtrz loginIn(Farm_ycjk_xtrz test){
		return farm_ycjk_xtrzMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_xtrz> getFarm_ycjk_xtrz(Farm_ycjk_xtrz test){
		return farm_ycjk_xtrzMapper.getFarm_ycjk_xtrz(test);
	}
	
	public boolean addFarm_ycjk_xtrz(Farm_ycjk_xtrz test) {
		boolean flag = false;
		int result = farm_ycjk_xtrzMapper.addFarm_ycjk_xtrz(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_xtrz(Farm_ycjk_xtrz test) {
		boolean flag = false;
		int result = farm_ycjk_xtrzMapper.updateFarm_ycjk_xtrz(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_xtrz(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_xtrzMapper.deleteFarm_ycjk_xtrz(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_xtrz getOneFarm_ycjk_xtrz(Integer id) {
		return farm_ycjk_xtrzMapper.getOneFarm_ycjk_xtrz(id);
	}

}
