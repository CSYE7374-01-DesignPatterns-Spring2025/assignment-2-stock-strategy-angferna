package edu.neu.csye7374;

public class PharmaStock extends Stock {
	private double bid;

//    public PharmaStock(String name, double price, String description) {
//        super(name, price, description);
//    }

	public PharmaStock(String name, double price, String description, StockStrategy strategy) {
		super(name, price, description, strategy);
	}

//	@Override
//	public void setBid(double bid) {
//		this.price += bid * 0.03; // price change logic
//		recordPrice(); // Store new price in history
//	}

}