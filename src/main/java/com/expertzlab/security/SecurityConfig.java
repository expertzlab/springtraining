package com.expertzlab.security;

import com.expertzlab.readbook.Reader;
import com.expertzlab.readbook.ReaderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Profile("production")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private ReaderRepo readerRepo;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginMe")
                .permitAll()
                .and()
                .httpBasic().disable()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {
                    @Override
                    public UserDetails loadUserByUsername(String username)
                            throws UsernameNotFoundException {
                        logger.debug("User name - "+ username);
                        UserDetails userDetails = readerRepo.findOne(username);
                        logger.debug("after loading - "+ ((Reader)userDetails).getFullname());
                        return userDetails;

                    }
                });
    }


    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
    */
}
