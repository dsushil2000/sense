package com.mechanitis.demo.sense.mood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.mechanitis.demo.sense.mood.Mood.HAPPY;
import static com.mechanitis.demo.sense.mood.Mood.SAD;
import static com.mechanitis.demo.sense.twitter.TweetParser.getTweetMessageFrom;

public class Moods implements Analyser {
    private static final Map<String, Mood> WORD_TO_MOOD = new HashMap<>();
    public static final List<String> HAPPY_WORDS = new ArrayList<>();

    static {
        HAPPY_WORDS.add("happy");
        HAPPY_WORDS.add("good");
        HAPPY_WORDS.add("great");
        HAPPY_WORDS.add("keen");
        HAPPY_WORDS.add("awesome");
        HAPPY_WORDS.add("marvelous");
        HAPPY_WORDS.add("yay");
        HAPPY_WORDS.add("pleased");
    }

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

    private Moods() {
    }

    @Override
    public String analyseMood(String message) {
        String[] wordsInMessage = getTweetMessageFrom(message).split("\\s");
        //TODO: figure out the unique moods in this message and return as CSV
        String moodsAsCsv = Stream.of(wordsInMessage)
                               .distinct()
                               .map(String::toLowerCase)
                               .map(WORD_TO_MOOD::get)
                               .filter(mood -> mood != null)
                               .distinct()
                               .map(Mood::name)
                               .collect(Collectors.joining(","));

        return moodsAsCsv;
    }
}
