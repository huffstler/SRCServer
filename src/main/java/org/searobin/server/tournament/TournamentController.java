package org.searobin.server.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private TournamentRepository tournamentRepository;

    public TournamentController(@Autowired TournamentRepository tournamentRepository){
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping
    public List<Tournament> all(){
        // replace with HATEOAS api eventually
        return tournamentRepository.findAll();
    }

}
