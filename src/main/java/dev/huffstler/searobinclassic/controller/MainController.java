package dev.huffstler.searobinclassic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/foo")
    public String getFoo(){
        return "Foo";
    }
}
