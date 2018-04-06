package com.sandeep.rest.tutorial.resttutorialwithspring.repositories;

import com.sandeep.rest.tutorial.resttutorialwithspring.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
