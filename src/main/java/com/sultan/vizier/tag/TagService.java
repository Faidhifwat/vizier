package com.sultan.vizier.tag;

import com.sultan.vizier.aop.LogExecutionTime;
import com.sultan.vizier.task.Task;
import com.sultan.vizier.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TaskService taskService;

    @LogExecutionTime
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

    @LogExecutionTime
    public ResponseEntity<String> create(Long taskId, TagDto tagDto) {
        Task task = taskService.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " not found"));

        Tag tag = tagRepository.findByName(tagDto.getName())
                .orElseGet(() -> {
                    Tag createTag = tagMapper.tagDtoToTag(tagDto);
                    return tagRepository.save(createTag);
                });

        if (Objects.nonNull(task.getTags())) {
            task.getTags().add(tag);
        }
        taskService.createTask(task);

        return ResponseEntity.ok()
                .body(String.format("Tag with name %s added to task ID %s", tagDto.getName(), taskId));
    }
}
