package com.mechanitis.demo.sense.client.mood;

import java.util.Set;

import static com.mechanitis.demo.sense.client.mood.Mood.HAPPY;
import static com.mechanitis.demo.sense.client.mood.Mood.SAD;

public class Message {
    private final Set<Mood> moods;

    public Message(Set<Mood> moods) {
        this.moods = moods;
    }

    public boolean isHappy() {
        return moods.contains(HAPPY);
    }

    public boolean isSad() {
        return moods.contains(SAD);
    }

    public boolean isConfused() {
        return isHappy() && isSad();
    }
}
