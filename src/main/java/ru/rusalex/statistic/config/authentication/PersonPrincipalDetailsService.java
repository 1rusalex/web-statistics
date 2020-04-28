package ru.rusalex.statistic.config.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rusalex.statistic.model.Person;
import ru.rusalex.statistic.repository.PersonRepository;

@Service
public class PersonPrincipalDetailsService implements UserDetailsService {
    private PersonRepository personRepository;

    public PersonPrincipalDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = this.personRepository.findByLogin(s);
        return new PersonPrincipal(person);
    }
}

