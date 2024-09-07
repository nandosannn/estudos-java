package issue_03_function.src.util;

import java.util.function.Function;

import issue_03_function.src.entities.Product;

public class UpperCaseName implements Function<Product, String> {

    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}