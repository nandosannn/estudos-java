package issue_02_predicate.src.util;

import java.util.function.Predicate;

import issue_02_predicate.src.entities.*;

public class MyPredicate implements Predicate<Product>{

    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
    
}
