package com.sultan.vizier.task;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskMapper taskMapper;

	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<String> create(@Valid @RequestBody TaskDto taskDto) {
		Task task = taskMapper.taskDtoToTask(taskDto);
		taskService.create(task);
		return ResponseEntity.ok()
				.body("All good! I think");
		// TODO return failed if something wrong
	}
}
