package com.sultan.vizier.comment;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    List<Comment> commentDtoToComment(List<CommentDto> commentDto);
}
