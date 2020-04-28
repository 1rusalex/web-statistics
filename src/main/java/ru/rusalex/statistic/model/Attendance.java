package ru.rusalex.statistic.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendance", indexes = {@Index(name = "IDX_DATETIME", columnList = "datetime")})
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id"/*, nullable=false*/)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id"/*, nullable=false*/)
    private Page page;

    public Attendance(LocalDateTime dateTime, Person person, Page page) {
        this.dateTime = dateTime;
        this.person = person;
        this.page = page;
    }

    protected Attendance(){}

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Person getPerson() {
        return person;
    }

    public Page getPage() {
        return page;
    }
}
