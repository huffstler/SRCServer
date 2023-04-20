package dev.huffstler.searobinclassic.rules;

import dev.huffstler.searobinclassic.parse.Haul;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static dev.huffstler.searobinclassic.Constants.*;


public class Rules {

    /**
     * Different categories of fish are worth different amounts of points per inch.
     *
     * Game fish are worth 10 points per inch
     * Sport fish are worth 5 points per inch
     * Trash fish are worth 2 points per inch
     */
    private static final Function<Haul, Float> categoryRule = (Haul haul) -> {
        String species = haul.getFish();
        return Tier.getTier(species).getScorePerInch() * haul.getLength();
    };

    /**
     * If a fish is caught using a lure, a bonus is added for each inch in how long it is.
     *
     * a 5 inch reddrum is worth 50 points normally
     * Caught with a lure the score jumps to 550
     */
    private static final Function<Haul, Float> lureRule = (Haul haul) -> haul.isLureUsed() ? haul.getLength() * LURE_POINTS_PER_INCH : 0;

    // later on gonna use a database call for this one
    //    private static final Function<Haul, Float> recordCatchRule = (Haul haul) -> {
    //        return haul.isRecordCatch ? haul.getLength() * 25 : 0;
    //    };

    /**
     * If a catch is over a certain size you get an extra point bonus per inch over the cutoff.
     * For example: Cutoff for game fish is 10 inches
     * a 5 inch reddrum is 50 points
     * an 11 inch reddrum is 115 points
     */
    private static final Function<Haul, Float> sizeBonusRule = (Haul haul) -> switch(Tier.getTier(haul.getFish())){
        case GAME -> Math.max(5 * (haul.getLength() - 10), 0);
        case SPORT -> Math.max(2 * (haul.getLength() - 10), 0);
        default -> Math.max(1 * (haul.getLength() - 10), 0);
    };


    private static final List<Function<Haul, Float>> RULES = List.of(
            categoryRule
            , lureRule
            , sizeBonusRule
            //, recordCatchRule
    );

    // Thanks to whispersilk for helping collect my thoughts on how to do scoring :)
    // https://tildes.net/~comp/14pv/what_programming_technical_projects_have_you_been_working_on#comment-7rnd
    public float getScore(Haul haul){
        return RULES.stream()
                .map(r -> r.apply(haul))
                .reduce(0f, Float::sum);
    }

    public enum Tier{
        GAME(GAME_TIER_POINTS_PER_INCH),
        SPORT(SPORT_TIER_POINTS_PER_INCH),
        TRASH(TRASH_TIER_POINTS_PER_INCH),
        SHINED(0);

        private final int scorePerInch;
        private int getScorePerInch(){ return scorePerInch; }
        public static Tier getTier(String species){
            return switch (species.toLowerCase()) {
                case "shined" ->  Tier.SHINED;
                case "flounder", "reddrum", "blackdrum", "bluefish", "searobin", "stripedbass" -> Tier.GAME;
                case "spot", "pufferfish", "kingfish", "sheepshead", "seatrout", "spottedhake" -> Tier.SPORT;
                default -> Tier.TRASH;
            };
        }
        Tier(int scorePerInch){ this.scorePerInch = scorePerInch; }
    }
}