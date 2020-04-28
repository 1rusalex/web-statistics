package ru.rusalex.statistic.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.rusalex.statistic.model.Attendance;
import ru.rusalex.statistic.model.Page;
import ru.rusalex.statistic.model.Person;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class InitRepository {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void initialize() {
        // Delete all
//        this.personRepository.deleteAll();

        // Crete users
        Person alex = new Person("alex", passwordEncoder.encode("alex"), "ROLE_USER");
        Person sergey = new Person("sergey", passwordEncoder.encode("sergey"), "ROLE_USER");
        Person admin = new Person("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN");



        Page page1 = new Page("page_1");
        Page page2 = new Page("page_2");
        Page page3 = new Page("page_3");
        Page page4 = new Page("page_4");
        Page page5 = new Page("page_5");
        Page page6 = new Page("page_6");
        Page page7 = new Page("page_7");
        Page page8 = new Page("page_8");
        Page page9 = new Page("page_9");
        Page page10 = new Page("page10");
        Page page11 = new Page("page_11");
        Page page12 = new Page("page_12");

        Attendance attendance_alex_1 = new Attendance(LocalDateTime.now(), alex, page1);
        Attendance attendance_alex_2 = new Attendance(LocalDateTime.now().minusDays(1), alex, page2);
        Attendance attendance_alex_3 = new Attendance(LocalDateTime.now().minusDays(2), alex, page3);
        Attendance attendance_alex_4 = new Attendance(LocalDateTime.now().minusDays(3), alex, page4);
        Attendance attendance_alex_5 = new Attendance(LocalDateTime.now().minusDays(4), alex, page5);
        Attendance attendance_alex_6 = new Attendance(LocalDateTime.now().minusDays(5), alex, page6);
        Attendance attendance_alex_7 = new Attendance(LocalDateTime.now().minusDays(6), alex, page7);
        Attendance attendance_alex_8 = new Attendance(LocalDateTime.now().minusDays(7), alex, page8);
        Attendance attendance_alex_9 = new Attendance(LocalDateTime.now().minusDays(8), alex, page9);
        Attendance attendance_sergey_1 = new Attendance(LocalDateTime.now(), sergey, page1);
        Attendance attendance_sergey_2 = new Attendance(LocalDateTime.now().minusDays(1), sergey, page2);
        Attendance attendance_sergey_3 = new Attendance(LocalDateTime.now().minusDays(2), sergey, page3);
        Attendance attendance_sergey_4 = new Attendance(LocalDateTime.now().minusDays(3), sergey, page4);
        Attendance attendance_sergey_5 = new Attendance(LocalDateTime.now().minusDays(4), sergey, page5);
        Attendance attendance_sergey_6 = new Attendance(LocalDateTime.now().minusDays(5), sergey, page6);
        Attendance attendance_sergey_7 = new Attendance(LocalDateTime.now().minusDays(6), sergey, page7);
        Attendance attendance_sergey_8 = new Attendance(LocalDateTime.now().minusDays(7), sergey, page8);
        Attendance attendance_sergey_9 = new Attendance(LocalDateTime.now().minusDays(8), sergey, page9);
        Attendance attendance_sergey_10 = new Attendance(LocalDateTime.now().minusDays(9), sergey, page9);
        Attendance attendance_sergey_11 = new Attendance(LocalDateTime.now().minusDays(10), sergey, page9);
        Attendance attendance_sergey_12 = new Attendance(LocalDateTime.now().minusDays(11), sergey, page9);

        List<Attendance>attendances = Arrays.asList(
                attendance_alex_1,
                attendance_alex_2,
                attendance_alex_3,
                attendance_alex_4,
                attendance_alex_5,
                attendance_alex_6,
                attendance_alex_7,
                attendance_alex_8,
                attendance_alex_9,
                attendance_sergey_1,
                attendance_sergey_2,
                attendance_sergey_3,
                attendance_sergey_4,
                attendance_sergey_5,
                attendance_sergey_6,
                attendance_sergey_7,
                attendance_sergey_8,
                attendance_sergey_9,
                attendance_sergey_10,
                attendance_sergey_11,
                attendance_sergey_12
                );

        List<Page> pages = Arrays.asList(page1, page2, page3, page4, page5, page6, page7, page8, page9, page10, page11, page12);
        List<Person> users = Arrays.asList(alex, sergey, admin);


        // Save to db
        this.pageRepository.saveAll(pages);
        this.personRepository.saveAll(users);
        this.attendanceRepository.saveAll(attendances);
    }

}
