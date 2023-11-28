-- 과목 테이블 생성
CREATE TABLE Subject (
                         subject_id INT PRIMARY KEY NOT NULL,
                         subject_name VARCHAR(255) NOT NULL,
                         grade_type INT NOT NULL
);

-- 학생 테이블 생성
CREATE TABLE Student (
                         student_id INT PRIMARY KEY NOT NULL,
                         student_name VARCHAR(255) NOT NULL,
                         major_subject_id INT,
                         FOREIGN KEY (major_subject_id) REFERENCES Subject(subject_id)
);

-- 성적 테이블 생성
CREATE TABLE Score (
                       student_id INT NOT NULL,
                       subject_id INT NOT NULL,
                       point INT,
                       PRIMARY KEY (student_id, subject_id),
                       FOREIGN KEY (student_id) REFERENCES Student(student_id),
                       FOREIGN KEY (subject_id) REFERENCES Subject(subject_id)
);


