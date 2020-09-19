package com.lishuai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lishuai.entity.Student;
import com.lishuai.entity.vo.StudentVO;
import com.lishuai.service.ClassesService;
import com.lishuai.service.SpecialitiesService;
import com.lishuai.service.StudentService;
import com.lishuai.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SpecialitiesService specialitiesService;
    @Autowired
    private ClassesService classesService;

    @RequestMapping("/Approval")
    public String Approval(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpSession Session){

        List<StudentVO> list = studentService.selectApproval();
        model.addAttribute("pageInfo",list);
        return "admin";
    }

    @ResponseBody
    @PostMapping("/adopt")
    public String adopt(HttpServletRequest request){
        String[] studentIds = request.getParameterValues("studentIds");
        int i= 0;
        for (String studentId : studentIds) {
            studentService.adopt(Integer.parseInt(studentId));
            i++;
        }
        return JsonUtils.getJson("通过了"+i+"条申请");
    }

    @ResponseBody
    @PostMapping("/reject")
    public String reject(HttpServletRequest request){
        String[] studentIds = request.getParameterValues("studentIds");
        int i= 0;
        for (String studentId : studentIds) {
            studentService.reject(Integer.parseInt(studentId));
            i++;
        }
        return JsonUtils.getJson("拒绝了"+i+"条申请");
    }
}
