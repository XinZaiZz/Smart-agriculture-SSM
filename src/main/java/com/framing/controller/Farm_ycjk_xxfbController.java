package com.framing.controller;

import com.framing.pojo.Farm_ycjk_xxfb;
import com.framing.service.Farm_ycjk_xxfbService;
import com.framing.support.DateSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author youxin
 *
 */
@RestController
@RequestMapping(value="/farm_ycjk_xxfb")
public class Farm_ycjk_xxfbController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_xxfbController.class);
	@Autowired
	Farm_ycjk_xxfbService farm_ycjk_xxfbService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_xxfb> farm_ycjk_xxfbList = farm_ycjk_xxfbService.findAll();
		modelAndView.addObject("xxfb_list",farm_ycjk_xxfbList);
		modelAndView.setViewName("farm_ycjk_xxfb/xxfb");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_xxfb find(Farm_ycjk_xxfb farm_ycjk_xxfb){
		logger.debug("getFarm_ycjk_xxfb begin ====");
		try {
			farm_ycjk_xxfb.setRows(farm_ycjk_xxfbService.getFarm_ycjk_xxfb(farm_ycjk_xxfb));
			farm_ycjk_xxfb.setSuccess(true);
			farm_ycjk_xxfb.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_xxfb.setSuccess(false);
			farm_ycjk_xxfb.setMessage("查询失败！");
			logger.error("getFarm_ycjk_xxfb error ",e);
		}
		return farm_ycjk_xxfb;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_xxfb getOne(Farm_ycjk_xxfb farm_ycjk_xxfb){
		logger.debug("getOneFarm_ycjk_xxfb begin param ===>id={}",farm_ycjk_xxfb.getSid());
		
		try {
			farm_ycjk_xxfb=farm_ycjk_xxfbService.getOneFarm_ycjk_xxfb(farm_ycjk_xxfb.getSid());
//			System.out.println(farm_ycjk_xxfb.getXxnr());
			farm_ycjk_xxfb.setSuccess(true);
			farm_ycjk_xxfb.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_xxfb.setSuccess(false);
			farm_ycjk_xxfb.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_xxfb error ",e);
		}
		return farm_ycjk_xxfb;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_xxfb save(Farm_ycjk_xxfb farm_ycjk_xxfb){

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		farm_ycjk_xxfb.setBcsj(simpleDateFormat.format(date));
		try {
			boolean flag=false;
			if(farm_ycjk_xxfb.getSid()!=null){
				farm_ycjk_xxfb.setLastUpdatedBy("admin");
				farm_ycjk_xxfb.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_xxfbService.updateFarm_ycjk_xxfb(farm_ycjk_xxfb);
				farm_ycjk_xxfb.setSuccess(flag);
				farm_ycjk_xxfb.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_xxfb.setCreatedBy("admin");
				farm_ycjk_xxfb.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_xxfbService.addFarm_ycjk_xxfb(farm_ycjk_xxfb);
				farm_ycjk_xxfb.setSuccess(flag);
				farm_ycjk_xxfb.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_xxfb.setSuccess(false);
			farm_ycjk_xxfb.setMessage("保存失败！");
			logger.error("addFarm_ycjk_xxfb error ",e);
		}
		return farm_ycjk_xxfb;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_xxfb delete(@RequestBody ArrayList<Farm_ycjk_xxfb> userList){
		logger.debug("getFarm_ycjk_xxfb begin ====");
		Farm_ycjk_xxfb farm_ycjk_xxfb = new Farm_ycjk_xxfb(); 
		try {
			for(Farm_ycjk_xxfb user:userList){
				farm_ycjk_xxfbService.deleteFarm_ycjk_xxfb(user.getSid());
			}
			farm_ycjk_xxfb.setSuccess(true);
			farm_ycjk_xxfb.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_xxfb.setSuccess(false);
			farm_ycjk_xxfb.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_xxfb error ",e);
		}
		return farm_ycjk_xxfb;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_xxfb updateDataState(Farm_ycjk_xxfb farm_ycjk_xxfb){
		logger.debug("getFarm_ycjk_xxfb begin ====");
		try {
			boolean flag=false;
			farm_ycjk_xxfb.setLastUpdatedBy("admin");
			farm_ycjk_xxfb.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_xxfbService.updateFarm_ycjk_xxfb(farm_ycjk_xxfb);
			farm_ycjk_xxfb.setSuccess(flag);
			farm_ycjk_xxfb.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_xxfb.setSuccess(false);
			farm_ycjk_xxfb.setMessage("查询失败！");
			logger.error("getFarm_ycjk_xxfb error ",e);
		}
		return farm_ycjk_xxfb;
	}
}
