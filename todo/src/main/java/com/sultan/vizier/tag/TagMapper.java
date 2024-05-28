package com.sultan.vizier.tag;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag tagDtoToTag(TagDto tagDto);
}
