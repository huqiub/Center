package com.jbr.domain;

import java.util.List;

public class TreeModel {

	private String text;
	List<Children> children;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

}
