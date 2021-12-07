package com.example.TheProject.Service;

import com.example.TheProject.Model.StudentOne;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface StudentService {
    List<StudentOne> getAllStudents();
    void saveStudent(StudentOne student);
    StudentOne getStudentById(long Id);
    void deleteStudentById (long id);
}
