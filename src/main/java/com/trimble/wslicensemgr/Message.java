package com.trimble.wslicensemgr;

public class Message {
	
	private long id;
	private String app, level, message;
	
	public Message(long id, String app, String level, String message) {
		this.app = app;
		this.level = level;
		this.message = message;
		this.setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApp() {
		return app;
	}

	public String getLevel() {
		return level.toUpperCase();
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return "[app: " + this.getApp() + ", level: " + this.getLevel() + ", message: " + this.getMessage() + "]";
	}
	
	public String toString4Log() {
		return "[app: " + this.getApp() +  ", message: " + this.getMessage() + "]";
	}

}
