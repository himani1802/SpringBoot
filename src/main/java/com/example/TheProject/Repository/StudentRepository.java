package com.example.TheProject.Repository;

import com.example.TheProject.Model.StudentOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentOne, Long>{
}
