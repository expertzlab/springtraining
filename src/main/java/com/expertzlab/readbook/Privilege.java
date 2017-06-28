package com.expertzlab.readbook;

import com.expertzlab.readbook.RCenter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by gireeshbabu on 01/06/17.
 */
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String privilegeName;

    @ManyToMany(mappedBy = "privileges")
    private Collection<RCenter> rCenters;

    public String toString(){
        return privilegeName;
    }
}
