package com.framing.controller;

import com.framing.pojo.Farm_ycjk_yjclpz;
import com.framing.service.Farm_ycjk_yjclpzService;
import com.framing.support.DateSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author youxin
 *
 */
@RestController
@RequestMapping(value="/farm_ycjk_yjclpz")
public class Farm_ycjk_yjclpzController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_yjclpzController.class);
	@Autowired
	Farm_ycjk_yjclpzService farm_ycjk_yjclpzService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_yjclpz> farm_ycjk_yjclpzList = farm_ycjk_yjclpzService.findAll();
		modelAndView.addObject("yjclpz_list",farm_ycjk_yjclpzList);
		modelAndView.setViewName("farm_ycjk_yjclpz/yjclpz");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_yjclpz find(Farm_ycjk_yjclpz farm_ycjk_yjclpz){
		logger.debug("getFarm_ycjk_yjclpz begin ====");
		try {
			farm_ycjk_yjclpz.setRows(farm_ycjk_yjclpzService.getFarm_ycjk_yjclpz(farm_ycjk_yjclpz));
			farm_ycjk_yjclpz.setSuccess(true);
			farm_ycjk_yjclpz.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_yjclpz.setSuccess(false);
			farm_ycjk_yjclpz.setMessage("查询失败！");
			logger.error("getFarm_ycjk_yjclpz error ",e);
		}
		return farm_ycjk_yjclpz;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_yjclpz getOne(Farm_ycjk_yjclpz farm_ycjk_yjclpz){
		logger.debug("getOneFarm_ycjk_yjclpz begin param ===>id={}",farm_ycjk_yjclpz.getSid());
		
		try {
			farm_ycjk_yjclpz=farm_ycjk_yjclpzService.getOneFarm_ycjk_yjclpz(farm_ycjk_yjclpz.getSid());
			farm_ycjk_yjclpz.setSuccess(true);
			farm_ycjk_yjclpz.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_yjclpz.setSuccess(false);
			farm_ycjk_yjclpz.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_yjclpz error ",e);
		}
		return farm_ycjk_yjclpz;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_yjclpz save(Farm_ycjk_yjclpz farm_ycjk_yjclpz){
		try {
			boolean flag=false;
			if(farm_ycjk_yjclpz.getSid()!=null){
				farm_ycjk_yjclpz.setLastUpdatedBy("admin");
				farm_ycjk_yjclpz.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_yjclpzService.updateFarm_ycjk_yjclpz(farm_ycjk_yjclpz);
				farm_ycjk_yjclpz.setSuccess(flag);
				farm_ycjk_yjclpz.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_yjclpz.setCreatedBy("admin");
				farm_ycjk_yjclpz.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_yjclpzService.addFarm_ycjk_yjclpz(farm_ycjk_yjclpz);
				farm_ycjk_yjclpz.setSuccess(flag);
				farm_ycjk_yjclpz.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_yjclpz.setSuccess(false);
			farm_ycjk_yjclpz.setMessage("保存失败！");
			logger.error("addFarm_ycjk_yjclpz error ",e);
		}
		return farm_ycjk_yjclpz;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_yjclpz delete(@RequestBody ArrayList<Farm_ycjk_yjclpz> userList){
		logger.debug("getFarm_ycjk_yjclpz begin ====");
		Farm_ycjk_yjclpz farm_ycjk_yjclpz = new Farm_ycjk_yjclpz(); 
		try {
			for(Farm_ycjk_yjclpz user:userList){
				farm_ycjk_yjclpzService.deleteFarm_ycjk_yjclpz(user.getSid());
			}
			farm_ycjk_yjclpz.setSuccess(true);
			farm_ycjk_yjclpz.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_yjclpz.setSuccess(false);
			farm_ycjk_yjclpz.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_yjclpz error ",e);
		}
		return farm_ycjk_yjclpz;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_yjclpz updateDataState(Farm_ycjk_yjclpz farm_ycjk_yjclpz){
		logger.debug("getFarm_ycjk_yjclpz begin ====");
		try {
			boolean flag=false;
			farm_ycjk_yjclpz.setLastUpdatedBy("admin");
			farm_ycjk_yjclpz.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_yjclpzService.updateFarm_ycjk_yjclpz(farm_ycjk_yjclpz);
			farm_ycjk_yjclpz.setSuccess(flag);
			farm_ycjk_yjclpz.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_yjclpz.setSuccess(false);
			farm_ycjk_yjclpz.setMessage("查询失败！");
			logger.error("getFarm_ycjk_yjclpz error ",e);
		}
		return farm_ycjk_yjclpz;
	}
}
