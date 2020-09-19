package com.lishuai.service;

import com.lishuai.entity.Student;
import com.lishuai.entity.vo.StudentVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> test();

    List<Student> selectStudent(Map map);

    StudentVO detail(int studentId);

    Student login(String studentNumber,String password);

    int insert(Map map);

    Student selectWithStudentNumber(String studentNumber);

    List<Student> selectClassmates(int specialitiesId,int grade,int classes);

    int loginNumber(String studentNumber);

    int lastLogin(String studentNumber);

    int updateStudent(Map map);

    List<StudentVO> selectApproval();

    int adopt(int studentId);

    int reject(int studentId);
}
