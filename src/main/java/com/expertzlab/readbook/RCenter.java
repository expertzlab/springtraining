package com.expertzlab.readbook;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by gireeshbabu on 06/06/17.
 */

@Entity
public class RCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getRcenterName() {
        return rcenterName;
    }

    public void setRcenterName(String rcenterName) {
        this.rcenterName = rcenterName;
    }

    private String rcenterName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    @ManyToMany(mappedBy="rCenters")
    private Collection<Reader> radeers;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "rcenters_privileges",
            joinColumns = @JoinColumn(
                    name = "rcenter_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

}
