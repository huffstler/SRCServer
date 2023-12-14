package org.searobin.server.catches;

import jakarta.persistence.*;
import org.searobin.server.angler.Angler;
import org.searobin.server.fish.Fish;
import org.searobin.server.tournament.Tournament;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name="catches")
public class Catch {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name="tournament_id", nullable=false)
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name="angler_id", nullable = false)
    private Angler angler;

    @ManyToOne
    @JoinColumn(name="fish_id", nullable = false)
    private Fish fish;

    private float fishLength;

    private boolean usedLure;

    private ZonedDateTime catchTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Angler getAngler() {
        return angler;
    }

    public void setAngler(Angler angler) {
        this.angler = angler;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public float getFishLength() {
        return fishLength;
    }

    public void setFishLength(float fishLength) {
        this.fishLength = fishLength;
    }

    public boolean isUsedLure() {
        return usedLure;
    }

    public void setUsedLure(boolean usedLure) {
        this.usedLure = usedLure;
    }

    public ZonedDateTime getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(ZonedDateTime catchTime) {
        this.catchTime = catchTime;
    }

    @Override
    public String toString() {
        return "Catch{" +
                "id=" + id +
                ", tournament=" + tournament +
                ", angler=" + angler +
                ", fish=" + fish +
                ", fishLength=" + fishLength +
                ", usedLure=" + usedLure +
                ", catchTime=" + catchTime +
                '}';
    }
}
