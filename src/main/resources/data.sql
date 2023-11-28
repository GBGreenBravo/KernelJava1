-- 과목 정보 삽입
INSERT INTO Subject (subject_name, grade_type)
VALUES
    ('국어', 1),
    ('수학', 1);

-- 학생 정보 삽입
INSERT INTO Student (student_id, student_name, major_subject_id)
VALUES
    (211213, '김영롱', 1),
    (212330, '우무룡', 2),
    (201518, '정지용', 1),
    (202360, '이윤선', 1),
    (201290, '김현지', 2);

-- 성적 정보 삽입
INSERT INTO Score (student_id, subject_id, point)
VALUES
    (211213, 1, 95),
    (211213, 2, 56),
    (212330, 1, 95),
    (212330, 2, 98),
    (201518, 1, 100),
    (201518, 2, 88),
    (202360, 1, 89),
    (202360, 2, 95),
    (201290, 1, 83),
    (201290, 2, 56);
