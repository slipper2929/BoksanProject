package org.boksan.model;

public class ReplyDTO {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReplyDTO [id=" + id + "]";
	}
}
