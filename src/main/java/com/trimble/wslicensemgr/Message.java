package com.trimble.wslicensemgr;

public class Message {
	
	private long id;
	private String app, level, message;
	
	public Message(long id, String app, String level, String message) {
		this.app = app;
		this.level = level;
		this.message = message;
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public String getApp() throws NullPointerException {
		if (this.isBlank(app) || app == null) {
			throw new NullPointerException("Ivalid request: APP canot be NULL or 'empty'");
		}
		return app;
	}

	public String getLevel() throws NullPointerException {
		if (this.isBlank(level) || level == null ) {
			throw new NullPointerException("Ivalid request: LEVEL canot be NULL or 'empty'");
		}
		return level.toUpperCase();
	}

	public String getMessage() throws NullPointerException {
		if (this.isBlank(message) || message == null) {
			throw new NullPointerException("Ivalid request: MESSAGE canot be NULL or 'empty'");
		}
		return message;
	}
	
	@Override
	public String toString() {
		return "[app: " + this.getApp() + ", level: " + this.getLevel() + ", message: " + this.getMessage() + "]";
	}
	
	public String toString4Log() {
		return "[app: " + this.getApp() +  ", message: " + this.getMessage() + "]";
	}

	public boolean isBlank(String s) {
		char ch [] = s.toCharArray();
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isWhitespace(ch[i])) {
				count++;
			}
		}
		if (count == ch.length) {
			return true;
		} else {
			return false;
		}
	}
}
