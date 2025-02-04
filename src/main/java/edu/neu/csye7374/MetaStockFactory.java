package edu.neu.csye7374;

public class MetaStockFactory extends AbstractFactory{

    @Override
    public StockAPI getObject(double price){
        return new MetaStock(price);
    }
}
