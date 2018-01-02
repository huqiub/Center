package com.jbr.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer binding;

	private Date createTime;

	private Date firstLoginTime;

	private String channalId;

	private String imei;
	private String imsi;
	private String serailNo;
	private String phoneNo;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getSerailNo() {
		return serailNo;
	}

	public void setSerailNo(String serailNo) {
		this.serailNo = serailNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBinding() {
		return binding;
	}

	public void setBinding(Integer binding) {
		this.binding = binding;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getFirstLoginTime() {
		return firstLoginTime;
	}

	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	public String getChannalId() {
		return channalId;
	}

	public void setChannalId(String channalId) {
		this.channalId = channalId;
	}

}
