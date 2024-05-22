package com.sultan.vizier.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public void create(TaskDto taskDto) {
		Task task = new Task();
		task.setTitle(taskDto.getTitle());
		task.setStatus(taskDto.getStatus());
		taskRepository.save(task);
	}
}
