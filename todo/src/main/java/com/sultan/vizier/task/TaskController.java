package com.sultan.vizier.task;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sultan.vizier.subtask.SubtaskDto;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskMapper taskMapper;

	@PostMapping("/create")
	public TaskDto create(@Valid @RequestBody TaskDto taskDto) {
		Task task = taskMapper.taskDtoToTask(taskDto);
		taskService.create(task);
		return taskDto;
	}
}
