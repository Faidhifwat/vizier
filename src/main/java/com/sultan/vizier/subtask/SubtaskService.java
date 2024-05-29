package com.sultan.vizier.subtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskService {

    @Autowired
    private SubtaskRepository subtaskRepository;

    @Autowired
    private SubtaskMapper subtaskMapper;

    public void create(List<SubtaskDto> subtaskDto) {
       List<Subtask> subtask = subtaskMapper.subtaskDtoToSubtask(subtaskDto);
       subtaskRepository.saveAll(subtask);
    }
}
