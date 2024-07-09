package org.example.creditscoreservice.mapper;

import org.example.creditscoreservice.dto.PersonDto;
import org.example.creditscoreservice.entity.Person;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PersonMapper {

    public static void modifyPersonFromPersonDto(PersonDto dto, Person person) {

        person.setInn(Long.valueOf(dto.getInn()));
        person.setFullname(dto.getFullName());
        person.setCreditScore(new BigDecimal(dto.getCreditScore()));
        person.setPhone(dto.getPhone());
        person.setEmail(dto.getEmail());
    }
}
