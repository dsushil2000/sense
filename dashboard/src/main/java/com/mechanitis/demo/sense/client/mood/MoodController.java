package com.mechanitis.demo.sense.client.mood;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.util.HashSet;
import java.util.Optional;

public class MoodController {
    @FXML private PieChart overallMood;

    public void setData(MoodChartData data) {
        overallMood.setData(data.getPieChartData());
    }

    private void someMethod(HashSet<Mood> payload) {
        onMessage(Optional.of(new Message(payload)));
    }

    void onMessage(Optional<Message> message) {
        message.ifPresent(message1 -> {
            // do something
        });
    }

}
