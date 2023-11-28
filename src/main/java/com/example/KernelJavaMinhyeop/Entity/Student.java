package com.example.KernelJavaMinhyeop.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Student")
@EntityListeners(AuditingEntityListener.class)
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
