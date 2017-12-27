package com.jbr.domain;

import java.util.List;

public class DeviceResult {

	private int code;
	private String msg;

	private List<DeviceDomain> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<DeviceDomain> getData() {
		return data;
	}

	public void setData(List<DeviceDomain> data) {
		this.data = data;
	}

}
