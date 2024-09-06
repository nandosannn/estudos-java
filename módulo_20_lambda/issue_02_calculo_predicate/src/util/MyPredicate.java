package issue_02_calculo_predicate.src.util;

import java.util.function.Predicate;

import entities.Product;

public class MyPredicate implements Predicate<Product>{

    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
    
}
