package ru.rusalex.statistic.DTO;

public class PersonalAttendance {

    private String userName;
    private String pageAddress;
    private Integer numberOfVisits;

    public PersonalAttendance(String userName, String pageAddress, Integer numberOfVisits) {
        this.userName = userName;
        this.pageAddress = pageAddress;
        this.numberOfVisits = numberOfVisits;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPageAddress() {
        return pageAddress;
    }

    public void setPageAddress(String pageAddress) {
        this.pageAddress = pageAddress;
    }

    public Integer getnumberOfVisits() {
        return numberOfVisits;
    }

    public void setnumberOfVisits(Integer numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }
}
