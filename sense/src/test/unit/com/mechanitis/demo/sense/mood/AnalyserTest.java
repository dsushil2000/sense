package com.mechanitis.demo.sense.mood;

import org.junit.Test;

public class AnalyserTest {
    @Test
    public void should() {
        Analyser.countHappyWords(new String[]{"one"});
        Analyser analyser = new Analyser() {
            @Override
            public String analyseMood(String fullMessage) {
                return null;
            }

            @Override
            public String analyseMood(String fullMessage, Analyser analyser) {
                return null;
            }
        };

        analyser.analyseMood(null, null);
    }

}