package com.example.KernelJavaMinhyeop.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Subject {

	@Id
	@Column(name = "subject_id", nullable = false)
	private int subjectId;

	@Column(name = "subject_name", nullable = false)
	private String subjectName;

	@Column(name = "grade_type", nullable = false)
	private int gradeType;
}
