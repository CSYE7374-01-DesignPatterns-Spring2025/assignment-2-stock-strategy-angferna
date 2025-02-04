package edu.neu.csye7374;

public class BearMarketStrategy implements StockStrategy {

	@Override
    public double computeNewPrice(double currentPrice, double bid) {
        return currentPrice - (1+(bid * 0.5)); // Slower growth or mild decrease
    }

}
