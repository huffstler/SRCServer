//package org.searobin.server.rules;
//
//import dev.huffstler.searobinclassic.parse.Haul;
//
//import java.util.List;
//import java.util.function.Function;
//
//import static dev.huffstler.searobinclassic.Constants.*;
//
//
//public class Rules {
//
//    /**
//     * Different categories of fish are worth different amounts of points per inch.
//     */
//    private static final Function<Haul, Float> categoryRule = (Haul haul) -> {
//        String species = haul.getFish();
//        return Tier.getTier(species).getScorePerInch() * haul.getLength();
//    };
//
//    /**
//     * If a fish is caught using a lure, a bonus is added for each inch in how long it is.
//     */
//    private static final Function<Haul, Float> lureRule = (Haul haul) -> haul.isLureUsed() ? haul.getLength() * LURE_POINTS_PER_INCH : 0;
//
//    /**
//     * If game fish caught is over 24 inches, you get an extra 100 points per inch
//     */
//    private static final Function<Haul, Float> bigGameFish = (Haul haul) -> switch(Tier.getTier(haul.getFish())) {
//        case GAME,SPORT -> haul.getLength() > 24 ? haul.getLength() * BIG_GAME_FISH_POINT_PER_INCH : 0;
//        default -> 0F;
//    };
//
//    // Extra 1,000 points to a fisherman who catches the largest game AND trash fish
//    // private static final Function<Angler> fullMontyRule = (Angler fisherman) -> {
//    // }
//
//    // later on gonna use a database call for this one
//    //    private static final Function<Haul, Float> recordCatchRule = (Haul haul) -> {
//    //        return haul.isRecordCatch ? haul.getLength() * 25 : 0;
//    //    };
//
//    /**
//     * More docs to come, assumptions were off a bit
//     */
//    private static final Function<Haul, Float> sizeBonusRule = (Haul haul) -> switch(Tier.getTier(haul.getFish())){
//        case GAME -> Math.max(5 * (haul.getLength() - 10), 0);
//        case SPORT -> Math.max(2 * (haul.getLength() - 10), 0);
//        default -> Math.max(1 * (haul.getLength() - 10), 0);
//    };
//
//
//    private static final List<Function<Haul, Float>> STATIC_RULES = List.of(
//            categoryRule
//            , lureRule
//            , sizeBonusRule
//    );
//
//    private static final List<Function<Haul, Float>> DYNAMIC_RULES = List.of(
//            //, recordCatchRule
//            // fullMontyRule
//    );
//
//    // Thanks to whispersilk for helping collect my thoughts on how to do scoring :)
//    // https://tildes.net/~comp/14pv/what_programming_technical_projects_have_you_been_working_on#comment-7rnd
//    public float getPreScore(Haul haul){
//        return STATIC_RULES.stream()
//                .map(r -> r.apply(haul))
//                .reduce(0f, Float::sum);
//    }
//
//    public float getPostScore(Haul haul){
//        return DYNAMIC_RULES.stream()
//                .map(r -> r.apply(haul))
//                .reduce(0f, Float::sum);
//    }
//
//}