package com.sultan.vizier.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.sultan.vizier.subtask.Subtask;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sultan.vizier.tag.Tag;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	//TODO change to enum
	@Column(name = "status", length = 10)
	private String status;

	@Column(name = "date_created", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(name = "date_updated")
	@UpdateTimestamp
	private LocalDateTime dateUpdated;

	@Column(name = "date_due")
	private LocalDateTime dateDue;

	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Subtask> subtasks;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "task_tag",
		joinColumns = @JoinColumn(name = "task_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private Set<Tag> tags;

}
