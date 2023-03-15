package dev.huffstler.searobinclassic.haul;

import dev.huffstler.searobinclassic.fish.Fish;

public class Haul {
    Fish fish;
    float length;
    boolean lureUsed;

    public Haul(Fish fish, float length, boolean lureUsed){
        this.fish = fish;
        this.length = length;
        this.lureUsed = lureUsed;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
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
}
