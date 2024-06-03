package com.sultan.vizier.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> create(@RequestBody TagDto tagDto) {
        return tagService.create(tagDto);
    }

    @PostMapping(value = "/create/{task_id}", consumes = "application/json")
    public ResponseEntity<String> addTag(@PathVariable(name = "task_id") Long taskId, @RequestBody TagDto tagDto) {
        return tagService.create(taskId, tagDto);
    }
}
