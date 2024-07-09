package org.example.creditscoreservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.creditscoreservice.dto.PersonDto;
import org.example.creditscoreservice.entity.Person;
import org.example.creditscoreservice.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/creditscoreservice")
@RequiredArgsConstructor
public class AppController {

    private final PersonService service;

    @GetMapping(path = "/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable(value = "id") Long personId) {

        Optional<Person> optPerson = service.getPerson(personId);
        return optPerson
                .map(person -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(person))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @PostMapping(path = "/person")
    public ResponseEntity<String> addPerson(@RequestBody PersonDto dto) {

        Long id = service.addPerson(dto);
        return ResponseEntity.status(HttpStatus.OK).body(id.toString());
    }

    @PutMapping(path = "/person/{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable(value = "id") Long personId,
            @RequestBody PersonDto dto) {

        if (service.updatePerson(personId, dto)) return ResponseEntity.status(HttpStatus.OK).body(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping(path = "/person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(value = "id") Long personId) {

        if (service.deletePerson(personId)) return ResponseEntity.status(HttpStatus.OK).body(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
