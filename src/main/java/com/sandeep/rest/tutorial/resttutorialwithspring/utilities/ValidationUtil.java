package com.sandeep.rest.tutorial.resttutorialwithspring.utilities;

import com.sandeep.rest.tutorial.resttutorialwithspring.exceptions.UserNotFoundException;
import com.sandeep.rest.tutorial.resttutorialwithspring.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ValidationUtil {

    @Autowired
    private AccountRepository accountRepository;

    public ValidationUtil() {
    }

    public void validateUser(String userId) {
        accountRepository.findByUsername(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}
