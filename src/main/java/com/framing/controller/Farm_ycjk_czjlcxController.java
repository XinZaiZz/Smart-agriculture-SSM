package com.framing.controller;

import com.framing.pojo.Farm_ycjk_czjlcx;
import com.framing.service.Farm_ycjk_czjlcxService;
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
@RequestMapping(value="/farm_ycjk_czjlcx")
public class Farm_ycjk_czjlcxController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_czjlcxController.class);
	@Autowired
	Farm_ycjk_czjlcxService farm_ycjk_czjlcxService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_czjlcx> farm_ycjk_czjlcxList = farm_ycjk_czjlcxService.findAll();
		modelAndView.addObject("czjlcx_list",farm_ycjk_czjlcxList);
		modelAndView.setViewName("farm_ycjk_czjlcx/czjlcx");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_czjlcx find(Farm_ycjk_czjlcx farm_ycjk_czjlcx){
		logger.debug("getFarm_ycjk_czjlcx begin ====");
		try {
			farm_ycjk_czjlcx.setRows(farm_ycjk_czjlcxService.getFarm_ycjk_czjlcx(farm_ycjk_czjlcx));
			farm_ycjk_czjlcx.setSuccess(true);
			farm_ycjk_czjlcx.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_czjlcx.setSuccess(false);
			farm_ycjk_czjlcx.setMessage("查询失败！");
			logger.error("getFarm_ycjk_czjlcx error ",e);
		}
		return farm_ycjk_czjlcx;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_czjlcx getOne(Farm_ycjk_czjlcx farm_ycjk_czjlcx){
		logger.debug("getOneFarm_ycjk_czjlcx begin param ===>id={}",farm_ycjk_czjlcx.getSid());
		
		try {
			farm_ycjk_czjlcx=farm_ycjk_czjlcxService.getOneFarm_ycjk_czjlcx(farm_ycjk_czjlcx.getSid());
			farm_ycjk_czjlcx.setSuccess(true);
			farm_ycjk_czjlcx.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_czjlcx.setSuccess(false);
			farm_ycjk_czjlcx.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_czjlcx error ",e);
		}
		return farm_ycjk_czjlcx;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_czjlcx save(Farm_ycjk_czjlcx farm_ycjk_czjlcx){
		try {
			boolean flag=false;
			if(farm_ycjk_czjlcx.getSid()!=null){
				farm_ycjk_czjlcx.setLastUpdatedBy("admin");
				farm_ycjk_czjlcx.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_czjlcxService.updateFarm_ycjk_czjlcx(farm_ycjk_czjlcx);
				farm_ycjk_czjlcx.setSuccess(flag);
				farm_ycjk_czjlcx.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_czjlcx.setCreatedBy("admin");
				farm_ycjk_czjlcx.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_czjlcxService.addFarm_ycjk_czjlcx(farm_ycjk_czjlcx);
				farm_ycjk_czjlcx.setSuccess(flag);
				farm_ycjk_czjlcx.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_czjlcx.setSuccess(false);
			farm_ycjk_czjlcx.setMessage("保存失败！");
			logger.error("addFarm_ycjk_czjlcx error ",e);
		}
		return farm_ycjk_czjlcx;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_czjlcx delete(@RequestBody ArrayList<Farm_ycjk_czjlcx> userList){
		logger.debug("getFarm_ycjk_czjlcx begin ====");
		Farm_ycjk_czjlcx farm_ycjk_czjlcx = new Farm_ycjk_czjlcx(); 
		try {
			for(Farm_ycjk_czjlcx user:userList){
				farm_ycjk_czjlcxService.deleteFarm_ycjk_czjlcx(user.getSid());
			}
			farm_ycjk_czjlcx.setSuccess(true);
			farm_ycjk_czjlcx.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_czjlcx.setSuccess(false);
			farm_ycjk_czjlcx.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_czjlcx error ",e);
		}
		return farm_ycjk_czjlcx;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_czjlcx updateDataState(Farm_ycjk_czjlcx farm_ycjk_czjlcx){
		logger.debug("getFarm_ycjk_czjlcx begin ====");
		try {
			boolean flag=false;
			farm_ycjk_czjlcx.setLastUpdatedBy("admin");
			farm_ycjk_czjlcx.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_czjlcxService.updateFarm_ycjk_czjlcx(farm_ycjk_czjlcx);
			farm_ycjk_czjlcx.setSuccess(flag);
			farm_ycjk_czjlcx.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_czjlcx.setSuccess(false);
			farm_ycjk_czjlcx.setMessage("查询失败！");
			logger.error("getFarm_ycjk_czjlcx error ",e);
		}
		return farm_ycjk_czjlcx;
	}
}
