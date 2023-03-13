package dev.huffstler.searobinclassic.fish;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "fish")
public class FishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String species;

    private float length;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}