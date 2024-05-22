package com.sultan.vizier.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sultan.vizier.subtask.SubtaskDto;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	// From DTO create a task (use MapStruc)

	@PostMapping("/")
	public TaskDto create(@RequestBody TaskDto taskDto) {
		return taskDto;
	}
}
