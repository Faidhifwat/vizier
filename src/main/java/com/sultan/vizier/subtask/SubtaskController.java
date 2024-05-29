package com.sultan.vizier.subtask;

import com.sultan.vizier.task.Task;
import com.sultan.vizier.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/subtask")
public class SubtaskController {

    @Autowired
    private SubtaskMapper subtaskMapper;

    @Autowired
    private SubtaskService subtaskService;

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/create/{task_id}", consumes = "application/json")
    public ResponseEntity<String> create(
            @RequestBody List<SubtaskDto> subtaskDto,
            @PathVariable("task_id") Long task_id) {

        Task task = taskService.findById(task_id).orElse(null);

        if (!Objects.nonNull(task)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task not found");
        }

        subtaskDto.forEach(s -> s.setTask(task));
        subtaskService.create(subtaskDto);

        return ResponseEntity.ok()
                .body("Subtask created!");
    }
}
