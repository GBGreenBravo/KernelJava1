package com.example.KernelJavaMinhyeop.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id", nullable = false)
	private int subjectId;

	@Column(name = "subject_name", nullable = false)
	private String subjectName;

	@Column(name = "grade_type", nullable = false)
	private int gradeType;
}
