package com.framing.controller;

import com.framing.pojo.Farm_ycjk_zwszls;
import com.framing.service.Farm_ycjk_zwszlsService;
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
@RequestMapping(value="/farm_ycjk_zwszls")
public class Farm_ycjk_zwszlsController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_zwszlsController.class);
	@Autowired
	Farm_ycjk_zwszlsService farm_ycjk_zwszlsService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_zwszls> farm_ycjk_zwszlsList = farm_ycjk_zwszlsService.findAll();
		modelAndView.addObject("zwszls_list",farm_ycjk_zwszlsList);
		modelAndView.setViewName("farm_ycjk_zwszls/zwszls");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_zwszls find(Farm_ycjk_zwszls farm_ycjk_zwszls){
		logger.debug("getFarm_ycjk_zwszls begin ====");
		try {
			farm_ycjk_zwszls.setRows(farm_ycjk_zwszlsService.getFarm_ycjk_zwszls(farm_ycjk_zwszls));
			farm_ycjk_zwszls.setSuccess(true);
			farm_ycjk_zwszls.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_zwszls.setSuccess(false);
			farm_ycjk_zwszls.setMessage("查询失败！");
			logger.error("getFarm_ycjk_zwszls error ",e);
		}
		return farm_ycjk_zwszls;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_zwszls getOne(Farm_ycjk_zwszls farm_ycjk_zwszls){
		logger.debug("getOneFarm_ycjk_zwszls begin param ===>id={}",farm_ycjk_zwszls.getSid());
		
		try {
			farm_ycjk_zwszls=farm_ycjk_zwszlsService.getOneFarm_ycjk_zwszls(farm_ycjk_zwszls.getSid());
			farm_ycjk_zwszls.setSuccess(true);
			farm_ycjk_zwszls.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_zwszls.setSuccess(false);
			farm_ycjk_zwszls.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_zwszls error ",e);
		}
		return farm_ycjk_zwszls;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_zwszls save(Farm_ycjk_zwszls farm_ycjk_zwszls){
		try {
			boolean flag=false;
			if(farm_ycjk_zwszls.getSid()!=null){
				farm_ycjk_zwszls.setLastUpdatedBy("admin");
				farm_ycjk_zwszls.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_zwszlsService.updateFarm_ycjk_zwszls(farm_ycjk_zwszls);
				farm_ycjk_zwszls.setSuccess(flag);
				farm_ycjk_zwszls.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_zwszls.setCreatedBy("admin");
				farm_ycjk_zwszls.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_zwszlsService.addFarm_ycjk_zwszls(farm_ycjk_zwszls);
				farm_ycjk_zwszls.setSuccess(flag);
				farm_ycjk_zwszls.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_zwszls.setSuccess(false);
			farm_ycjk_zwszls.setMessage("保存失败！");
			logger.error("addFarm_ycjk_zwszls error ",e);
		}
		return farm_ycjk_zwszls;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_zwszls delete(@RequestBody ArrayList<Farm_ycjk_zwszls> userList){
		logger.debug("getFarm_ycjk_zwszls begin ====");
		Farm_ycjk_zwszls farm_ycjk_zwszls = new Farm_ycjk_zwszls(); 
		try {
			for(Farm_ycjk_zwszls user:userList){
				farm_ycjk_zwszlsService.deleteFarm_ycjk_zwszls(user.getSid());
			}
			farm_ycjk_zwszls.setSuccess(true);
			farm_ycjk_zwszls.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_zwszls.setSuccess(false);
			farm_ycjk_zwszls.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_zwszls error ",e);
		}
		return farm_ycjk_zwszls;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_zwszls updateDataState(Farm_ycjk_zwszls farm_ycjk_zwszls){
		logger.debug("getFarm_ycjk_zwszls begin ====");
		try {
			boolean flag=false;
			farm_ycjk_zwszls.setLastUpdatedBy("admin");
			farm_ycjk_zwszls.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_zwszlsService.updateFarm_ycjk_zwszls(farm_ycjk_zwszls);
			farm_ycjk_zwszls.setSuccess(flag);
			farm_ycjk_zwszls.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_zwszls.setSuccess(false);
			farm_ycjk_zwszls.setMessage("查询失败！");
			logger.error("getFarm_ycjk_zwszls error ",e);
		}
		return farm_ycjk_zwszls;
	}
}
