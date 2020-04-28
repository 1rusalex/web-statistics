package ru.rusalex.statistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rusalex.statistic.DTO.PersonalAttendance;
import ru.rusalex.statistic.model.Page;
import ru.rusalex.statistic.model.Person;
import ru.rusalex.statistic.repository.PersonRepository;
import ru.rusalex.statistic.service.AttendanceService;
import ru.rusalex.statistic.service.PageService;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @Autowired
    AttendanceService attendanceService;
    @Autowired
    PageService pageService;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/test")
    public PersonalAttendance addVisit(
            @RequestParam(value = "personLogin") String personLogin,
            @RequestParam(value = "pageAddress") String pageAddress) {
        Person person = personRepository.findByLogin(personLogin);
        Page page = pageService.getOrCreatePage(pageAddress);
        return attendanceService.getPersonalAttendanceByPage(person, page);
    }

}
