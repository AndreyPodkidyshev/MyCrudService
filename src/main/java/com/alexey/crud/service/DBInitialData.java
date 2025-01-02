package com.alexey.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DBInitialData {

    private final UserService userService;

    @PostConstruct
    public void setData() {
        userService.setInitData();
    }
}
