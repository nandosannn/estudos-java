package issue_04_function.src.util;

import java.util.function.Function;

import issue_04_function.src.entities.Product;

public class UpperCaseName implements Function<Product, String> {

    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}