package ru.rusalex.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rusalex.statistic.model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    Page findByAddress(String address);

}
