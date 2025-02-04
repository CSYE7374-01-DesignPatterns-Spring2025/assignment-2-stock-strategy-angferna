package edu.neu.csye7374;

public interface StockStrategy {
	double computeNewPrice(double currentPrice, double bid);
}
