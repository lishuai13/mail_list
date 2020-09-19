package com.lishuai.entity.vo;

import java.util.Date;

/**
 * 学生信息VO
 */
public class StudentVO {

    private int studentId;
    private String studentNumber;
    private String password;
    private String studentName;
    private String studentTele;
    private String studentEmail;
    private String specialities;
    private int grade;
    private String classes;
    private String city;
    private String company;
    private int enable_flag;
    private int loginNumber;
    private Date lastLogin;

    public StudentVO() {
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentTele() {
        return studentTele;
    }

    public void setStudentTele(String studentTele) {
        this.studentTele = studentTele;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getEnable_flag() {
        return enable_flag;
    }

    public void setEnable_flag(int enable_flag) {
        this.enable_flag = enable_flag;
    }

    public int getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(int loginNumber) {
        this.loginNumber = loginNumber;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
