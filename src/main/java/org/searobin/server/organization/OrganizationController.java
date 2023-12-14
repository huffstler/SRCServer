package org.searobin.server.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationRepository organizationRepository;

    public OrganizationController(@Autowired OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    @GetMapping
    public List<Organization> all(){
        // replace with HATEOAS api eventually
        return organizationRepository.findAll();
    }

}
