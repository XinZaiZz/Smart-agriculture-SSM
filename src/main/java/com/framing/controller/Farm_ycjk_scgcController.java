package com.framing.controller;

import com.framing.pojo.Farm_ycjk_scgc;
import com.framing.pojo.Farm_ycjk_xtrz;
import com.framing.pojo.UserInfo;
import com.framing.service.Farm_ycjk_scgcService;
import com.framing.service.Farm_ycjk_xtrzService;
import com.framing.support.DateSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping(value="/farm_ycjk_scgc")
public class Farm_ycjk_scgcController {
	Logger logger = LoggerFactory.getLogger(Farm_ycjk_scgcController.class);
	@Autowired
	Farm_ycjk_scgcService farm_ycjk_scgcService;
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
		List<Farm_ycjk_scgc> farm_ycjk_scgcList = farm_ycjk_scgcService.findAll();
		modelAndView.addObject("scgc_list",farm_ycjk_scgcList);
		modelAndView.setViewName("farm_ycjk_scgcgz/scgcgz");
		return modelAndView;
	}
	
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Farm_ycjk_scgc find(Farm_ycjk_scgc farm_ycjk_scgc){
		logger.debug("getFarm_ycjk_scgc begin ====");
		try {
			farm_ycjk_scgc.setRows(farm_ycjk_scgcService.getFarm_ycjk_scgc(farm_ycjk_scgc));
			farm_ycjk_scgc.setSuccess(true);
			farm_ycjk_scgc.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_scgc.setSuccess(false);
			farm_ycjk_scgc.setMessage("查询失败！");
			logger.error("getFarm_ycjk_scgc error ",e);
		}
		return farm_ycjk_scgc;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Farm_ycjk_scgc getOne(Farm_ycjk_scgc farm_ycjk_scgc){
		logger.debug("getOneFarm_ycjk_scgc begin param ===>id={}",farm_ycjk_scgc.getSid());
		
		try {
			farm_ycjk_scgc=farm_ycjk_scgcService.getOneFarm_ycjk_scgc(farm_ycjk_scgc.getSid());
			farm_ycjk_scgc.setSuccess(true);
			farm_ycjk_scgc.setMessage("查询成功！");
		}catch(Exception e) {
			farm_ycjk_scgc.setSuccess(false);
			farm_ycjk_scgc.setMessage("查询失败！");
			logger.error("getOneFarm_ycjk_scgc error ",e);
		}
		return farm_ycjk_scgc;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Farm_ycjk_scgc save(Farm_ycjk_scgc farm_ycjk_scgc, HttpServletRequest req){
		Date date = new Date();
		Farm_ycjk_xtrz farm_ycjk_xtrz = new Farm_ycjk_xtrz();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		farm_ycjk_scgc.setCzsj(simpleDateFormat.format(date));
		farm_ycjk_xtrz.setJlsj(simpleDateFormat.format(date));
		UserInfo userInfo = (UserInfo) req.getSession().getAttribute("user");
		if (userInfo != null) {
			farm_ycjk_scgc.setCzry(userInfo.getName());
		}else {
			farm_ycjk_scgc.setCzry("游客");
		}
		try {
			boolean flag=false;
			if(farm_ycjk_scgc.getSid()!=null){
				farm_ycjk_scgc.setLastUpdatedBy("admin");
				farm_ycjk_scgc.setLastUpdated(dateSupport.getSystemDate());
				farm_ycjk_xtrz.setRzlx("修改");
				farm_ycjk_xtrz.setRznr("修改生产过程描述为："+farm_ycjk_scgc.getScgcms()+",备注信息为："+farm_ycjk_scgc.getBzxx());
				if (userInfo != null){
					farm_ycjk_xtrz.setCzry(userInfo.getName());
				}else {
					farm_ycjk_xtrz.setCzry("游客");
				}
				farm_ycjk_xtrzService.addFarm_ycjk_xtrz(farm_ycjk_xtrz);
				flag = farm_ycjk_scgcService.updateFarm_ycjk_scgc(farm_ycjk_scgc);
				farm_ycjk_scgc.setSuccess(flag);
				farm_ycjk_scgc.setMessage(flag?"修改成功":"修改失败");
			}else {
				farm_ycjk_scgc.setCreatedBy("admin");
				farm_ycjk_scgc.setCreated(dateSupport.getSystemDate());
				farm_ycjk_xtrz.setRzlx("新增");
				farm_ycjk_xtrz.setRznr("新增生产过程描述为："+farm_ycjk_scgc.getScgcms()+",备注信息为："+farm_ycjk_scgc.getBzxx());
				if (userInfo != null){
					farm_ycjk_xtrz.setCzry(userInfo.getName());
				}else {
					farm_ycjk_xtrz.setCzry("游客");
				}
				farm_ycjk_xtrzService.addFarm_ycjk_xtrz(farm_ycjk_xtrz);
				flag = farm_ycjk_scgcService.addFarm_ycjk_scgc(farm_ycjk_scgc);
				farm_ycjk_scgc.setSuccess(flag);
				farm_ycjk_scgc.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			farm_ycjk_scgc.setSuccess(false);
			farm_ycjk_scgc.setMessage("保存失败！");
			logger.error("addFarm_ycjk_scgc error ",e);
		}
		return farm_ycjk_scgc;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Farm_ycjk_scgc delete(@RequestBody ArrayList<Farm_ycjk_scgc> userList,HttpServletRequest req){
		Date date = new Date();
		Farm_ycjk_xtrz farm_ycjk_xtrz = new Farm_ycjk_xtrz();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		farm_ycjk_xtrz.setJlsj(simpleDateFormat.format(date));
		UserInfo userInfo = (UserInfo) req.getSession().getAttribute("user");
		if (userInfo != null) {
			farm_ycjk_xtrz.setCzry(userInfo.getName());
		}else {
			farm_ycjk_xtrz.setCzry("游客");
		}
		logger.debug("getFarm_ycjk_scgc begin ====");
		Farm_ycjk_scgc farm_ycjk_scgc = new Farm_ycjk_scgc(); 
		try {
			for(Farm_ycjk_scgc user:userList){
				Farm_ycjk_scgc farm_ycjk_scgc1 = farm_ycjk_scgcService.getOneFarm_ycjk_scgc(user.getSid());
				farm_ycjk_xtrz.setRzlx("删除");
				farm_ycjk_xtrz.setRznr("删除的生产过程描述为："+farm_ycjk_scgc1.getScgcms()+",备注信息为："+farm_ycjk_scgc1.getBzxx());
				farm_ycjk_xtrzService.addFarm_ycjk_xtrz(farm_ycjk_xtrz);
				farm_ycjk_scgcService.deleteFarm_ycjk_scgc(user.getSid());
			}
			farm_ycjk_scgc.setSuccess(true);
			farm_ycjk_scgc.setMessage("删除成功！");
		}catch(Exception e) {
			farm_ycjk_scgc.setSuccess(false);
			farm_ycjk_scgc.setMessage("删除失败！");
			logger.error("deleteFarm_ycjk_scgc error ",e);
		}
		return farm_ycjk_scgc;
	}

	/**
	 * 更新方法
	 */
	@ResponseBody
	@RequestMapping(value="/updateDataState", method = RequestMethod.POST)
	public Farm_ycjk_scgc updateDataState(Farm_ycjk_scgc farm_ycjk_scgc){
		logger.debug("getFarm_ycjk_scgc begin ====");
		try {
			boolean flag=false;
			farm_ycjk_scgc.setLastUpdatedBy("admin");
			farm_ycjk_scgc.setLastUpdated(dateSupport.getSystemDate());
			flag = farm_ycjk_scgcService.updateFarm_ycjk_scgc(farm_ycjk_scgc);
			farm_ycjk_scgc.setSuccess(flag);
			farm_ycjk_scgc.setMessage(flag?"修改成功":"修改失败");
		}catch(Exception e) {
			farm_ycjk_scgc.setSuccess(false);
			farm_ycjk_scgc.setMessage("查询失败！");
			logger.error("getFarm_ycjk_scgc error ",e);
		}
		return farm_ycjk_scgc;
	}
}
