package ru.rusalex.statistic.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.rusalex.statistic.DTO.ComplexAttendance;
import ru.rusalex.statistic.DTO.PersonalAttendance;
import ru.rusalex.statistic.service.AttendanceService;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/stat")
public class StatisticsController {


    @Autowired
    AttendanceService attendanceService;

    @ApiOperation(value = "Add event to database and return personal attendance data, allowed for role_user")
    @PostMapping
    public PersonalAttendance addVisit(String personLogin, String pageAddress) throws ExecutionException, InterruptedException {
        CompletableFuture<PersonalAttendance> personalAttendanceCompletableFuture = attendanceService.addVisitAndGetPersonalAttendance(personLogin, pageAddress);
        return personalAttendanceCompletableFuture.get();
    }

    @ApiOperation(value = "return common attendance data, allowed only for role_admin")
    @GetMapping
    public ComplexAttendance getStatInfoByPeriod(
            @RequestParam(value = "startPeriod")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startPeriod,
            @RequestParam(value = "endPeriod") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endPeriod,
            @RequestParam(value = "personName", required = false) String personName) {
        return personName!=null
                ?attendanceService.getStatInfoByPeriodAndPerson(startPeriod, endPeriod, personName)
                :attendanceService.getStatInfoByPeriod(startPeriod, endPeriod);
    }
}
