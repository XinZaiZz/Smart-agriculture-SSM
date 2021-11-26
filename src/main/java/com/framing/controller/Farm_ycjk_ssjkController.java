package com.framing.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.framing.pojo.Farm_ycjk_ssjk;
import com.framing.service.Farm_ycjk_ssjkService;
import com.framing.support.DateSupport;

/**
 * 
 * @author czl
 *
 */
@RestController
@RequestMapping(value="/farm_ycjk_ssjk")
public class Farm_ycjk_ssjkController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_ssjkController.class);
	@Autowired
	Farm_ycjk_ssjkService farm_ycjk_ssjkService;
	@Autowired
	DateSupport dateSupport;
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_ssjk find(Farm_ycjk_ssjk farm_ycjk_ssjk){
		logger.debug("getFarm_ycjk_ssjk begin ====");
		try {
			farm_ycjk_ssjk.setRows(farm_ycjk_ssjkService.getFarm_ycjk_ssjk(farm_ycjk_ssjk));
			farm_ycjk_ssjk.setSuccess(true);
			farm_ycjk_ssjk.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_ssjk.setSuccess(false);
			farm_ycjk_ssjk.setMessage("查询失败！");
			logger.error("getFarm_ycjk_ssjk error ",e);
		}
		return farm_ycjk_ssjk;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_ssjk getOne(Farm_ycjk_ssjk farm_ycjk_ssjk){
		logger.debug("getOneFarm_ycjk_ssjk begin param ===>id={}",farm_ycjk_ssjk.getSid());
		
		try {
			farm_ycjk_ssjk=farm_ycjk_ssjkService.getOneFarm_ycjk_ssjk(farm_ycjk_ssjk.getSid());
			farm_ycjk_ssjk.setSuccess(true);
			farm_ycjk_ssjk.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_ssjk.setSuccess(false);
			farm_ycjk_ssjk.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_ssjk error ",e);
		}
		return farm_ycjk_ssjk;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_ssjk save(Farm_ycjk_ssjk farm_ycjk_ssjk){
		try {
			boolean flag=false;
			if(farm_ycjk_ssjk.getSid()!=null){
				farm_ycjk_ssjk.setLastUpdatedBy("admin");
				farm_ycjk_ssjk.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_ssjkService.updateFarm_ycjk_ssjk(farm_ycjk_ssjk);
				farm_ycjk_ssjk.setSuccess(flag);
				farm_ycjk_ssjk.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_ssjk.setCreatedBy("admin");
				farm_ycjk_ssjk.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_ssjkService.addFarm_ycjk_ssjk(farm_ycjk_ssjk);
				farm_ycjk_ssjk.setSuccess(flag);
				farm_ycjk_ssjk.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_ssjk.setSuccess(false);
			farm_ycjk_ssjk.setMessage("保存失败！");
			logger.error("addFarm_ycjk_ssjk error ",e);
		}
		return farm_ycjk_ssjk;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_ssjk delete(@RequestBody ArrayList<Farm_ycjk_ssjk> userList){
		logger.debug("getFarm_ycjk_ssjk begin ====");
		Farm_ycjk_ssjk farm_ycjk_ssjk = new Farm_ycjk_ssjk(); 
		try {
			for(Farm_ycjk_ssjk user:userList){
				farm_ycjk_ssjkService.deleteFarm_ycjk_ssjk(user.getSid());
			}
			farm_ycjk_ssjk.setSuccess(true);
			farm_ycjk_ssjk.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_ssjk.setSuccess(false);
			farm_ycjk_ssjk.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_ssjk error ",e);
		}
		return farm_ycjk_ssjk;
	}

	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_ssjk updateDataState(Farm_ycjk_ssjk farm_ycjk_ssjk){
		logger.debug("getFarm_ycjk_ssjk begin ====");
		try {
			boolean flag=false;
			farm_ycjk_ssjk.setLastUpdatedBy("admin");
			farm_ycjk_ssjk.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_ssjkService.updateFarm_ycjk_ssjk(farm_ycjk_ssjk);
			farm_ycjk_ssjk.setSuccess(flag);
			farm_ycjk_ssjk.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_ssjk.setSuccess(false);
			farm_ycjk_ssjk.setMessage("查询失败！");
			logger.error("getFarm_ycjk_ssjk error ",e);
		}
		return farm_ycjk_ssjk;
	}
}
