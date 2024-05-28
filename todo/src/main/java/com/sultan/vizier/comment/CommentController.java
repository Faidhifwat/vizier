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

    @Autowired
    TaskService taskService;

    @PostMapping(value = "/create/{task_id}", consumes = "application/json")
    public ResponseEntity<String> create(
            @PathVariable("task_id") Long task_id,
            @RequestBody List<CommentDto> commentDtos) {

        Task task = taskService.findById(task_id).orElse(null);

        if (!Objects.nonNull(task)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task not found");
        }

        commentDtos.forEach(c -> c.setTask(task));
        commentService.create(commentDtos);

        return ResponseEntity.ok()
                .body("Comment created!");
        //TODO Add better checking on comment/tag/subtask/task
    }
}
