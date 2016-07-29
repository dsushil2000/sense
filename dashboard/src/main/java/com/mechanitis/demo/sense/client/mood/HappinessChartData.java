package com.mechanitis.demo.sense.client.mood;

import com.mechanitis.demo.sense.infrastructure.MessageListener;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.time.LocalTime.now;

public class HappinessChartData implements MessageListener<Message> {
    private final XYChart.Series<String, Double> dataSeries = new XYChart.Series<>();
    private final Map<Integer, Integer> minuteToDataPosition = new HashMap<>();

    public HappinessChartData() {
        // TODO: get minute value for right now
        int nowMinute = LocalDateTime.now().getMinute();

        // TODO: create an empty bar for every minute for the next ten minutes
        IntStream.range(nowMinute, nowMinute + 10)
                 .forEach(this::initialiseBarToZero);


        HashSet<Mood> payload = new HashSet<>(Arrays.asList(Mood.HAPPY));

        onMessage(new Message(payload));
    }

    void onMessage(Optional<Message> message) {
        message.ifPresent(tweetMood -> {
            // do something
        });
    }

    @Override
    void onMessage(Message message) {
        if (message != null) {
            // do something
        }
    }

    public XYChart.Series<String, Double> getDataSeries() {
        return dataSeries;
    }

    private void initialiseBarToZero(int minute) {
        dataSeries.getData().add(new Data<>(String.valueOf(minute), 0.0));
        minuteToDataPosition.put(minute, dataSeries.getData().size() - 1);

        final int[] ints = {1, 2, 3, 4, 5};
        for (int i = 0; i < ints.length; i++) {
            doSomething(ints[i]);

        }
    }

    private void doSomething(int anInt) {

    }

}

