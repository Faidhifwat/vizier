package com.sultan.vizier.subtask;

import com.sultan.vizier.aop.LogExecutionTime;
import com.sultan.vizier.task.Task;
import com.sultan.vizier.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskService {

    @Autowired
    private SubtaskRepository subtaskRepository;

    @Autowired
    private SubtaskMapper subtaskMapper;

    @Autowired
    private TaskService taskService;

    @LogExecutionTime
    public ResponseEntity<String> create(Long taskId, List<SubtaskDto> subtaskDto) {
        Task task = taskService.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " not found"));

        List<Subtask> subtasks = subtaskMapper.subtaskDtoToSubtask(subtaskDto);
        subtasks.forEach(s -> s.setTask(task));

        task.getSubtasks().addAll(subtasks);

        taskService.createTask(task);

        return ResponseEntity.ok()
               .body(String.format("Subtask created for task ID %s", taskId));
    }
}
