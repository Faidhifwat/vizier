package com.sultan.vizier.task;

import com.sultan.vizier.comment.Comment;
import com.sultan.vizier.subtask.Subtask;

import com.sultan.vizier.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

	public List<Task> getAllTask() {
        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "dateCreated"));
	}

	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
}
