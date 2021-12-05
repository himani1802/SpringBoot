package com.example.TheProject.Service;

import com.example.TheProject.Model.StudentOne;
import com.example.TheProject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repository;
    @Override
    public List<StudentOne> getAllStudents() {
        return repository.findAll();
    }
}
