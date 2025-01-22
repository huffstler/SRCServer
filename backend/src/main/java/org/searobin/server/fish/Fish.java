package org.searobin.server.fish;

import jakarta.persistence.*;
import org.searobin.server.tier.Tier;

@Entity
@Table(name="fish")
public class Fish {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="tier_id", nullable = false)
    private Tier tier;

    private String name;

    public Fish(){}

    public Fish(Tier tier, String name){
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fish fish = (Fish) o;

        if (id != fish.id) return false;
        if (!tier.equals(fish.tier)) return false;
        return name.equals(fish.name);
    }

    @Override
    public int hashCode() {
        // fix this later, don't care right now
        long result = id;
        result = 31 * result + tier.hashCode();
        result = 31 * result + name.hashCode();
        return (int) result;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", tier=" + tier +
                ", name='" + name + '\'' +
                '}';
    }
}
