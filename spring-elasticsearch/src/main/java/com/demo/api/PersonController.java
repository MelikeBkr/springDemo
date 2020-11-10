package com.demo.api;

import com.demo.entity.Person;
import com.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController
{
    private final PersonRepository personRepository;
    @PostConstruct
    public void PersonController()
    {
        Person p = new Person();
        p.setName("Melike");
        p.setSurname("Bakır");
        p.setAddress("address");
        p.setBirthOfDate(Calendar.getInstance().getTime());
        p.setId("M1315");
        personRepository.save(p);
    }
    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search)
    {
        List<Person> people = personRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(people);
    }
}
