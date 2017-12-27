package com.jbr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbr.service.CenterService;

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
		// centerService.getDeviceAndSave(count, band);
	}

}
