package dev.huffstler.searobinclassic.parse;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "angler", "fish", "length", "lureUsed" })
public class Haul {

    String angler;
    String fish;
    float length;
    boolean lureUsed;

    public Haul(){}

    public Haul(String angler, String fish, float length, boolean lureUsed){
        this();
        this.angler = angler;
        this.fish = fish;
        this.length = length;
        this.lureUsed = lureUsed;
    }

    public String getFish() {
        return fish;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isLureUsed() {
        return lureUsed;
    }

    public void setLureUsed(boolean lureUsed) {
        this.lureUsed = lureUsed;
    }

    public String getAngler() {
        return angler;
    }

    public void setAngler(String angler) {
        this.angler = angler;
    }
}
