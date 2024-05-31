package com.sultan.vizier.subtask;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sultan.vizier.task.Task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Subtask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference(value = "task-subtask")
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	@Column(nullable = false)
	private String title;
}
