package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
	@NotBlank(message = "Task cannot be blank")
	private String task;
	
	@ManyToOne
	@JoinColumn
	private Credentials creds;
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Credentials getCreds() {
		return creds;
	}

	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
	
}
