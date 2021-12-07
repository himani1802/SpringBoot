package com.example.TheProject.Service;

import com.example.TheProject.Model.StudentOne;
import com.example.TheProject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repository;
    @Override
    public List<StudentOne> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void saveStudent(StudentOne student) {
        this.repository.save(student);
    }

    @Override
    public StudentOne getStudentById(long Id) {
        Optional<StudentOne> optional = repository.findById(Id);
        StudentOne student= null;
        if(optional.isPresent()){
            student = optional.get();

        }else{
            throw new RuntimeException("Student not found for Id ::" + Id);
        }
        return student;

    }

    @Override
    public void deleteStudentById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    // Commenting below method to add sorting feature with pagination
//    public Page<StudentOne> findPaginated(int pageNumber, int pageSize) {
        public Page<StudentOne> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection) {
        // Adding below line to add sorting feature with pagination
        Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNumber-1,pageSize, sort);
        return this.repository.findAll(pageable);
    }
}
