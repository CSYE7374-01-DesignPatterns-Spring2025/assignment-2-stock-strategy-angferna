package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI implements Tradable{

    private String name;

    private double price;

    private String description;

    private int metric;

    protected List<Double> prevPrices = new ArrayList<>();

    public StockAPI() {
        super();
    }

    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
    	this.price = Math.round(price * 100.0) / 100.0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void init(double price) {
        prevPrices.add(price);
    }

    @Override
    public void setBid(double bid) {
        prevPrices.add(bid);
        double newPrice = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum())/prevPrices.size();
        StockMarket.getInstance().updatePrice(this, newPrice);
    }

    @Override
    public int getMetric() {
        if (prevPrices.isEmpty()) {
            return 0;
        }

        double mean = prevPrices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double dev = prevPrices.stream()
                .mapToDouble(price -> Math.abs(price - mean))
                .average()
                .orElse(0.0);

        return dev > 0 ? 1 : -1;
    }
    @Override
    public String toString() {
        return "Stock [name: " + name + ", price: " + price + ", description: " + description + ", Metric: " + metric + "]";
    }
}
