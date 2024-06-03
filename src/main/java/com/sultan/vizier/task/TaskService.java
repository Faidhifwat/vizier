package com.sultan.vizier.task;

import com.sultan.vizier.comment.Comment;
import com.sultan.vizier.comment.CommentDto;
import com.sultan.vizier.comment.CommentMapper;
import com.sultan.vizier.subtask.Subtask;

import com.sultan.vizier.tag.Tag;
import com.sultan.vizier.tag.TagDto;
import com.sultan.vizier.tag.TagMapper;
import com.sultan.vizier.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private TagMapper tagMapper;

	@Autowired
	private TaskMapper taskMapper;

	@Autowired
	private CommentMapper commentMapper;

	public ResponseEntity<String> create(TaskDto taskDto) {
		Task task = taskMapper.taskDtoToTask(taskDto);

		List<Subtask> subtasks = task.getSubtasks();
		subtasks.forEach(st -> st.setTask(task));

		List<Comment> comments = task.getComments();
		comments.forEach(c -> c.setTask(task));

		createTask(task);

		return ResponseEntity.ok()
				.body("Task created");
	}

	public ResponseEntity<List<Task>> getAllTask() {
		List<Task> tasks = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "dateCreated"));

		return ResponseEntity.ok()
				.body(tasks);
	}


	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

	public void createTask(Task task) {
		taskRepository.save(task);
	}
}
