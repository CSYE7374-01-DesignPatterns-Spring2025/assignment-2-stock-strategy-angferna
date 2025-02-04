package edu.neu.csye7374;

public class GoogleStockFactory extends AbstractFactory {
    @Override
    public StockAPI getObject(double price) {
        return new GoogleStock(price);
    }
}
