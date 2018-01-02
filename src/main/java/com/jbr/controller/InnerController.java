package com.jbr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.jbr.constant.Constants;
import com.jbr.domain.DataGrid;
import com.jbr.domain.DeviceCondition;
import com.jbr.domain.Rule;
import com.jbr.domain.Task;
import com.jbr.domain.TaskCondition;
import com.jbr.domain.TreeModel;
import com.jbr.entity.DeviceEntity;
import com.jbr.service.CenterService;
import com.jbr.util.Utils;

@Controller
public class InnerController {
	private static Logger log = LoggerFactory.getLogger(InnerController.class);

	@Autowired
	private CenterService centerService;

	@RequestMapping(value = "/getTree/{user}")
	public void getTree(@PathVariable String user, HttpServletResponse response) {
		try {
			TreeModel tree = centerService.getTree(user);
			String strJson = JSON.toJSONString(tree);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("[" + strJson + "]");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	@RequestMapping(value = "/getDevice", method = RequestMethod.POST)
	@ResponseBody
	public String getDevice(@RequestParam int count, @RequestParam int bind) {
		String result = Constants.RESULT_SUCCESS;
		try {
			centerService.getDeviceAndSave(count, bind);
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/searchDevice")
	@ResponseBody
	public DataGrid<DeviceEntity> searchDevice(HttpServletRequest request, HttpServletResponse response) {

		DeviceCondition condition = new DeviceCondition();
		String bind = request.getParameter("bind");
		String valid = request.getParameter("valid");
		String createTime = request.getParameter("createTime");
		condition.setPage(Integer.parseInt(request.getParameter("page")));
		condition.setRows(Integer.parseInt(request.getParameter("rows")));
		if (!StringUtils.isEmpty(bind)) {
			condition.setBind(Integer.parseInt(bind));
		}
		if (!StringUtils.isEmpty(valid)) {
			condition.setValid(Integer.parseInt(valid));
		}

		if (!StringUtils.isEmpty(createTime)) {
			condition.setCreateTime(Utils.stringToDate(createTime, "MM/dd/yyyy HH:mm:ss"));
		}
		List<DeviceEntity> list = centerService.searchDevice(condition);
		int count = centerService.searchDeviceCount(condition);
		DataGrid<DeviceEntity> dataGrid = new DataGrid<DeviceEntity>();
		dataGrid.setRows(list);
		dataGrid.setTotal(count);
		return dataGrid;
	}

	@RequestMapping(value = "/saveTemp", method = RequestMethod.POST)
	@ResponseBody
	public String saveTemp(Rule rule) {
		String result = Constants.RESULT_SUCCESS;
		try {
			if (rule.getR000() != null) {
				centerService.insertOrUpdateRule(rule);
			}
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/compute", method = RequestMethod.POST)
	@ResponseBody
	public Rule compute(Rule rule) {
		try {
			centerService.compute(rule);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return rule;
	}

	@RequestMapping(value = "/loadTemp/{month}/{channel}", method = RequestMethod.GET)
	@ResponseBody
	public Rule loadTemp(@PathVariable String month, @PathVariable String channel) {
		Rule rule = null;
		try {
			rule = centerService.loadRule(month, channel);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return rule;
	}

	@RequestMapping(value = "/distributeTask", method = RequestMethod.POST)
	@ResponseBody
	public String distributeTask(Rule rule) {
		String result = Constants.RESULT_SUCCESS;
		try {
			if (rule.getR000() != null) {
				centerService.distributeTask(rule);
			}
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/getTask", method = RequestMethod.POST)
	@ResponseBody
	public DataGrid<Task> getTask(HttpServletRequest request, HttpServletResponse response) {

		TaskCondition condition = new TaskCondition();
		String status = request.getParameter("status");
		String validTime = request.getParameter("validTime");
		String invalidTime = request.getParameter("invalidTime");
		condition.setPage(Integer.parseInt(request.getParameter("page")));
		condition.setRows(Integer.parseInt(request.getParameter("rows")));
		if (!StringUtils.isEmpty(status)) {
			condition.setStatus(Integer.parseInt(status));
		}

		if (!StringUtils.isEmpty(validTime)) {
			condition.setValidTime(Utils.stringToDate(validTime, "MM/dd/yyyy HH:mm:ss"));
		}
		if (!StringUtils.isEmpty(invalidTime)) {
			condition.setInvalidTime(Utils.stringToDate(invalidTime, "MM/dd/yyyy HH:mm:ss"));
		}
		List<Task> taskList = centerService.searchTasks(condition);
		int count = centerService.searchTasksCount(condition);
		DataGrid<Task> dataGrid = new DataGrid<Task>();
		dataGrid.setRows(taskList);
		dataGrid.setTotal(count);
		return dataGrid;
	}

	@RequestMapping(value = "/generateScript", method = RequestMethod.GET)
	@ResponseBody
	public String generateScript() {
		String result = Constants.RESULT_SUCCESS;
		try {
			centerService.generateScript();
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/pushScript", method = RequestMethod.GET)
	@ResponseBody
	public String pushScript() {
		String result = Constants.RESULT_SUCCESS;
		try {
			centerService.pushScript();
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/pullScript", method = RequestMethod.GET)
	@ResponseBody
	public String pullScript() {
		String result = Constants.RESULT_SUCCESS;
		try {
			centerService.pullScript();
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/truncateTask", method = RequestMethod.GET)
	@ResponseBody
	public String truncateTask() {

		String result = Constants.RESULT_SUCCESS;
		try {
			centerService.truncateTask();
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/initCount", method = RequestMethod.GET)
	@ResponseBody
	public String initCount() {
		String result = Constants.RESULT_SUCCESS;
		try {
			centerService.initCount();
		} catch (Exception e) {
			result = e.getMessage();
			log.error(e.getMessage());
		}
		return result;
	}
}
