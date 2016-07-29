package com.mechanitis.demo.sense.client.mood;

import com.mechanitis.demo.sense.infrastructure.MessageListener;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.math.BigDecimal;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class MoodChartData implements MessageListener<Message> {
    private final PieChart.Data sadPortion = new PieChart.Data("Sad", 0);
    private final PieChart.Data happyPortion = new PieChart.Data("Happy", 0);
    private final PieChart.Data confusedPortion = new PieChart.Data("Errr...", 0);
    private final ObservableList<PieChart.Data> pieChartData = observableArrayList(sadPortion, happyPortion, confusedPortion);

    public ObservableList<PieChart.Data> getPieChartData() {
        return pieChartData;
    }
    BigDecimal finalPrice;

    private void callCalc() {
        InventoryItem inventoryItem = new InventoryItem();
        calc((item, activeDiscounts) -> {
            BigDecimal price = item.getPrice();
            finalPrice = price;
            activeDiscounts.forEach(discount -> finalPrice = finalPrice.subtract(price.multiply(discount.getAsPercentage())));
            return finalPrice;
        });
    }

    private void calc(PriceCalculator priceCalculator){
        priceCalculator.calculatePrice(null, null);
    }

    @Override
    public void onMessage(Message message) {
        incrementPie(message.isHappy(), () -> happyPortion.setPieValue(happyPortion.getPieValue() + 1));
        incrementPie(message.isSad(), () -> sadPortion.setPieValue(sadPortion.getPieValue() + 1));
        incrementPie(message.isConfused(), () -> confusedPortion.setPieValue(confusedPortion.getPieValue() + 1));
    }

    private void incrementPie(boolean criteria, Runnable thingToDo) {
        if (criteria) {
            thingToDo.run();
        }
    }

    interface PriceCalculator {
        BigDecimal calculatePrice(InventoryItem item, List<Discount> activeDiscounts);
    }




    private static class Discount {
        private BigDecimal asPercentage;

        public BigDecimal getAsPercentage() {
            return asPercentage;
        }
    }

    private static class InventoryItem {
        private BigDecimal price;

        public BigDecimal getPrice() {
            return price;
        }
    }
}
