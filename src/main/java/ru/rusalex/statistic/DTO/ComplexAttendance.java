package ru.rusalex.statistic.DTO;

import java.time.LocalDateTime;

public class ComplexAttendance {

    private LocalDateTime startPeriod;
    private LocalDateTime endPeriod;
    private Integer wholeNumberOfVisits;
    private Integer numberOfUniqueVisitors;
    private Integer numberOfRegularVisitors;

    public ComplexAttendance(LocalDateTime startPeriod, LocalDateTime endPeriod, Integer wholeNumberOfVisits, Integer numberOfUniqueVisitors, Integer numberOfRegularVisitors) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.wholeNumberOfVisits = wholeNumberOfVisits;
        this.numberOfUniqueVisitors = numberOfUniqueVisitors;
        this.numberOfRegularVisitors = numberOfRegularVisitors;
    }

    public LocalDateTime getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalDateTime startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalDateTime getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDateTime endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Integer getWholeNumberOfVisits() {
        return wholeNumberOfVisits;
    }

    public void setWholeNumberOfVisits(Integer wholeNumberOfVisits) {
        this.wholeNumberOfVisits = wholeNumberOfVisits;
    }

    public Integer getNumberOfUniqueVisitors() {
        return numberOfUniqueVisitors;
    }

    public void setNumberOfUniqueVisitors(Integer numberOfUniqueVisitors) {
        this.numberOfUniqueVisitors = numberOfUniqueVisitors;
    }

    public Integer getNumberOfRegularVisitors() {
        return numberOfRegularVisitors;
    }

    public void setNumberOfRegularVisitors(Integer numberOfRegularVisitors) {
        this.numberOfRegularVisitors = numberOfRegularVisitors;
    }
}
