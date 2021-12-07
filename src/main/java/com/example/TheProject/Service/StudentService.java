package com.example.TheProject.Service;

import com.example.TheProject.Model.StudentOne;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface StudentService {
    List<StudentOne> getAllStudents();
    void saveStudent(StudentOne student);
    StudentOne getStudentById(long Id);
    void deleteStudentById (long id);
// Commenting below method to add sorting feature with pagination
//    Page<StudentOne> findPaginated(int pageNumber, int pageSize);
    Page<StudentOne> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);

}
