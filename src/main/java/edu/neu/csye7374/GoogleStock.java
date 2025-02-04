package edu.neu.csye7374;

public class GoogleStock extends StockAPI{
	public PriceStrategy priceStrategy;

    public GoogleStock(double price) {
        super("Google", price, "Software Engineering Company");
    }
    
    public GoogleStock(double price, PriceStrategy strategy) {
        super("Google", price, "Software Engineering Company");
        this.priceStrategy = strategy;
    }
    
    public void setPriceStrategy(PriceStrategy strategy) {
        this.priceStrategy = strategy;
    }
    
    public void updatePrice() {
        if (this.priceStrategy == null) {
            throw new IllegalStateException("Price Strategy is not set");
        }
        this.setPrice(priceStrategy.calculatePrice(this.getPrice()));
    }

    @Override
    public int getMetric() {
        double mean = this.prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum() / this.prevPrices.size();
        double dev = 0.0;
        for(double num : this.prevPrices) {
            dev += mean - num/3;
        }
        dev = dev / this.prevPrices.size();
        return dev > 0.0 ? 1 : -1;
    }

    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }
}
