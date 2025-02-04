package edu.neu.csye7374;

public class BearMarketStrategy implements PriceStrategy {
    
	@Override
    public double calculatePrice(double currentPrice) {
        return currentPrice * 0.75; // 25% decrease
    }
}