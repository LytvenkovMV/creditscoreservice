package org.example.creditscoreservice.service;

import lombok.RequiredArgsConstructor;
import org.example.creditscoreservice.dto.PersonDto;
import org.example.creditscoreservice.entity.Person;
import org.example.creditscoreservice.mapper.PersonMapper;
import org.example.creditscoreservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Optional<Person> getPerson(Long personId) {

        return repository.findById(personId);
    }

    public Long addPerson(PersonDto dto) {

        Person person = new Person();
        PersonMapper.modifyPersonFromPersonDto(dto, person);
        repository.save(person);
        return person.getId();
    }

    public boolean updatePerson(Long personId, PersonDto dto) {

        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isPresent()) {
            Person person = optPerson.get();
            PersonMapper.modifyPersonFromPersonDto(dto, person);
            repository.save(person);
            return true;
        }
        return false;
    }

    public boolean deletePerson(Long personId) {

        if (repository.existsById(personId)) {
            repository.deleteById(personId);
            return true;
        }
        return false;
    }
}
