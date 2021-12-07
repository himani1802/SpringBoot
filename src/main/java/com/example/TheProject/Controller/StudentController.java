package com.example.TheProject.Controller;

import com.example.TheProject.Model.StudentOne;
import com.example.TheProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping("/")
    public String viewPage(Model model){
        model.addAttribute("listOfStudents",service.getAllStudents());
        return"index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        StudentOne student = new StudentOne();
        model.addAttribute("student",student);
        return "new_student";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("employee") StudentOne student){
        service.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value ="id") long id, Model model){
        StudentOne student= service.getStudentById(id);
        model.addAttribute("student" ,student);
        return "update_student";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value="id")long id){
        this.service.deleteStudentById(id);
        return "redirect:/";
    }
}
