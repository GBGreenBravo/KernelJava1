package com.example.KernelJavaMinhyeop.controller;

import com.example.KernelJavaMinhyeop.entity.Student;
import com.example.KernelJavaMinhyeop.entity.Subject;
import com.example.KernelJavaMinhyeop.service.StudentService;
import com.example.KernelJavaMinhyeop.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final SubjectService subjectService;

    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping("/students")
    public ModelAndView getStudents() {
        ModelAndView mv = new ModelAndView("students-list");

        Optional<List<Student>> students = Optional.of(studentService.getAllStudents());
        mv.addObject("students", students);

        Optional<List<Subject>> subjects = Optional.of(subjectService.getAllSubjects());
        mv.addObject("subjects", subjects);

        return mv;
    }

    @PostMapping("/student")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);

        return "redirect:/students";
    }
}
