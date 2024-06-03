package com.sultan.vizier.task;

import com.sultan.vizier.comment.Comment;
import com.sultan.vizier.comment.CommentDto;
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

}
