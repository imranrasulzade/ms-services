package com.rsl.msaccount.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountController {
    private final Environment environment;

    public AccountController(Environment environment) {
        this.environment = environment;
    }


    @GetMapping
    public String getHelloAndPORT(){
        return "Hello from MS-ACCOUNT\n" +
                "Port number: " + environment.getProperty("local.server.port");
    }
}
