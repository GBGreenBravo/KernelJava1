package com.example.KernelJavaMinhyeop.repository;

import com.example.KernelJavaMinhyeop.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findStudentByStudentName(String studentName);
}
