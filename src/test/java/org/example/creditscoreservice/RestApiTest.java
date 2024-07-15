package org.example.creditscoreservice;

import lombok.extern.slf4j.Slf4j;
import org.example.creditscoreservice.entity.Person;
import org.example.creditscoreservice.repository.PersonRepository;
import org.example.creditscoreservice.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

@Slf4j
@SpringBootTest
class RestApiTest {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonService personService;

    @Test
    void repositoryTest() {

        Person person = new Person();
        person.setInn(12345L);
        person.setFullname("Ivanov Ivan");
        person.setCreditScore(new BigDecimal("10.0"));
        person.setPhone("+79258884537");
        person.setEmail("ivanoV_i@mail.ru");

        final int cycles = 100000;
        long[] delays = new long[cycles];

        for (int i = 0; i < cycles; i++) {

            long startTime = System.nanoTime();
            repository.save(person);
            long delay = System.nanoTime() - startTime;
            delays[i] = delay;
        }

        delays = Arrays.stream(delays).sorted().toArray();
        long sumDelay = Arrays.stream(delays).sum();

        Assertions.assertTrue(repository.existsById(1L));

        log.info("Результаты сохранения " + cycles + " записей в БД");
        log.info("Общее время: " + sumDelay + " нс");
        log.info("Медианное время: " + delays[(int) (cycles * 0.5)] + " нс");
        log.info("95 процентиль: " + delays[(int) (cycles * 0.95)] + " нс");
        log.info("99 процентиль: " + delays[(int) (cycles * 0.99)] + " нс");
    }
}
