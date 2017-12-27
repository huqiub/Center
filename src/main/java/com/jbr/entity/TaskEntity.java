package com.jbr.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private long deviceId;
	private int operation;
	private int scriptId;
	private String downloadUrl;
	private int status;
	private String ip;

	private Date createTime;
	private Date validTime;
	private Date invalidTime;
	private Date executeTime;
	private Date resultTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getScriptId() {
		return scriptId;
	}

	public void setScriptId(int scriptId) {
		this.scriptId = scriptId;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public Date getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}

	public Date getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public Date getResultTime() {
		return resultTime;
	}

	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
	}

}
