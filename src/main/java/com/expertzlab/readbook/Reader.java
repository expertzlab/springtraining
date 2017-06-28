package com.expertzlab.readbook;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by gireeshbabu on 19/12/16.
 */
@Entity
public class Reader implements UserDetails {

    @Id
    private String username;
    private String password;
    private String fullname;

    public Reader(){

    }

    public Reader(Collection<RCenter> rCenters) {
        this.rCenters = rCenters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> gaList = new ArrayList<>();

        for (RCenter role:rCenters) {
            for(Privilege privilege: role.getPrivileges() ){
                gaList.add(new SimpleGrantedAuthority(privilege.toString()));
            }
        }
        return gaList;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="readers_rcenters")
    private Collection<RCenter> rCenters;
}
