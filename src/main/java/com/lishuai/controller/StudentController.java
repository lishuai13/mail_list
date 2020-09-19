package com.lishuai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lishuai.entity.Student;
import com.lishuai.service.StudentService;
import com.lishuai.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/selectStudent")
    public String selectStudent(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request, HttpSession Session){
        PageHelper.startPage(pageNum,5);
        Map<String,Object> map = new HashMap<>();
        if (request.getParameter("studentNumber")!=null&& !request.getParameter("studentNumber").equals(""))
            map.put("studentNumber","%"+request.getParameter("studentNumber")+"%");
        if (request.getParameter("studentName")!=null&& !request.getParameter("studentName").equals(""))
            map.put("studentName","%"+request.getParameter("studentName")+"%");
        if (request.getParameter("specialitiesId")!=null&& !request.getParameter("specialitiesId").equals(""))
            map.put("specialitiesId",request.getParameter("specialitiesId"));
        if (request.getParameter("classes")!=null&& !request.getParameter("classes").equals(""))
            map.put("classes",Integer.parseInt(request.getParameter("classes")));
        if (request.getParameter("grade")!=null&& !request.getParameter("grade").equals(""))
            map.put("grade",Integer.parseInt(request.getParameter("grade")));

        List<Student> list = studentService.selectStudent(map);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        model.addAttribute("studentNumber",Session.getAttribute("studentNumber"));
        model.addAttribute("pageInfo",pageInfo);
        return "select";
    }


    @GetMapping("/detail")
    public String detail(int studentId,Model model){
        model.addAttribute("studentVO",studentService.detail(studentId));
        return "detail";
    }

    @GetMapping("/myself")
    public String myself(String studentNumber,Model model){
        Student student = studentService.selectWithStudentNumber(studentNumber);
        model.addAttribute("student",student);
        return "myself";
    }

    @ResponseBody
    @PostMapping("/editStudent")
    public String editStudent(HttpServletRequest request,
                              @Validated Student student,
                              BindingResult bindingResult){
        // 如果校验时有不符合校验规则的情况出现，springMVC会将错误信息放在BindingResult对象的错误提示信息里面
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder message = new StringBuilder();
            for (FieldError error : errors) {
                message.append(error.getDefaultMessage()).append("\n");
            }
            return message.toString();
        }
        else{
            Map<String, Object> map = new HashMap<>();
            map.put("studentNumber", request.getParameter("studentNumber"));
            map.put("password", request.getParameter("password"));
            map.put("studentName", request.getParameter("studentName"));
            map.put("studentTele", request.getParameter("studentTele"));
            map.put("studentEmail", request.getParameter("studentEmail"));
            map.put("specialitiesId", request.getParameter("specialitiesId"));
            map.put("grade", request.getParameter("grade"));
            map.put("classes", request.getParameter("classes"));
            if (request.getParameter("city") != null && !request.getParameter("city").equals(""))
                map.put("city", request.getParameter("city"));
            if (request.getParameter("company") != null && !request.getParameter("company").equals(""))
                map.put("company", request.getParameter("company"));
            studentService.updateStudent(map);
            return JsonUtils.getJson("修改成功！");
        }
    }
}
