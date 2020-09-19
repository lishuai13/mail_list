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
public class LoginAndRegister {

    @Autowired
    private StudentService studentService;

    /**
     * 打开登陆页面
     * @return
     */
    @GetMapping("/")
    public String goLogin(){
        return "login";
    }

    /**
     * 打开注册页面
     * @return
     */
    @GetMapping("/goRegister")
    public String goRegister(){
        return "register";
    }

    /**
     * 登录
     * @param request
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpSession Session){
        String studentNumber = request.getParameter("studentNumber");
        String password = request.getParameter("password");
        Student student = studentService.login(studentNumber, password);
        if (student==null)
            return "0";
        else{
            Session.setAttribute("studentNumber", studentNumber);
            System.out.println("111111111111111111111111111111111111111");
            System.out.println(Session.getAttribute("studentNumber"));
            studentService.loginNumber(studentNumber);
            studentService.lastLogin(studentNumber);
            return "1";
        }
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/register")
    public String register(HttpServletRequest request,
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
        Map<String, Object> map = new HashMap<>();
        String studentNumber = request.getParameter("studentNumber");
        Student result = studentService.selectWithStudentNumber(studentNumber);
        if (result!=null)
            return "学生已存在";
        else {
            map.put("studentNumber", studentNumber);
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

            studentService.insert(map);
            return JsonUtils.getJson("注册成功！等待审核");
        }
    }

    @RequestMapping("/init")
    public String test(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpSession Session){

//        String studentNumber = (String) Session.getAttribute("studentNumber");
        String studentNumber = "5601117056";
        Student student = studentService.selectWithStudentNumber(studentNumber);
        PageHelper.startPage(pageNum,5);
        List<Student> list = studentService.selectClassmates(student.getSpecialitiesId(), student.getGrade(), student.getClasses());
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        model.addAttribute("studentNumber",studentNumber);
        model.addAttribute("pageInfo",pageInfo);
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession Session){
        Session.invalidate();
        return "login";
    }
}
