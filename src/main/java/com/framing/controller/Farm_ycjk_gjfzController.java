package com.framing.controller;

import com.framing.pojo.Farm_ycjk_gjfz;
import com.framing.service.Farm_ycjk_gjfzService;
import com.framing.support.DateSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * 
 * @author czl
 *
 */
@RestController
@RequestMapping(value="/farm_ycjk_gjfz")
public class Farm_ycjk_gjfzController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_gjfzController.class);
	@Autowired
	Farm_ycjk_gjfzService farm_ycjk_gjfzService;
	@Autowired
	DateSupport dateSupport;
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_gjfz find(Farm_ycjk_gjfz farm_ycjk_gjfz){
		logger.debug("getFarm_ycjk_gjfz begin ====");
		try {
			farm_ycjk_gjfz.setRows(farm_ycjk_gjfzService.getFarm_ycjk_gjfz(farm_ycjk_gjfz));
			farm_ycjk_gjfz.setSuccess(true);
			farm_ycjk_gjfz.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_gjfz.setSuccess(false);
			farm_ycjk_gjfz.setMessage("查询失败！");
			logger.error("getFarm_ycjk_gjfz error ",e);
		}
		return farm_ycjk_gjfz;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_gjfz getOne(Farm_ycjk_gjfz farm_ycjk_gjfz){
		logger.debug("getOneFarm_ycjk_gjfz begin param ===>id={}",farm_ycjk_gjfz.getSid());
		
		try {
			farm_ycjk_gjfz=farm_ycjk_gjfzService.getOneFarm_ycjk_gjfz(farm_ycjk_gjfz.getSid());
			farm_ycjk_gjfz.setSuccess(true);
			farm_ycjk_gjfz.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_gjfz.setSuccess(false);
			farm_ycjk_gjfz.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_gjfz error ",e);
		}
		return farm_ycjk_gjfz;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_gjfz save(Farm_ycjk_gjfz farm_ycjk_gjfz){
		try {
			boolean flag=false;
			if(farm_ycjk_gjfz.getSid()!=null){
				farm_ycjk_gjfz.setLastUpdatedBy("admin");
				farm_ycjk_gjfz.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_gjfzService.updateFarm_ycjk_gjfz(farm_ycjk_gjfz);
				farm_ycjk_gjfz.setSuccess(flag);
				farm_ycjk_gjfz.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_gjfz.setCreatedBy("admin");
				farm_ycjk_gjfz.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_gjfzService.addFarm_ycjk_gjfz(farm_ycjk_gjfz);
				farm_ycjk_gjfz.setSuccess(flag);
				farm_ycjk_gjfz.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_gjfz.setSuccess(false);
			farm_ycjk_gjfz.setMessage("保存失败！");
			logger.error("addFarm_ycjk_gjfz error ",e);
		}
		return farm_ycjk_gjfz;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_gjfz delete(@RequestBody ArrayList<Farm_ycjk_gjfz> userList){
		logger.debug("getFarm_ycjk_gjfz begin ====");
		Farm_ycjk_gjfz farm_ycjk_gjfz = new Farm_ycjk_gjfz(); 
		try {
			for(Farm_ycjk_gjfz user:userList){
				farm_ycjk_gjfzService.deleteFarm_ycjk_gjfz(user.getSid());
			}
			farm_ycjk_gjfz.setSuccess(true);
			farm_ycjk_gjfz.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_gjfz.setSuccess(false);
			farm_ycjk_gjfz.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_gjfz error ",e);
		}
		return farm_ycjk_gjfz;
	}

	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_gjfz updateDataState(Farm_ycjk_gjfz farm_ycjk_gjfz){
		logger.debug("getFarm_ycjk_gjfz begin ====");
		try {
			boolean flag=false;
			farm_ycjk_gjfz.setLastUpdatedBy("admin");
			farm_ycjk_gjfz.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_gjfzService.updateFarm_ycjk_gjfz(farm_ycjk_gjfz);
			farm_ycjk_gjfz.setSuccess(flag);
			farm_ycjk_gjfz.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_gjfz.setSuccess(false);
			farm_ycjk_gjfz.setMessage("查询失败！");
			logger.error("getFarm_ycjk_gjfz error ",e);
		}
		return farm_ycjk_gjfz;
	}
}
