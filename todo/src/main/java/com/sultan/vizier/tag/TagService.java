package com.sultan.vizier.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagRepository tagRepository;

    public void create(TagDto tagDto) {
        Tag tag = tagMapper.tagDtoToTag(tagDto);
        tagRepository.save(tag);
    }
}
