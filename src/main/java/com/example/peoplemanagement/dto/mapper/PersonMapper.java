package com.example.peoplemanagement.dto.mapper;

import com.example.peoplemanagement.dto.request.PersonDTO;
import com.example.peoplemanagement.entity.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    public PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class ); 

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}