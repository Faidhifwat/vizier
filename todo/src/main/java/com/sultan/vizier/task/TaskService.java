package com.sultan.vizier.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public void create(Task task) {
		taskRepository.save(task);
	}
}
