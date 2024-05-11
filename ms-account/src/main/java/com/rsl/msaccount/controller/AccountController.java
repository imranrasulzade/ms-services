package com.rsl.msaccount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @GetMapping
    public String get(){
        return "Hello from MS-ACCOUNT";
    }
}
