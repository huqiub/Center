package com.jbr.domain;

import com.jbr.entity.DeviceEntity;

public class DeviceCondition extends DeviceEntity {

	private static final long serialVersionUID = -7746651818868693059L;

	private int page;
	private int rows;
	private int startRow;

	public int getStartRow() {
		startRow = (page - 1) * rows;
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
