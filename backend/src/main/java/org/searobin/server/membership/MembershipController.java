package org.searobin.server.membership;

import org.searobin.server.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    private MembershipRepository membershipRepository;

    public MembershipController(@Autowired MembershipRepository membershipRepository){
        this.membershipRepository = membershipRepository;
    }

    @GetMapping
    public List<Membership> all(){
        // replace with HATEOAS api eventually
        return membershipRepository.findAll();
    }

}
