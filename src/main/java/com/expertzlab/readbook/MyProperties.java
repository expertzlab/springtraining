package com.expertzlab.readbook;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by gireeshbabu on 10/01/17.
 */

@Component
@ConfigurationProperties("expertzlab")
public class MyProperties {

    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
