package com.framing.controller;

import com.framing.pojo.Farm_ycjk_sbgl;
import com.framing.service.Farm_ycjk_sbglService;
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
@RequestMapping(value="/farm_ycjk_sbgl")
public class Farm_ycjk_sbglController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_sbglController.class);
	@Autowired
	Farm_ycjk_sbglService farm_ycjk_sbglService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_sbgl> farm_ycjk_sbglList = farm_ycjk_sbglService.findAll();
		modelAndView.addObject("sbgl_list",farm_ycjk_sbglList);
		modelAndView.setViewName("farm_ycjk_sbgl/sbgl");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_sbgl find(Farm_ycjk_sbgl farm_ycjk_sbgl){
		logger.debug("getFarm_ycjk_sbgl begin ====");
		try {
			farm_ycjk_sbgl.setRows(farm_ycjk_sbglService.getFarm_ycjk_sbgl(farm_ycjk_sbgl));
			farm_ycjk_sbgl.setSuccess(true);
			farm_ycjk_sbgl.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_sbgl.setSuccess(false);
			farm_ycjk_sbgl.setMessage("查询失败！");
			logger.error("getFarm_ycjk_sbgl error ",e);
		}
		return farm_ycjk_sbgl;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_sbgl getOne(Farm_ycjk_sbgl farm_ycjk_sbgl){
		logger.debug("getOneFarm_ycjk_sbgl begin param ===>id={}",farm_ycjk_sbgl.getSid());
		
		try {
			farm_ycjk_sbgl=farm_ycjk_sbglService.getOneFarm_ycjk_sbgl(farm_ycjk_sbgl.getSid());
			farm_ycjk_sbgl.setSuccess(true);
			farm_ycjk_sbgl.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_sbgl.setSuccess(false);
			farm_ycjk_sbgl.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_sbgl error ",e);
		}
		return farm_ycjk_sbgl;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_sbgl save(Farm_ycjk_sbgl farm_ycjk_sbgl){
		try {
			boolean flag=false;
			if(farm_ycjk_sbgl.getSid()!=null){
				farm_ycjk_sbgl.setLastUpdatedBy("admin");
				farm_ycjk_sbgl.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_sbglService.updateFarm_ycjk_sbgl(farm_ycjk_sbgl);
				farm_ycjk_sbgl.setSuccess(flag);
				farm_ycjk_sbgl.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_sbgl.setCreatedBy("admin");
				farm_ycjk_sbgl.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_sbglService.addFarm_ycjk_sbgl(farm_ycjk_sbgl);
				farm_ycjk_sbgl.setSuccess(flag);
				farm_ycjk_sbgl.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_sbgl.setSuccess(false);
			farm_ycjk_sbgl.setMessage("保存失败！");
			logger.error("addFarm_ycjk_sbgl error ",e);
		}
		return farm_ycjk_sbgl;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_sbgl delete(@RequestBody ArrayList<Farm_ycjk_sbgl> userList){
		logger.debug("getFarm_ycjk_sbgl begin ====");
		Farm_ycjk_sbgl farm_ycjk_sbgl = new Farm_ycjk_sbgl(); 
		try {
			for(Farm_ycjk_sbgl user:userList){
				farm_ycjk_sbglService.deleteFarm_ycjk_sbgl(user.getSid());
			}
			farm_ycjk_sbgl.setSuccess(true);
			farm_ycjk_sbgl.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_sbgl.setSuccess(false);
			farm_ycjk_sbgl.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_sbgl error ",e);
		}
		return farm_ycjk_sbgl;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_sbgl updateDataState(Farm_ycjk_sbgl farm_ycjk_sbgl){
		logger.debug("getFarm_ycjk_sbgl begin ====");
		try {
			boolean flag=false;
			farm_ycjk_sbgl.setLastUpdatedBy("admin");
			farm_ycjk_sbgl.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_sbglService.updateFarm_ycjk_sbgl(farm_ycjk_sbgl);
			farm_ycjk_sbgl.setSuccess(flag);
			farm_ycjk_sbgl.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_sbgl.setSuccess(false);
			farm_ycjk_sbgl.setMessage("查询失败！");
			logger.error("getFarm_ycjk_sbgl error ",e);
		}
		return farm_ycjk_sbgl;
	}
}
