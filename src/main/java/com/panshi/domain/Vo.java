package com.panshi.domain;

public class Vo {

	private int page;
	
	private int limit;
	
	private String title;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Vo [page=" + page + ", limit=" + limit + ", title=" + title + "]";
	}

}
