package com.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Task;
import com.customer.module.TaskResponse;
import com.customer.service.TaskServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskServiceImpl taskService;

	@RequestMapping("/addTask")
	public ResponseEntity<?> addTask(@RequestBody Task task) throws Exception {
		taskService.addTask(task);
		return new ResponseEntity<>(task, HttpStatus.CREATED);
	}
	
	@RequestMapping("/deleteTask")
	public void deleteTask(@RequestParam int id) throws Exception{
		taskService.deleteTask(id);
	}
	
	@RequestMapping("/viewAll")
	public ResponseEntity<?> viewAll(@RequestParam int id) throws Exception{
		Iterable<Task> tasksOpt = taskService.viewById(id);
		List<TaskResponse> tasks = new ArrayList<>();
		tasksOpt.forEach(task->{
			TaskResponse tempTask = new TaskResponse();
			tempTask.setTaskId(task.getTaskId());
			tempTask.setTask(task.getTask());
			tempTask.setUserId(task.getCreds().getId());
			tasks.add(tempTask);
		});
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
}
