package dev.huffstler.searobinclassic.tournament;

import dev.huffstler.searobinclassic.user.UserEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "admin", nullable = false)
    private UserEntity admin;

    @Column(name = "user", nullable = true)
    private List<UserEntity> participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
