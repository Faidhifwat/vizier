package com.sultan.vizier.subtask;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SubtaskRepository extends CrudRepository<Subtask, Long> {

	Optional<Subtask> findById(Long id);
}
