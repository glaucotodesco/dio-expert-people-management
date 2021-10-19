package com.example.peoplemanagement.service;

import com.example.peoplemanagement.dto.MessageResponseDTO;
import com.example.peoplemanagement.entity.Person;
import com.example.peoplemanagement.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public MessageResponseDTO create(Person person) {
        Person savedPerson = personRepository.save(person);
   
        return MessageResponseDTO.builder()
                                 .message("Created person with ID" + savedPerson.getId())
                                 .build();
    }

}
