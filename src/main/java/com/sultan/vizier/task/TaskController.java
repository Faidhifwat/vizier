package com.sultan.vizier.task;

import com.sultan.vizier.tag.TagDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskMapper taskMapper;

	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<String> create(@Valid @RequestBody TaskDto taskDto) {
		return taskService.create(taskDto);
	}

	@GetMapping()
	public ResponseEntity<List<Task>> get() {
		return taskService.getAllTask();
	}

	@PostMapping(value = "/add-tag/{task_id}", consumes = "application/json")
	public ResponseEntity<String> addTag(@PathVariable(name = "task_id") Long taskId, @RequestBody TagDto tagDto) {
		return taskService.addTags(taskId, tagDto);
	}
}
