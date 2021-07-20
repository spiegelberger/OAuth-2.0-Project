package com.spiegelberger.legacyusersservice;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.spiegelberger.legacyusersservice.data.UserEntity;
import com.spiegelberger.legacyusersservice.data.UsersRepository;

@Component
public class InitialSetup {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        UserEntity user = new UserEntity(
                1L,
                "qswe3mg84mfjtu",
                "Zsolt",
                "Spiegelberger",
                "zsoltspiegelberger@gmail.com	",
                bCryptPasswordEncoder.encode("pass"),
                "",
                false);

        usersRepository.save(user);
    }
}
