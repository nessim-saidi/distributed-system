package com.meins.demo.controller;

import com.meins.demo.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
@RequestMapping(value="/api", produces = "application/json")
public class HelloController {

        @RequestMapping(value = "/User", produces = "application/json")
        public User getUser() {
            User usr = new User();
            return usr;
        }
    
}