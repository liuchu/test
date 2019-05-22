package me.liuchu.test.comm.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMapMerge {

    private static final Map<String,Double> userHighestScore = new HashMap<>();

    private void uppdateScoreMap(String name, Double currentScore){
        userHighestScore.merge(name, currentScore, (oldScore, newScore) -> (newScore + oldScore)/2);
    }

    public static void main(String[] args) {

        TestMapMerge testMapMerge = new TestMapMerge();
        testMapMerge.uppdateScoreMap("a", 90.0);
        testMapMerge.uppdateScoreMap("b", 91.0);
        testMapMerge.uppdateScoreMap("c", 92.0);
        testMapMerge.uppdateScoreMap("c", 95.0);

        userHighestScore.forEach((key, value) -> System.out.println(value));


    }
}
