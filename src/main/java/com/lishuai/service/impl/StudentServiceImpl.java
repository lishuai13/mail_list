package com.lishuai.service.impl;

import com.lishuai.entity.Student;
import com.lishuai.entity.vo.StudentVO;
import com.lishuai.mapper.ClassesMapper;
import com.lishuai.mapper.SpecialitiesMapper;
import com.lishuai.mapper.StudentMapper;
import com.lishuai.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SpecialitiesMapper specialitiesMapper;

    @Autowired
    private ClassesMapper classesMapper;


    @Override
    public List<Student> test() {
        return studentMapper.test();
    }

    @Override
    public List<Student> selectStudent(Map map) {
        return studentMapper.selectStudent(map);
    }

    @Override
    public StudentVO detail(int studentId) {
        Student student = studentMapper.detail(studentId);
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentId(student.getStudentId());
        studentVO.setStudentNumber(student.getStudentNumber());
        studentVO.setPassword(student.getPassword());
        studentVO.setStudentName(student.getStudentName());
        studentVO.setStudentTele(student.getStudentTele());
        studentVO.setStudentEmail(student.getStudentEmail());
        studentVO.setSpecialities(specialitiesMapper.select(student.getSpecialitiesId()));
        studentVO.setGrade(student.getGrade());
        studentVO.setClasses(classesMapper.select(student.getClasses()));
        studentVO.setCity(student.getCity());
        studentVO.setCompany(student.getCompany());
        studentVO.setLoginNumber(student.getLoginNumber());
        studentVO.setLastLogin(student.getLastLogin());

        return studentVO;
    }

    @Override
    public Student login(String studentNumber, String password) {
        return studentMapper.login(studentNumber,password);
    }

    @Override
    public int insert(Map map) {
        return studentMapper.insert(map);
    }

    @Override
    public Student selectWithStudentNumber(String studentNumber) {
        return studentMapper.selectWithStudentNumber(studentNumber);
    }

    @Override
    public List<Student> selectClassmates(int specialitiesId, int grade, int classes) {
        return studentMapper.selectClassmates(specialitiesId,grade,classes);
    }

    @Override
    public int loginNumber(String studentNumber) {
        return studentMapper.loginNumber(studentNumber);
    }

    @Override
    public int lastLogin(String studentNumber) {
        return studentMapper.lastLogin(studentNumber,new Date());
    }

    @Override
    public int updateStudent(Map map) {
        return studentMapper.updateStudent(map);
    }

    @Override
    public List<StudentVO> selectApproval() {
        List<Student> students = studentMapper.selectApproval();
        List<StudentVO> studentVOs = new ArrayList<>();
        for (Student student : students) {
            StudentVO studentVO = new StudentVO();
            studentVO.setStudentId(student.getStudentId());
            studentVO.setStudentNumber(student.getStudentNumber());
            studentVO.setPassword(student.getPassword());
            studentVO.setStudentName(student.getStudentName());
            studentVO.setStudentTele(student.getStudentTele());
            studentVO.setStudentEmail(student.getStudentEmail());
            studentVO.setSpecialities(specialitiesMapper.select(student.getSpecialitiesId()));
            studentVO.setGrade(student.getGrade());
            studentVO.setClasses(classesMapper.select(student.getClasses()));
            studentVO.setCity(student.getCity());
            studentVO.setCompany(student.getCompany());
            studentVO.setLoginNumber(student.getLoginNumber());
            studentVO.setLastLogin(student.getLastLogin());

            studentVOs.add(studentVO);
        }
        return studentVOs;
    }

    @Override
    public int adopt(int studentId) {
        return studentMapper.adopt(studentId);
    }

    @Override
    public int reject(int studentId) {
        return studentMapper.reject(studentId);
    }
}
