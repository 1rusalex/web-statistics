package ru.rusalex.statistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rusalex.statistic.DTO.ComplexAttendance;
import ru.rusalex.statistic.DTO.PersonalAttendance;
import ru.rusalex.statistic.model.Attendance;
import ru.rusalex.statistic.model.Page;
import ru.rusalex.statistic.model.Person;
import ru.rusalex.statistic.repository.AttendanceRepository;
import ru.rusalex.statistic.repository.PersonRepository;

import java.time.LocalDateTime;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PageService pageService;

    @Transactional
    public PersonalAttendance addVisitAndGetPersonalAttendance(String personName, String pageAddress) {
        Page page = pageService.getOrCreatePage(pageAddress);
        Person person = personRepository.findByLogin(personName);
        if (person != null) {
            addVisit(person, page);
            return getPersonalAttendanceByPage(person, page);
        } else {
            throw new IllegalArgumentException("person name is incorrect.");
        }
    }

    @Transactional
    public ComplexAttendance getStatInfoByPeriodAndPerson(LocalDateTime startPeriod, LocalDateTime endPeriod, String personName) {
        Person person = personRepository.findByLogin(personName);
        if (person != null) {
            Integer wholeNumberOfVisits = attendanceRepository.countAllByPersonAndDateTimeBetween(person, startPeriod, endPeriod);
            Integer NumberOfRegularVisitors = attendanceRepository.countAllRegularUsers();
            return new ComplexAttendance(startPeriod, endPeriod, wholeNumberOfVisits, 1, NumberOfRegularVisitors);
        } else {
            throw new IllegalArgumentException("person name is incorrect.");
        }
    }

    @Transactional
    public ComplexAttendance getStatInfoByPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod) {
        Integer wholeNumberOfVisits = attendanceRepository.countAllByDateTimeBetween(startPeriod, endPeriod);
        Integer NumberOfRegularVisitors = attendanceRepository.countAllRegularUsers();
        return new ComplexAttendance(startPeriod, endPeriod, wholeNumberOfVisits, 1, NumberOfRegularVisitors);
    }

    public void addVisit(Person person, Page page) {
        Attendance attendance = new Attendance(LocalDateTime.now(), person, page);
        attendanceRepository.save(attendance);
    }

    public PersonalAttendance getPersonalAttendanceByPage(Person person, Page page) {
        Integer numberOfVisits = attendanceRepository.countAllByPageAndPerson(page, person);
        return new PersonalAttendance(person.getLogin(), page.getAddress(), numberOfVisits);
    }


}
