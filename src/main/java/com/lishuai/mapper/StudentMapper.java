package com.lishuai.mapper;

import com.lishuai.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {

    List<Student> test();

    List<Student> selectStudent(Map map);

    Student detail(int studentId);

    Student login(String studentNumber,String password);

    /**
     * 申请插入，等待审核
     * @param map
     * @return
     */
    int insert(Map map);

    /**
     * 注册的时候判断学号是否已存在
     * @param studentNumber
     * @return
     */
    Student selectWithStudentNumber(String studentNumber);

    /**
     * 查找同班同学
     * @param specialitiesId
     * @param grade
     * @param classes
     * @return
     */
    List<Student> selectClassmates(int specialitiesId,int grade,int classes);

    /**
     * 登录次数加一
     * @param studentNumber
     * @return
     */
    int loginNumber(String studentNumber);

    /**
     * 最后登陆时间更新
     * @param studentNumber
     * @param date
     * @return
     */
    int lastLogin(String studentNumber, Date date);

    /**
     * 修改个人信息
     * @param map
     * @return
     */
    int updateStudent(Map map);

    /**
     * 查找待审批的学生
     * @return
     */
    List<Student> selectApproval();

    /**
     * 管理员审核通过
     * @param studentId
     * @return
     */
    int adopt(int studentId);

    /**
     * 管理员审核不通过
     * @param studentId
     * @return
     */
    int reject(int studentId);
}
