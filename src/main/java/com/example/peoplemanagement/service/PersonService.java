package com.example.peoplemanagement.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.peoplemanagement.dto.mapper.PersonMapper;
import com.example.peoplemanagement.dto.request.PersonDTO;
import com.example.peoplemanagement.dto.response.MessageResponseDTO;
import com.example.peoplemanagement.entity.Person;
import com.example.peoplemanagement.exception.PersonNotFoundException;
import com.example.peoplemanagement.repository.PersonRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    
    public final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO create(PersonDTO personDTO) {
    
        Person person = personMapper.toModel(personDTO);
    
        Person savedPerson = personRepository.save(person);
   
        return MessageResponseDTO.builder()
                                 .message("Created person with ID" + savedPerson.getId())
                                 .build();
    }

    public List<PersonDTO> listAll() {
    
        List<Person> people = personRepository.findAll();

        return people.stream()
                     .map(personMapper::toDTO)
                     .collect(Collectors.toList());  
        
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                                        .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

}
