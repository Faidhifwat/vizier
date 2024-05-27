package com.sultan.vizier.subtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskService {

    @Autowired
    private SubtaskRepository subtaskRepository;

    public void create(List<Subtask> subtask) {
       subtaskRepository.saveAll(subtask);
    }
}
