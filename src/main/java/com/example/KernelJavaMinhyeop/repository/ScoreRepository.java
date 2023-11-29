package com.example.KernelJavaMinhyeop.repository;

import com.example.KernelJavaMinhyeop.entity.Score;
import com.example.KernelJavaMinhyeop.entity.Student;
import com.example.KernelJavaMinhyeop.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findAllByGradeNull();

    List<Score> findAllByStudent(Student student);

    List<Score> findAllBySubject(Subject subject);
}
