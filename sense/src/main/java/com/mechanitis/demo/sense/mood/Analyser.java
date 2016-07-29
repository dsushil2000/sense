package com.mechanitis.demo.sense.mood;

@FunctionalInterface
public interface Analyser {

    String analyseMood(String fullMessage);

}
