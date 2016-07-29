package com.mechanitis.demo.sense.mood;

import java.util.stream.Stream;

@FunctionalInterface
public interface Analyser {

    String analyseMood(String fullMessage);

    default String analyseMood(String fullMessage, Analyser analyser) {
        return analyser.analyseMood(fullMessage);
    }

    default long countHappyWords(String[] words) {
        return Stream.of(words)
                     .filter(Moods.HAPPY_WORDS::contains)
                     .count();
    }
}
