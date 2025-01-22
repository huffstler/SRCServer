package org.searobin.server.organization;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name="organization")
public class Organization {

    @Id
    @GeneratedValue
    private UUID id;

    private String orgName;

    private ZonedDateTime createdOn;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String username) {
        this.orgName = username;
    }

    public ZonedDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(ZonedDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Angler{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
