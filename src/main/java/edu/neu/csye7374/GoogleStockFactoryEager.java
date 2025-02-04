package edu.neu.csye7374;

public class GoogleStockFactoryEager extends AbstractFactory {
 
    private GoogleStockFactoryEager() {
 
    }
 
    private static final AbstractFactory instance = new GoogleStockFactoryEager();
 
    public static AbstractFactory getInstance() {
        return instance;
    }
 
    public StockAPI getObject(double price) {
        return new GoogleStock(price);
    }
}