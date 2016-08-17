package com.mechanitis.demo.sense.mood;

import com.mechanitis.demo.sense.twitter.Parser;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.mechanitis.demo.sense.mood.Mood.HAPPY;
import static com.mechanitis.demo.sense.mood.Mood.SAD;
import static java.util.stream.Collectors.joining;

public class MoodAnalyser {
    private static final Map<String, Mood> WORD_TO_MOOD = new HashMap<>();

    static {
        WORD_TO_MOOD.put("happy", HAPPY);
        WORD_TO_MOOD.put("good", HAPPY);
        WORD_TO_MOOD.put("great", HAPPY);
        WORD_TO_MOOD.put("keen", HAPPY);
        WORD_TO_MOOD.put("awesome", HAPPY);
        WORD_TO_MOOD.put("marvelous", HAPPY);
        WORD_TO_MOOD.put("yay", HAPPY);
        WORD_TO_MOOD.put("pleased", HAPPY);
        WORD_TO_MOOD.put("sad", SAD);
        WORD_TO_MOOD.put("mad", SAD);
        WORD_TO_MOOD.put("blargh", SAD);
        WORD_TO_MOOD.put("boo", SAD);
        WORD_TO_MOOD.put("terrible", SAD);
        WORD_TO_MOOD.put("horrible", SAD);
        WORD_TO_MOOD.put("bad", SAD);
        WORD_TO_MOOD.put("awful", SAD);
    }

    private MoodAnalyser() {
    }

    public static String analyseMood(String message) {
        String[] wordsInMessage = Parser.getValueFromMessage(message, "\"screen_name\":\"").split("\\s");
        return Stream.of(wordsInMessage)
                     .distinct()
                     .map(String::toLowerCase)
                     .map(WORD_TO_MOOD::get)
                     .filter(mood -> mood != null)
                     .distinct()
                     .map(Enum::name)
                     .collect(joining(","));
    }
}
