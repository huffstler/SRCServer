package org.searobin.server.angler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/angler")
public class AnglerController {

    private AnglerRepository anglerRepository;

    public AnglerController (@Autowired AnglerRepository anglerRepository){
        this.anglerRepository = anglerRepository;
    }

    @GetMapping
    public List<Angler> all(){
        // replace with HATEOAS api eventually
        return anglerRepository.findAll();
    }

}
