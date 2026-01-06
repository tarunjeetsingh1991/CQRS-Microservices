package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
