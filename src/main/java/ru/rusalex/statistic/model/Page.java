package ru.rusalex.statistic.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "page", indexes = {@Index(name = "IDX_ADDRESS", columnList = "address")})
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String address;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "page"
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    private Set<Attendance> attendances;

    public Page(String address) {
        this.address = address;
    }

    protected Page() {}

    public String getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }
}
