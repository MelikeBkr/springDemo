package com.domain.service;

import com.domain.dto.PersonDto;
import com.domain.graphql.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService
{
    PersonDto save(PersonDto personDto);
    void delete(Long id);
    List<PersonDto> getAll();
    Page<Person> getAll(Pageable pageable);
}
