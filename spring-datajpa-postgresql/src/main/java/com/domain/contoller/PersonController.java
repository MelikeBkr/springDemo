package com.domain.contoller;

import com.domain.dto.PersonDto;
import com.domain.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController
{
    private final PersonService personService;
    //REST PUT Method
    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto)
    {
        return ResponseEntity.ok(personService.save(personDto));
    }
    //REST GET Method
    @GetMapping
    public ResponseEntity<List<PersonDto>> listAllUsers()
    {
        return ResponseEntity.ok(personService.getAll());
    }
}
