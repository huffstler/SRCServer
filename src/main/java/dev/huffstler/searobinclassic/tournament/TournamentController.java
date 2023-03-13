package dev.huffstler.searobinclassic.tournament;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tournament")
public class TournamentController {

    TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService){
        this.tournamentService = tournamentService;
    }

    @GetMapping("{tName}")
    public ResponseEntity<String> getTournamentByName(@PathVariable("tName") String tournamentName){
        return ResponseEntity.ok(tournamentName);
    }

    @PostMapping("create")
    public String createTournament(@RequestBody String input){
        return input;
    }
}
