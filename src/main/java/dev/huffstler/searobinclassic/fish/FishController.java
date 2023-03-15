package dev.huffstler.searobinclassic.fish;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("fish")
public class FishController {

    @GetMapping("/name/{fishName}")
    public Fish getFishFromName(@PathVariable("fishName") String name){
        return new Fish(UUID.randomUUID(), name);
    }

    @GetMapping("/id/{fishId}")
    public Fish getFishFromId(@PathVariable("fishId") UUID id){
        return new Fish(id, "patrick");
    }

    @GetMapping
    public List<Fish> getAllFish(){
        return List.of(new Fish(UUID.randomUUID(), "alex"));
    }

}
