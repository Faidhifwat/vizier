package com.sultan.vizier.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface TaskMapper {

	@Mapping(source = "subtasks", target = "subtasks")
	@Mapping(source = "comments", target = "comments")
	@Mapping(source = "tags", target = "tags")
	Task taskDtoToTask(TaskDto task);
}