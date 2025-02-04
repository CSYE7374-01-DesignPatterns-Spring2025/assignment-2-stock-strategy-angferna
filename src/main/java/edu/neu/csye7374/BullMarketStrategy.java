package edu.neu.csye7374;

public class BullMarketStrategy implements PriceStrategy {
    
	@Override
    public double calculatePrice(double currentPrice) {
        return currentPrice * 1.25; // 25% increase
    }
}