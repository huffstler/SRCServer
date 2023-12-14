package org.searobin.server.tournament;

import jakarta.persistence.*;
import org.searobin.server.organization.Organization;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name="tournaments")
public class Tournament {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    private String tournamentName;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private ZonedDateTime createdOn;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization org) {
        this.organization = org;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", organization=" + organization +
                ", tournamentName='" + tournamentName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createdOn=" + createdOn +
                '}';
    }
}
