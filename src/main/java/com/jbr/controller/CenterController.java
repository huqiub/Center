package com.jbr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbr.entity.TaskEntity;
import com.jbr.service.CenterService;
import com.jbr.util.Utils;

@Controller
public class CenterController {

	@Autowired
	private CenterService centerService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/getDevice", method = RequestMethod.POST)
	public void getDevice(@RequestParam int count, @RequestParam int band) {
		centerService.getDeviceAndSave(count, band);
	}

	@ResponseBody
	@RequestMapping(value = "/task/get", method = RequestMethod.GET)
	public String getTask() {
		TaskEntity task = centerService.getTask();
		if (task != null) {
			return task.getId() + "|" + task.getDeviceId() + "|" + task.getOperation() + "|" + task.getDownloadUrl();
		}
		return "";
	}

	@ResponseBody
	@RequestMapping(value = "/task/result", method = RequestMethod.GET)
	public int executeResult(HttpServletRequest request, @RequestParam("id") String taskId,
			@RequestParam("code") int result) {
		int msg = centerService.updateExecuteResult(taskId, result, Utils.getIpAddr(request));
		return msg;
	}

}
