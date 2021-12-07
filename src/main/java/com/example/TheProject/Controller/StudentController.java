package com.example.TheProject.Controller;

import com.example.TheProject.Model.StudentOne;
import com.example.TheProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping("/")
    public String viewPage(Model model){
//        Commented for pagination code
//        model.addAttribute("listOfStudents",service.getAllStudents());
//        return"index";

//        Commented for adding sorting with pagination code
//        return  viewPagination(1,model);

        return  viewPagination(1, "name", "asc",model);

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

//    Commenting for adding sorting feature with pagination
//    public String viewPagination(@PathVariable (value= "pageNumber") int pageNumber , Model model){

    public String viewPagination(@PathVariable (value= "pageNumber") int pageNumber ,
                                 @RequestParam("sortField") String sortField,
                                 @RequestParam("sortDirection") String sortDirection,
                                 Model model){
        int pageSize= 5;
//        Commenting for adding sorting feature with pagination
//        Page<StudentOne> page= service.findPaginated(pageNumber, pageSize);

        Page<StudentOne> page= service.findPaginated(pageNumber, pageSize,sortField, sortDirection);
        List<StudentOne> listStudents = page.getContent();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());

        //Adding these 3 attributers for sorting feature
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDirection",sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("listOfStudents",listStudents);
        return "index";
    }
}
