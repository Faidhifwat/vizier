package com.sultan.vizier.task;

import java.util.List;
import java.util.Set;

import com.sultan.vizier.subtask.Subtask;

import com.sultan.vizier.tag.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDto {

	@NotBlank(message = "Title is mandatory")
	private String title;

	private String status;

	private List<Subtask> subtasks;

	private Set<Tag> tags;

}
