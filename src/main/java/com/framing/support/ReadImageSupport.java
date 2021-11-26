package com.framing.support;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 
 * <p>Title: CommonDataController</p>
 * <p>Description: 获取图片文件路径，复制图片到项目临时目录</p>
 * <p>Copyright: Copyright (c) 2015 gzzn  All right reserved.</p>
 * <p>Company: gzzn</p>
 * @author DengGuangjie
 * @version 1.0
 *
 * 修改记录:
 * 下面填写修改的内容以及修改的日期
 * 1.2016年7月1日 下午5:12:15  DengGuangjie    new
 */
@Service
public class ReadImageSupport{
	static Logger logger = LoggerFactory.getLogger(ReadImageSupport.class);
	

    @Autowired(required=false)
    private HttpServletRequest requset;
	
	/**
	 * 页面浏览图片的临时存放地址,在工程目录下
	 */
	@Value("${file.tempImg}")
	protected String tempImg;
	
	/**
	 * 获取WebRoot路径
	 * @return
	 */
	public String getWebRootPath() {
		return requset.getServletContext().getRealPath("/");
	}
	
	/**
	 * 获取页面显示图片路径
	 * @return
	 */
	public String getTempImgPath() {
		return getWebRootPath() + tempImg;
	}
	
	/**
	 * 获取系统模板文件路径
	 * @return
	 */
	public String getTemplatesPath() {
		return getWebRootPath()+"/templates/";
	}
	
	/**
	 * Description: 将页面要显示的图片从附件目录中复制到系统临时目录tempImg中<br>
	 * @param parentPath 附件物理存储主目录
	 * @param childPath 附件物理存储子目录
	 * @return
	 * @author lxq
	 * 2015年12月23日 下午8:12:25
	 */
	public String copyFileToTempImg(String parentPath, String childPath){
		 String fileTempPath = "";
		 if(childPath!=null && StringUtils.isNotEmpty(childPath)){
			 File srcfile = new File(parentPath +"/"+ childPath);
			 if(srcfile.isFile() && srcfile.exists()){//只有附件目录中实际存在的图片才显示
				 File destFile = new File(this.getTempImgPath() + childPath);
				 if(destFile.isFile() && destFile.exists()){
					 fileTempPath = tempImg +childPath;
				 }else{//如果临时文件夹中不存在该图片的话，需要复制图片至临时文件夹中
					 try {
						 FileUtils.copyFile(srcfile, destFile);
						 fileTempPath = tempImg +childPath;
					 } catch (IOException e) {
						 e.printStackTrace();
					 }
				 }
				 if(!"".equals(fileTempPath)){
					 fileTempPath = fileTempPath.replaceAll("\\\\", "\\/");
				 }
			 }
		 }
		 return fileTempPath;
	}
	
	/**
	 * 输出javascript提醒消息
	 * @param message
	 * @param response
	 */
	protected void sendScriptMessage(String message,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		String str = "<script type='text/javascript'>alert('" + message
				+ "');</script>";
		PrintWriter pw = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");

			pw = response.getWriter();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			logger.info("向前台输出javascript提醒消息出错！");
			//e.printStackTrace();
		}finally{
			if(pw!=null)
				pw.close();
		}
	}
	
	/*public static void main(String[] args) {
		//上传图片的时候就直接调用
		HttpServletRequest request;//request对象为controller方法的参数对象
		ReadImageSupport readImageSupport = new ReadImageSupport();
	
		try {
			//保存文件到本地盘符  -----------开始
				//获取页面传过来的文件,可以多个文件
				MultipartHttpServletRequest multipartfiles = (MultipartHttpServletRequest) request;
				MultipartFile file1 = multipartfiles.getFile("files1");
				//循环logo列表文件
				//因前台设置的accept=imgae/*不起作用，在后台需判断是否为图片
				BufferedImage bufferedImage = ImageIO.read(file1.getInputStream());
				if(bufferedImage != null){
					//获取图片的文件名  
					String fileName = file1.getOriginalFilename();
					//获取图片的扩展名  
					String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
					//新的图片名=获取时间戳+"."图片扩展名  
					String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
					//将图片上传到服务器  
					readImageSupport.saveFile(request, newFileName, file1);
				}
				//保存文件到本地盘符-------------------结束
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			
			//从本地盘符复制到临时目录---------------开始
			//获取本地tomcat的绝对路径，\\resources\\images\\temp\\为图片保存的临时目录 可自己配置
			String uri = request.getServletContext().getRealPath("\\resources\\images\\temp\\");
			
			if(!new File(uri + "图片的名字").isFile()){//检查临时目录文件是否存在
				//复制图片到临时目录
				readImageSupport.copyFileToTempImg("临时目录的地址","图片的名字") ;
				//从本地盘符复制到临时目录---------------结束
			}
	}*/
	

	private void saveFile(HttpServletRequest request, String newFileName, MultipartFile filedata) {
		//根据配置文件获取服务器图片存放路径    路径可以自己设置
		String saveFilePath = "D:/fileStore/entImg";
		//构建文件目录  
		File tempFile = new File(saveFilePath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		//保存文件到服务器  
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(saveFilePath + "/" + newFileName);
			fos.write(filedata.getBytes());
			//fos.flush();  
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
