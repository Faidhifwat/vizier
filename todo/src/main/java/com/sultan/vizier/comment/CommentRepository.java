package com.sultan.vizier.comment;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

	Optional<Comment> findById(long id);
}

