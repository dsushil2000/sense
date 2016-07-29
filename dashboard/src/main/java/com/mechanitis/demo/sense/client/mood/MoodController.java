package com.mechanitis.demo.sense.client.mood;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.util.HashSet;

public class MoodController {
    @FXML private PieChart overallMood;

    public void setData(MoodChartData data) {
        overallMood.setData(data.getPieChartData());
    }

    private void someMethod(HashSet<Mood> payload) {
        onMessage(new Message(payload));
    }

    void onMessage(Message message) {
        if (message != null) {
            // do something
        }
    }

}
