package com.example.KernelJavaMinhyeop.controller;

import com.example.KernelJavaMinhyeop.entity.Score;
import com.example.KernelJavaMinhyeop.service.ScoreService;
import com.example.KernelJavaMinhyeop.service.StudentService;
import com.example.KernelJavaMinhyeop.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ScoreController {
    private final ScoreService scoreService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    public ScoreController(ScoreService scoreService, StudentService studentService, SubjectService subjectService) {
        this.scoreService = scoreService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping("/scores")
    public ModelAndView getScores(@RequestParam String studentName, @RequestParam String subjectName) {
        ModelAndView mv = new ModelAndView("scores-list");

        mv.addObject("students", Optional.of(studentService.getAllStudents()));
        mv.addObject("subjects", Optional.of(subjectService.getAllSubjects()));

        scoreService.calculateGrades();

        if (studentName.isEmpty() && subjectName.isEmpty()) {
            mv.addObject("scores", Optional.of(scoreService.getAllScores()));
        } else if (!studentName.isEmpty()) {
            mv.addObject("scores", Optional.of(scoreService.getScoresByStudentName(studentName)));
        } else {
            mv.addObject("scores", Optional.of(scoreService.getScoresBySubjectName(subjectName)));
        }

        return mv;
    }
    @PostMapping("/score")
    public String addScore(@ModelAttribute Score score) {
        scoreService.addScore(score);

        return "redirect:/scores?studentName=&subjectName=";
    }

}
