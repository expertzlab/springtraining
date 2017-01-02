package com.expertzlab.demoapp

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecondController {

    @RequestMapping("/hello")
    def hello() {
        return "Hello World Groovy"
    }
}
