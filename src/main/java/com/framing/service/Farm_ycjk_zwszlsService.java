package com.framing.service;

import com.framing.mapper.Farm_ycjk_zwszlsMapper;
import com.framing.pojo.Farm_ycjk_zwszls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farm_ycjk_zwszlsService {
	@Autowired
	Farm_ycjk_zwszlsMapper farm_ycjk_zwszlsMapper;

	public List<Farm_ycjk_zwszls> findAll(){
		return farm_ycjk_zwszlsMapper.findAll();
	}
	public Farm_ycjk_zwszls loginIn(Farm_ycjk_zwszls test){
		return farm_ycjk_zwszlsMapper.loginIn(test);
	}
	
	public List<Farm_ycjk_zwszls> getFarm_ycjk_zwszls(Farm_ycjk_zwszls test){
		return farm_ycjk_zwszlsMapper.getFarm_ycjk_zwszls(test);
	}
	
	public boolean addFarm_ycjk_zwszls(Farm_ycjk_zwszls test) {
		boolean flag = false;
		int result = farm_ycjk_zwszlsMapper.addFarm_ycjk_zwszls(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateFarm_ycjk_zwszls(Farm_ycjk_zwszls test) {
		boolean flag = false;
		int result = farm_ycjk_zwszlsMapper.updateFarm_ycjk_zwszls(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteFarm_ycjk_zwszls(Integer id) {
		boolean flag = false;
		int result = farm_ycjk_zwszlsMapper.deleteFarm_ycjk_zwszls(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Farm_ycjk_zwszls getOneFarm_ycjk_zwszls(Integer id) {
		return farm_ycjk_zwszlsMapper.getOneFarm_ycjk_zwszls(id);
	}

}
