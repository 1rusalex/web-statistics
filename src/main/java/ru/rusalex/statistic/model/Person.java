package ru.rusalex.statistic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person", indexes = {@Index(name = "IDX_LOGIN", columnList = "login")})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    /*@ManyToMany
    private final List<Role> roles = new ArrayList<>();

    public Collection<Role> getRoles() {
        return roles;
    }*/

    private String roles;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "person"
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    private List<Attendance> attendances;

    public Person(String login, String password, String roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    protected Person() {
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
