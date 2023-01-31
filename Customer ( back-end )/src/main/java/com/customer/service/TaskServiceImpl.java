package com.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Task;
import com.customer.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;

	@Override
	public void addTask(Task task) throws Exception {
		taskRepo.save(task);
	}

	@Override
	public void deleteTask(int id) throws Exception {
		Optional<Task>task =  taskRepo.findById(id);
		Task t = task.orElseThrow(()->new Exception("Empty"));
		taskRepo.delete(t);
	}

	@Override
	public Iterable<Task> viewById(int id) throws Exception {
		Iterable<Task> tasks = taskRepo.viewByUserId(id);
		return tasks;
	}
	
	
}
