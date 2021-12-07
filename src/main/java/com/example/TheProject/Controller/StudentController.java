package com.example.TheProject.Controller;

import com.example.TheProject.Model.StudentOne;
import com.example.TheProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping("/")
    public String viewPage(Model model){
//        model.addAttribute("listOfStudents",service.getAllStudents());
//        return"index";
      return  viewPagination(1,model);
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
    @GetMapping("/page/{pageNumber}")
    public String viewPagination(@PathVariable (value= "pageNumber") int pageNumber , Model model){
        int pageSize= 5;
        Page<StudentOne> page= service.findPaginated(pageNumber, pageSize);
        List<StudentOne> listStudents = page.getContent();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listOfStudents",listStudents);
        return "index";
    }
}
