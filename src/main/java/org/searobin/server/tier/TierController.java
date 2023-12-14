package org.searobin.server.tier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tier")
public class TierController {

    private TierRepository tierRepository;

    public TierController (@Autowired TierRepository tierRepository){
        this.tierRepository = tierRepository;
    }

    @GetMapping
    public List<Tier> getAll(){
        return tierRepository.findAll();
    }

}
