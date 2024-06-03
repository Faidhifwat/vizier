package com.sultan.vizier.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagRepository tagRepository;

    public ResponseEntity<String> create(TagDto tagDto) {
        if (tagRepository.findByName(tagDto.getName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Tag name already exist");
        }

        Tag tag = tagMapper.tagDtoToTag(tagDto);
        tagRepository.save(tag);

        return ResponseEntity.ok()
                .body("Tag created");
    }
}
