package com.sultan.vizier.task;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

	Optional<Task> findById(Long id);
}
