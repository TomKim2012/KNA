package com.wira.mms.client.application.ui.material.components;

import java.util.Date;

public class Task {

	private long id;
	private String taskName;
	private String user;
	private String userPicUrl;
	private Date timeAssigned;
	private Date timeDue;
	
	
	public Task() {
	}

	public Task(long id, String user, String userPicture, String taskname,
			Date timeAssigned, Date timeDue) {
		super();
		this.id = id;
		this.user = user;
		this.taskName = taskname;
		this.userPicUrl = userPicture;
		this.timeAssigned = timeAssigned;
		this.timeDue = timeDue;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public Date getTimeAssigned() {
		return timeAssigned;
	}


	public void setTimeAssigned(Date timeAssigned) {
		this.timeAssigned = timeAssigned;
	}


	public Date getTimeDue() {
		return timeDue;
	}


	public void setTimeDue(Date timeDue) {
		this.timeDue = timeDue;
	}

	public String getUserPicUrl() {
		return userPicUrl;
	}

	public void setUserPicUrl(String userPicUrl) {
		this.userPicUrl = userPicUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
