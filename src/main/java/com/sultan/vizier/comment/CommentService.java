package com.sultan.vizier.comment;

import com.sultan.vizier.task.Task;
import com.sultan.vizier.task.TaskRepository;
import com.sultan.vizier.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private TaskService taskService;

    public ResponseEntity<String> create(Long taskId, List<CommentDto> commentDto) {
        Task task = taskService.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " not found"));

        List<Comment> comments = commentMapper.commentDtoToComment(commentDto);
        comments.forEach(c -> c.setTask(task));

        task.getComments().addAll(comments);

        taskService.createTask(task);

        return ResponseEntity.ok()
                .body("done add comment");
    }
}
