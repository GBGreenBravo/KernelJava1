package com.example.KernelJavaMinhyeop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Getter
public class Student {

	@Id
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "student_name")
	private String studentName;

	@ManyToOne
	@JoinColumn(name = "major_subject_id")
	private Subject majorSubject;
}
