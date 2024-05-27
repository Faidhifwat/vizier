package com.sultan.vizier.subtask;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

	Optional<Subtask> findById(Long id);
}
