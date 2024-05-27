package com.sultan.vizier.subtask;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sultan.vizier.task.Task;
import com.sultan.vizier.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody String subtaskJson) {

        JsonObject subtaskObject = JsonParser.parseString(subtaskJson).getAsJsonObject();
        String title = subtaskObject.get("title").getAsString();
        Long id = subtaskObject.get("task_id").getAsLong();

        Task task = taskService.findById(id).orElse(null);

        if (!Objects.nonNull(task)) {
            return ResponseEntity.notFound().build();
        }

        Subtask subtask = new Subtask();
        subtask.setTitle(title);
        subtask.setTask(task);
        //TODO not complete, need to make it accept and create multiple subtask

        return ResponseEntity.ok()
                .body("Subtask created!");
    }
}
