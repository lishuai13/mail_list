package com.lishuai.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 学生信息
 */

public class Student {

    private int studentId;
    @Size(min = 10,max = 10,message = "请输入正确的学号")
    private String studentNumber;
    @Size(min = 8,max = 16,message = "密码长度至少8位")
    private String password;
    private String studentName;
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$",message = "请输入正确有效的电话号码")
    private String studentTele;
    @Email(message = "请输入正确有效的邮箱")
    private String studentEmail;
    private int specialitiesId;
    private int grade;
    private int classes;
    private String city;
    private String company;
    private int enable_flag;
    private int loginNumber;
    private Date lastLogin;

    public Student() {
    }

    public Student(int studentId, String studentNumber, String password, String studentName, String studentTele, String studentEmail, int specialitiesId, int grade, int classes, String city, String company, int enable_flag, int loginNumber, Date lastLogin) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.password = password;
        this.studentName = studentName;
        this.studentTele = studentTele;
        this.studentEmail = studentEmail;
        this.specialitiesId = specialitiesId;
        this.grade = grade;
        this.classes = classes;
        this.city = city;
        this.company = company;
        this.enable_flag = enable_flag;
        this.loginNumber = loginNumber;
        this.lastLogin = lastLogin;
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

    public int getSpecialitiesId() {
        return specialitiesId;
    }

    public void setSpecialitiesId(int specialitiesId) {
        this.specialitiesId = specialitiesId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
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
