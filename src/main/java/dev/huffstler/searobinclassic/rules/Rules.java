package dev.huffstler.searobinclassic.rules;

import dev.huffstler.searobinclassic.haul.Haul;

import java.util.List;
import java.util.function.Function;

public class Rules {

    private static final int LURE_POINTS_PER_INCH = 100;
    private static final int GAME_TIER_POINTS_PER_INCH = 10;
    private static final int SPORT_TIER_POINTS_PER_INCH = 5;
    private static final int TRASH_TIER_POINTS_PER_INCH = 2;

    private static final Function<Haul, Float> tierRule = (Haul haul) -> {
        String species = haul.getFish().species();
        return Tier.getTier(species).getScorePerInch() * haul.getLength();
    };

    private static final Function<Haul, Float> lureRule = (Haul haul) -> haul.isLureUsed() ? haul.getLength() * LURE_POINTS_PER_INCH : 0;

    // later on gonna probably use a database call for this one
//    private static final Function<Haul, Float> recordCatchRule = (Haul haul) -> {
//        return haul.isRecordCatch ? haul.getLength() * 25 : 0;
//    };

    private static final Function<Haul, Float> sizeBonusRule = (Haul haul) -> {
        return switch(Tier.getTier(haul.getFish().species())){
            case T1 -> Math.max(5 * (haul.getLength() - 10), 0);
            case T2 -> Math.max(2 * (haul.getLength() - 10), 0);
            default -> Math.max(1 * (haul.getLength() - 10), 0);
        };
    };


    private static final List<Function<Haul, Float>> RULES = List.of(
            tierRule
            , lureRule
            , sizeBonusRule
//            , recordCatchRule
    );

    // Thanks to whispersilk for helping collect my thoughts on how to do scoring :)
    // https://tildes.net/~comp/14pv/what_programming_technical_projects_have_you_been_working_on#comment-7rnd
    public float getScore(Haul haul){
        return RULES.stream()
                .map(r -> r.apply(haul))
                .reduce(0f, Float::sum);
    };

    public enum Tier{
        T1(GAME_TIER_POINTS_PER_INCH),
        T2(SPORT_TIER_POINTS_PER_INCH),
        TRASH(TRASH_TIER_POINTS_PER_INCH);
        private final int scorePerInch;
        private int getScorePerInch(){ return scorePerInch; }
        public static Tier getTier(String species){
            return switch (species.toLowerCase()) {
                case "flounder", "reddrum", "blackdrum", "bluefish", "searobin", "stripedbass" -> Tier.T1;
                case "spot", "pufferfish", "kingfish", "sheepshead", "seatrout", "spottedhake" -> Tier.T2;
                default -> Tier.TRASH;
            };
        }
        Tier(int scorePerInch){ this.scorePerInch = scorePerInch; }
    }
}