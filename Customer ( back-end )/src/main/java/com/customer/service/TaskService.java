package com.customer.service;

import java.util.List;

import com.customer.entity.Task;

public interface TaskService {
	
	public void addTask(Task task) throws Exception;
	
	public void deleteTask(int id) throws Exception;
	
	public Iterable<Task> viewById(int id) throws Exception;
}
