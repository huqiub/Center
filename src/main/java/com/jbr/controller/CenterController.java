package com.jbr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbr.entity.TaskEntity;
import com.jbr.service.CenterService;
import com.jbr.util.Utils;

@Controller
public class CenterController {

	private static Logger log = LoggerFactory.getLogger(CenterController.class);

	@Autowired
	private CenterService centerService;

	@Value("${script.location}")
	private String scriptLocation;

	@Value("${script.name}")
	private String scriptName;

	// @RequestMapping("/")
	// public String test() {
	// return "index";
	// }

	@RequestMapping("/getDeviceIndex")
	public String getDeviceIndex() {
		return "getDevice";
	}

	@RequestMapping("/planIndex")
	public String planIndex() {
		return "plan";
	}

	@RequestMapping(value = "/getDevice", method = RequestMethod.POST)
	public void getDevice(@RequestParam int count, @RequestParam int band) {
		try {
			centerService.getDeviceAndSave(count, band);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/task/get", method = RequestMethod.GET)
	public String getTask() {
		try {
			TaskEntity task = centerService.getTask();
			if (task != null) {
				String result = task.getId() + "|" + task.getDeviceId() + "|" + task.getOperation() + "|"
						+ task.getDownloadUrl();
				log.info("获取到任务:" + result);
				return result;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "";
	}

	@ResponseBody
	@RequestMapping(value = "/task/result", method = RequestMethod.GET)
	public int executeResult(HttpServletRequest request, @RequestParam("id") String taskId,
			@RequestParam("code") int result) {
		try {
			log.info("收到任务返回结果:taskId=" + taskId + "，结果为：" + result);
			int msg = centerService.updateExecuteResult(taskId, result, Utils.getIpAddr(request));
			return msg;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return 0;
	}

	@RequestMapping(value = "/task/download/{id}", method = RequestMethod.GET)
	public void downloadScript(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

		String fullPath = scriptLocation + (id + "_" + scriptName);
		File downloadFile = new File(fullPath);

		ServletContext context = request.getServletContext();

		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", scriptName);
		response.setHeader(headerKey, headerValue);
		try {
			InputStream myStream = new FileInputStream(fullPath);
			IOUtils.copy(myStream, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			log.error("脚本下载失败：" + e.getMessage());
		}
	}
}
