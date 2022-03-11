package com.zcc.mobile.sell.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to sell service!";
    }
}
