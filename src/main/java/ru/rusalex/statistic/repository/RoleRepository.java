package ru.rusalex.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rusalex.statistic.model.Role;

//@Repository
public interface RoleRepository /*extends JpaRepository<Role, Long>*/ {
    Role findByAuthority(String role);
}
