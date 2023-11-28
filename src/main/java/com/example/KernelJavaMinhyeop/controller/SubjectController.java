package com.example.KernelJavaMinhyeop.controller;

import com.example.KernelJavaMinhyeop.Entity.Subject;
import com.example.KernelJavaMinhyeop.service.SubjectService;
import com.example.KernelJavaMinhyeop.utils.GradeType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public ModelAndView getSubjects() {
        ModelAndView mv = new ModelAndView("subjects-list");

        Optional<List<Subject>> subjects = Optional.of(subjectService.getAllSubjects());
        mv.addObject("subjects", subjects);

        GradeType[] gradeTypes = GradeType.values();
        mv.addObject("gradeTypes", gradeTypes);

        return mv;
    }

    @PostMapping("/subject")
    public String addStudent(@ModelAttribute Subject subject) {
        subjectService.addSubject(subject);

        return "redirect:/subjects";
    }
}
