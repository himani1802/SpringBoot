package com.example.TheProject.Controller;

import com.example.TheProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping("/")
    public String viewPage(Model model){
        model.addAttribute("listOfStudents",service.getAllStudents());
        return"index";
    }
}
