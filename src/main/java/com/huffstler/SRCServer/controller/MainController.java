package com.huffstler.SRCServer.controller;

import com.huffstler.SRCServer.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final MainService main;

    public MainController(MainService mainService){
        this.main = mainService;
    }

    @GetMapping("hello")
    public String getRoot(){
        return main.getHello();
    }

}
