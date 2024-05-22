package com.sultan.vizier.task;

import java.util.List;

import com.sultan.vizier.subtask.SubtaskDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDto {

	private String title;

	private String status;

	private List<SubtaskDto> subtask;

}
