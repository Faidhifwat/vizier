package com.sultan.vizier.comment;

import com.sultan.vizier.task.Task;
import com.sultan.vizier.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/create/{taskId}", consumes = "application/json")
    public ResponseEntity<String> addComment(@PathVariable(name = "taskId") Long taskId,
                                             @RequestBody List<CommentDto> commentDtos) {
        return commentService.create(taskId, commentDtos);
    }
}
