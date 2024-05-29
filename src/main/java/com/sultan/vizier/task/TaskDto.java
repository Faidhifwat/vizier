package com.sultan.vizier.task;

import java.util.List;
import java.util.Set;

import com.sultan.vizier.comment.CommentDto;
import com.sultan.vizier.subtask.SubtaskDto;
import com.sultan.vizier.tag.TagDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDto {

	@NotBlank(message = "Title is mandatory")
	private String title;

	private String status;

	private List<SubtaskDto> subtasks;

	private Set<TagDto> tags;

	private List<CommentDto> comments;

}
