package com.jbr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jbr.constant.Constants;
import com.jbr.mapper.ScriptMapper;
import com.jbr.util.ScriptUtils;
import com.jbr.util.ServiceUtils;

@Component
public class InitScriptsRunner implements CommandLineRunner {

	@Autowired
	private ScriptMapper scriptMapper;

	@Value("${time.scale}")
	private String timeScale;

	@Value("${abtime.scale}")
	private String abtimeScale;

	@Value("${script.location}")
	private String scriptLocation;

	@Override
	public void run(String... arg0) throws Exception {
		ScriptUtils.loginIdList = scriptMapper.getIdList(Constants.OPERATION_LOGIN);
		ScriptUtils.otherIdList = scriptMapper.getIdList(Constants.OPERATION_OTHER);
		ServiceUtils.timeScale = timeScale;
		ServiceUtils.abtimeScale = abtimeScale;
		ScriptUtils.scriptLocation = scriptLocation;
	}

}
