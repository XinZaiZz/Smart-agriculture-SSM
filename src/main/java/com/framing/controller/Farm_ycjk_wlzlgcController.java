package com.framing.controller;

import com.framing.pojo.Farm_ycjk_wlzlgc;
import com.framing.service.Farm_ycjk_wlzlgcService;
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
@RequestMapping(value="/farm_ycjk_wlzlgc")
public class Farm_ycjk_wlzlgcController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_wlzlgcController.class);
	@Autowired
	Farm_ycjk_wlzlgcService farm_ycjk_wlzlgcService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_wlzlgc> farm_ycjk_wlzlgcList = farm_ycjk_wlzlgcService.findAll();
		modelAndView.addObject("wlzlgc_list",farm_ycjk_wlzlgcList);
		modelAndView.setViewName("farm_ycjk_wlzlgc/wlzlgc");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_wlzlgc find(Farm_ycjk_wlzlgc farm_ycjk_wlzlgc){
		logger.debug("getFarm_ycjk_wlzlgc begin ====");
		try {
			farm_ycjk_wlzlgc.setRows(farm_ycjk_wlzlgcService.getFarm_ycjk_wlzlgc(farm_ycjk_wlzlgc));
			farm_ycjk_wlzlgc.setSuccess(true);
			farm_ycjk_wlzlgc.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_wlzlgc.setSuccess(false);
			farm_ycjk_wlzlgc.setMessage("查询失败！");
			logger.error("getFarm_ycjk_wlzlgc error ",e);
		}
		return farm_ycjk_wlzlgc;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_wlzlgc getOne(Farm_ycjk_wlzlgc farm_ycjk_wlzlgc){
		logger.debug("getOneFarm_ycjk_wlzlgc begin param ===>id={}",farm_ycjk_wlzlgc.getSid());
		
		try {
			farm_ycjk_wlzlgc=farm_ycjk_wlzlgcService.getOneFarm_ycjk_wlzlgc(farm_ycjk_wlzlgc.getSid());
			farm_ycjk_wlzlgc.setSuccess(true);
			farm_ycjk_wlzlgc.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_wlzlgc.setSuccess(false);
			farm_ycjk_wlzlgc.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_wlzlgc error ",e);
		}
		return farm_ycjk_wlzlgc;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_wlzlgc save(Farm_ycjk_wlzlgc farm_ycjk_wlzlgc){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		farm_ycjk_wlzlgc.setCzsj(simpleDateFormat.format(date));
		try {
			boolean flag=false;
			if(farm_ycjk_wlzlgc.getSid()!=null){
				farm_ycjk_wlzlgc.setLastUpdatedBy("admin");
				farm_ycjk_wlzlgc.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_wlzlgcService.updateFarm_ycjk_wlzlgc(farm_ycjk_wlzlgc);
				farm_ycjk_wlzlgc.setSuccess(flag);
				farm_ycjk_wlzlgc.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_wlzlgc.setCreatedBy("admin");
				farm_ycjk_wlzlgc.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_wlzlgcService.addFarm_ycjk_wlzlgc(farm_ycjk_wlzlgc);
				farm_ycjk_wlzlgc.setSuccess(flag);
				farm_ycjk_wlzlgc.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_wlzlgc.setSuccess(false);
			farm_ycjk_wlzlgc.setMessage("保存失败！");
			logger.error("addFarm_ycjk_wlzlgc error ",e);
		}
		return farm_ycjk_wlzlgc;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_wlzlgc delete(@RequestBody ArrayList<Farm_ycjk_wlzlgc> userList){
		logger.debug("getFarm_ycjk_wlzlgc begin ====");
		Farm_ycjk_wlzlgc farm_ycjk_wlzlgc = new Farm_ycjk_wlzlgc(); 
		try {
			for(Farm_ycjk_wlzlgc user:userList){
				farm_ycjk_wlzlgcService.deleteFarm_ycjk_wlzlgc(user.getSid());
			}
			farm_ycjk_wlzlgc.setSuccess(true);
			farm_ycjk_wlzlgc.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_wlzlgc.setSuccess(false);
			farm_ycjk_wlzlgc.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_wlzlgc error ",e);
		}
		return farm_ycjk_wlzlgc;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_wlzlgc updateDataState(Farm_ycjk_wlzlgc farm_ycjk_wlzlgc){
		logger.debug("getFarm_ycjk_wlzlgc begin ====");
		try {
			boolean flag=false;
			farm_ycjk_wlzlgc.setLastUpdatedBy("admin");
			farm_ycjk_wlzlgc.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_wlzlgcService.updateFarm_ycjk_wlzlgc(farm_ycjk_wlzlgc);
			farm_ycjk_wlzlgc.setSuccess(flag);
			farm_ycjk_wlzlgc.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_wlzlgc.setSuccess(false);
			farm_ycjk_wlzlgc.setMessage("查询失败！");
			logger.error("getFarm_ycjk_wlzlgc error ",e);
		}
		return farm_ycjk_wlzlgc;
	}
}
