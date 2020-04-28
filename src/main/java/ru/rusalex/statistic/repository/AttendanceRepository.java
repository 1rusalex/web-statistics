package ru.rusalex.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rusalex.statistic.model.Attendance;
import ru.rusalex.statistic.model.Page;
import ru.rusalex.statistic.model.Person;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findAllByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);

    List<Attendance> findAllByDateTimeBetweenAndPerson(LocalDateTime dateTime, LocalDateTime dateTime2, Person person);

    Integer countAllByPersonAndDateTimeBetween(Person person, LocalDateTime dateTime, LocalDateTime dateTime2);

    Integer countAllByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);

    Integer countAllByPageAndPerson(Page page, Person person);

    @Query(value = "WITH common_table AS (\n" +
            "SELECT user_id, count(DISTINCT page_id)\n" +
            "  FROM public.attendance\n" +
            "  GROUP BY user_id)\n" +
            "  SELECT count(*) FROM common_table\n" +
            "WHERE count>5",
    nativeQuery = true)
    Integer countAllRegularUsers();

}
