package ru.rusalex.statistic.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import ru.rusalex.statistic.DTO.ComplexAttendance;
import ru.rusalex.statistic.service.AttendanceService;

import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/stat")
public class StatisticsController {


    @Autowired
    AttendanceService attendanceService;

    @ApiOperation(value = "Add event to database and return personal attendance data, allowed for role_user")
    @PostMapping
    public DeferredResult<ResponseEntity<?>> addVisit(String personLogin, String pageAddress) {
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            output.setResult(ResponseEntity.ok(attendanceService.addVisitAndGetPersonalAttendance(personLogin, pageAddress)));
        });

        return output;
    }

    @ApiOperation(value = "return common attendance data, allowed only for role_admin")
    @GetMapping
    public ComplexAttendance getStatInfoByPeriod(
            @RequestParam(value = "startPeriod") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startPeriod,
            @RequestParam(value = "endPeriod") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endPeriod,
            @RequestParam(value = "personName", required = false) String personName) {
        return personName != null
                ? attendanceService.getStatInfoByPeriodAndPerson(startPeriod, endPeriod, personName)
                : attendanceService.getStatInfoByPeriod(startPeriod, endPeriod);
    }
}
