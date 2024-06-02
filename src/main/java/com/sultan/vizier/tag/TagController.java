package com.sultan.vizier.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> create(@RequestBody TagDto tagDto) {
        tagService.create(tagDto);

        return ResponseEntity.ok()
                .body("Tag created!");
    } //TODO handle if tag with same name already created
}
