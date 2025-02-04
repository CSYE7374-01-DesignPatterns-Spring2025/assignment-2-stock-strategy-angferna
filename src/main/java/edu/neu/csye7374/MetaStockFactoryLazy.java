package edu.neu.csye7374;

public class MetaStockFactoryLazy extends AbstractFactory{
    private MetaStockFactoryLazy() {
 
    }
    
    private static AbstractFactory instance = null;
    
    public static AbstractFactory getInstance() {
        if (instance == null) {
            synchronized (MetaStockFactoryLazy.class) {
    
                instance = new MetaStockFactoryLazy();
    
            }
    
        }
        return instance;
    }
    
    public StockAPI getObject(double price) {
        return new MetaStock(price);
    }
    
}


