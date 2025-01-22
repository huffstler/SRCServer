package org.searobin.server.membership;

import jakarta.persistence.*;
import org.searobin.server.angler.Angler;
import org.searobin.server.organization.Organization;
import org.searobin.server.tournament.Tournament;

import java.util.UUID;

@Entity
@Table(name="membership")
public class Membership {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name="organization_id", nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name="tournament_id", nullable=false)
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name="angler_id", nullable = false)
    private Angler angler;

    private boolean isOrgAdmin;

    private boolean isTourneyAdmin;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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

    public boolean isOrgAdmin() {
        return isOrgAdmin;
    }

    public void setOrgAdmin(boolean orgAdmin) {
        isOrgAdmin = orgAdmin;
    }

    public boolean isTourneyAdmin() {
        return isTourneyAdmin;
    }

    public void setTourneyAdmin(boolean tourneyAdmin) {
        isTourneyAdmin = tourneyAdmin;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", organization=" + organization +
                ", tournament=" + tournament +
                ", angler=" + angler +
                ", isOrgAdmin=" + isOrgAdmin +
                ", isTourneyAdmin=" + isTourneyAdmin +
                '}';
    }
}
