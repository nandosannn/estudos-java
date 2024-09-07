package issue_03_consumer.src.util;

import java.util.function.Consumer;

import issue_03_consumer.src.entities.*;

public class PriceUpdate implements Consumer<Product>{

    @Override
    public void accept(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }

   
    
}
