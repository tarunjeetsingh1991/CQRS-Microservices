package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.LoginData;


public interface FormRepository extends JpaRepository<LoginData, String> {

}
