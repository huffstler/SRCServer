package dev.huffstler.searobinclassic.meta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InformationController {
    @GetMapping("version")
    public String getFoo(){
        return "version is still in development.";
    }
}
