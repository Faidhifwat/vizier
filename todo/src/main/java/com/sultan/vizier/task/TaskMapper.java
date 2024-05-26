package com.sultan.vizier.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface TaskMapper {

	@Mapping(source = "subtasks", target = "subtasks")
	Task taskDtoToTask(TaskDto task);
}
