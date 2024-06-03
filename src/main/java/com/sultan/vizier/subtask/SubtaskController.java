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

    @PostMapping(value = "/create/{taskId}", consumes = "application/json")
    public ResponseEntity<String> create(
            @RequestBody List<SubtaskDto> subtaskDto,
            @PathVariable("taskId") Long taskId) {
        return subtaskService.create(taskId, subtaskDto);
    }
}
