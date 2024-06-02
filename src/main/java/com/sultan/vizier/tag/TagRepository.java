package com.sultan.vizier.tag;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Optional<Tag> findById(Long id);

	Optional<Tag> findByName(String name);
}
