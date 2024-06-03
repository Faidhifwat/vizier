package com.sultan.vizier.task;

import com.sultan.vizier.comment.Comment;
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

	public ResponseEntity<String> create(TaskDto taskDto) {
		Task task = taskMapper.taskDtoToTask(taskDto);

		List<Subtask> subtasks = task.getSubtasks();
		subtasks.forEach(st -> st.setTask(task));

		List<Comment> comments = task.getComments();
		comments.forEach(c -> c.setTask(task));

		taskRepository.save(task);

		return ResponseEntity.ok()
				.body("Task created");
	}

	public ResponseEntity<List<Task>> getAllTask() {
		List<Task> tasks = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "dateCreated"));

		return ResponseEntity.ok()
				.body(tasks);
	}

	public ResponseEntity<String> addTags(Long taskId, TagDto tagDto) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " not found"));

		Tag tag = tagRepository.findByName(tagDto.getName())
				.orElseGet(() -> {
					Tag createTag = tagMapper.tagDtoToTag(tagDto);
					return tagRepository.save(createTag);
				});

		if (Objects.nonNull(task.getTags())) {
				task.getTags().add(tag);
		}
		taskRepository.save(task);

		return ResponseEntity.ok()
				.body(String.format("Tag with name %s added to task ID %s", tagDto.getName(), taskId));
	}

	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
}
