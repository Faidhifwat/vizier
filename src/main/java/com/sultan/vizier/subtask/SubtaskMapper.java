package com.sultan.vizier.subtask;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubtaskMapper {

   List<Subtask> subtaskDtoToSubtask(List<SubtaskDto> subtaskDto);

}
