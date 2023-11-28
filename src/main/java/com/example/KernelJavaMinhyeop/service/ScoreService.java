package com.example.KernelJavaMinhyeop.service;

import com.example.KernelJavaMinhyeop.Entity.Score;
import com.example.KernelJavaMinhyeop.Entity.Student;
import com.example.KernelJavaMinhyeop.Entity.Subject;
import com.example.KernelJavaMinhyeop.gradeEvaluation.BasicEvaluation;
import com.example.KernelJavaMinhyeop.gradeEvaluation.GradeEvaluation;
import com.example.KernelJavaMinhyeop.gradeEvaluation.MajorEvaluation;
import com.example.KernelJavaMinhyeop.gradeEvaluation.PassFailEvaluation;
import com.example.KernelJavaMinhyeop.repository.ScoreRepository;
import com.example.KernelJavaMinhyeop.repository.StudentRepository;
import com.example.KernelJavaMinhyeop.repository.SubjectRepository;
import com.example.KernelJavaMinhyeop.utils.GradeType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public ScoreService(ScoreRepository scoreRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public void addScore(Score score) {
        scoreRepository.save(score);
    }
    public List<Score> getAllScores() {

        List<Score> scores = scoreRepository.findAll();

        return new ArrayList<>(scores.stream().sorted(Comparator.comparing(Score -> Score.getStudent().getStudentName())).toList());
    }

    public List<Score> getScoresByStudentName(String studentName) {
        Student student = studentRepository.findStudentByStudentName(studentName);
        return scoreRepository.findAllByStudent(student);
    }

    public List<Score> getScoresBySubjectName(String subjectName) {
        Subject subject = subjectRepository.findSubjectBySubjectName(subjectName);
        return scoreRepository.findAllBySubject(subject);
    }

    public void calculateGrades() {
        List<Score> emptyGradeScores = scoreRepository.findAllByGradeNull();

        for (int i = 0; i < emptyGradeScores.size(); i++) {
            String decidedGrade = decideGrade(emptyGradeScores.get(i).getStudent().getMajorSubject(), emptyGradeScores.get(i).getSubject(), emptyGradeScores.get(i).getPoint());
            emptyGradeScores.get(i).setGrade(decidedGrade);
            scoreRepository.save(emptyGradeScores.get(i));
        }
    }

    private String decideGrade(Subject majorSubject, Subject subject, int point) {
		GradeEvaluation gradeEvaluation;

        if (subject.getGradeType() == GradeType.PF_TYPE.getTypeCode()) {
            gradeEvaluation = new PassFailEvaluation();
        } else if (majorSubject == subject) {
            gradeEvaluation = new MajorEvaluation();
        } else {
            gradeEvaluation = new BasicEvaluation();
		}

		return gradeEvaluation.getGrade(point);
	}
}
