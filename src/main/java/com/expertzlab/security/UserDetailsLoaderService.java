package com.expertzlab.security;

import com.expertzlab.readbook.Reader;
import com.expertzlab.readbook.ReaderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by gireeshbabu on 10/01/17.
 */
@Service
public class UserDetailsLoaderService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsLoaderService.class);
    @Autowired
    ReaderRepo readerRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        logger.debug("User name - "+ username);
        UserDetails userDetails = readerRepo.findOne(username);
        logger.debug("after loading - "+ ((Reader)userDetails).getFullname());
        return userDetails;

    }
}
