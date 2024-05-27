package com.sultan.vizier.task;

import com.sultan.vizier.comment.Comment;
import com.sultan.vizier.subtask.Subtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public void create(Task task) {
		List<Subtask> subtasks = task.getSubtasks();
		subtasks.forEach(st -> st.setTask(task));

		List<Comment> comments = task.getComments();
		comments.forEach(c -> c.setTask(task));

		taskRepository.save(task);
	}

	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
}
