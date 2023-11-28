package com.example.KernelJavaMinhyeop.repository;

import com.example.KernelJavaMinhyeop.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    public Subject findSubjectBySubjectName(String subjectName);
}
