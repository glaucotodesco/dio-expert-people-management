package com.example.peoplemanagement.repository;

import com.example.peoplemanagement.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
