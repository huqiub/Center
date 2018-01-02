package com.jbr.domain;

public class TaskCondition extends Task {

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
