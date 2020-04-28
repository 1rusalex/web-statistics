package ru.rusalex.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rusalex.statistic.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByLogin(String login);
}
