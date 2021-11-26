package com.framing.controller;

import com.framing.pojo.Farm_ycjk_xtrz;
import com.framing.pojo.UserInfo;
import com.framing.service.Farm_ycjk_xtrzService;
import com.framing.support.DateSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value="/farm_ycjk_xtrz")
public class Farm_ycjk_xtrzController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_xtrzController.class);
	@Autowired
	Farm_ycjk_xtrzService farm_ycjk_xtrzService;
	@Autowired
	DateSupport dateSupport;


	/*
	* 查询所有
	* */
	@ResponseBody
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView();
		List<Farm_ycjk_xtrz> farm_ycjk_xtrzList = farm_ycjk_xtrzService.findAll();
		modelAndView.addObject("xtrz_list",farm_ycjk_xtrzList);
		modelAndView.setViewName("farm_ycjk_xtrz/xtrz");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_xtrz find(Farm_ycjk_xtrz farm_ycjk_xtrz){
		logger.debug("getFarm_ycjk_xtrz begin ====");
		try {
			farm_ycjk_xtrz.setRows(farm_ycjk_xtrzService.getFarm_ycjk_xtrz(farm_ycjk_xtrz));
			farm_ycjk_xtrz.setSuccess(true);
			farm_ycjk_xtrz.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_xtrz.setSuccess(false);
			farm_ycjk_xtrz.setMessage("查询失败！");
			logger.error("getFarm_ycjk_xtrz error ",e);
		}
		return farm_ycjk_xtrz;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_xtrz getOne(Farm_ycjk_xtrz farm_ycjk_xtrz){
		logger.debug("getOneFarm_ycjk_xtrz begin param ===>id={}",farm_ycjk_xtrz.getSid());
		
		try {
			farm_ycjk_xtrz=farm_ycjk_xtrzService.getOneFarm_ycjk_xtrz(farm_ycjk_xtrz.getSid());
			farm_ycjk_xtrz.setSuccess(true);
			farm_ycjk_xtrz.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_xtrz.setSuccess(false);
			farm_ycjk_xtrz.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_xtrz error ",e);
		}
		return farm_ycjk_xtrz;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_xtrz save(Farm_ycjk_xtrz farm_ycjk_xtrz, HttpServletRequest req){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		farm_ycjk_xtrz.setJlsj(simpleDateFormat.format(date));
		try {
			boolean flag=false;
			if(farm_ycjk_xtrz.getSid()!=null){
				farm_ycjk_xtrz.setLastUpdatedBy("admin");
				farm_ycjk_xtrz.setLastUpdated(dateSupport.getSystemDate());
				flag = farm_ycjk_xtrzService.updateFarm_ycjk_xtrz(farm_ycjk_xtrz);
				farm_ycjk_xtrz.setSuccess(flag);
				farm_ycjk_xtrz.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_xtrz.setCreatedBy("admin");
				farm_ycjk_xtrz.setCreated(dateSupport.getSystemDate());
				flag = farm_ycjk_xtrzService.addFarm_ycjk_xtrz(farm_ycjk_xtrz);
				farm_ycjk_xtrz.setSuccess(flag);
				farm_ycjk_xtrz.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_xtrz.setSuccess(false);
			farm_ycjk_xtrz.setMessage("保存失败！");
			logger.error("addFarm_ycjk_xtrz error ",e);
		}
		return farm_ycjk_xtrz;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_xtrz delete(@RequestBody ArrayList<Farm_ycjk_xtrz> userList){
		logger.debug("getFarm_ycjk_xtrz begin ====");
		Farm_ycjk_xtrz farm_ycjk_xtrz = new Farm_ycjk_xtrz(); 
		try {
			for(Farm_ycjk_xtrz user:userList){
				farm_ycjk_xtrzService.deleteFarm_ycjk_xtrz(user.getSid());
			}
			farm_ycjk_xtrz.setSuccess(true);
			farm_ycjk_xtrz.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_xtrz.setSuccess(false);
			farm_ycjk_xtrz.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_xtrz error ",e);
		}
		return farm_ycjk_xtrz;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_xtrz updateDataState(Farm_ycjk_xtrz farm_ycjk_xtrz){
		logger.debug("getFarm_ycjk_xtrz begin ====");
		try {
			boolean flag=false;
			farm_ycjk_xtrz.setLastUpdatedBy("admin");
			farm_ycjk_xtrz.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_xtrzService.updateFarm_ycjk_xtrz(farm_ycjk_xtrz);
			farm_ycjk_xtrz.setSuccess(flag);
			farm_ycjk_xtrz.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_xtrz.setSuccess(false);
			farm_ycjk_xtrz.setMessage("查询失败！");
			logger.error("getFarm_ycjk_xtrz error ",e);
		}
		return farm_ycjk_xtrz;
	}
}
