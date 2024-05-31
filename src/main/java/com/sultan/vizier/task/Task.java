package com.sultan.vizier.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import com.sultan.vizier.comment.Comment;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 15)
	private Status status = Status.IN_PROGRESS;

	@Column(name = "date_created", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(name = "date_updated")
	@UpdateTimestamp
	private LocalDateTime dateUpdated;

	@Column(name = "date_due")
	private LocalDateTime dateDue;

	@JsonManagedReference(value="task-subtask")
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Subtask> subtasks;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "task_tag",
		joinColumns = @JoinColumn(name = "task_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	//TODO look into weird stuff happen when adding task_tag manually
	private Set<Tag> tags;

	@JsonManagedReference(value = "task-comment")
	@OneToMany(mappedBy = "task" , cascade = CascadeType.ALL)
	private List<Comment> comments;

}

enum Status {
	IN_PROGRESS,
	DUE,
	ARCHIVED,
	COMPLETED
}