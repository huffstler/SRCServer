package org.searobin.server.catches;

import org.searobin.server.organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catch")
public class CatchController {

    private CatchRepository catchRepository;

    public CatchController(@Autowired CatchRepository catchRepository){
        this.catchRepository = catchRepository;
    }

    @GetMapping
    public List<Catch> all(){
        // replace with HATEOAS api eventually
        return catchRepository.findAll();
    }

}
