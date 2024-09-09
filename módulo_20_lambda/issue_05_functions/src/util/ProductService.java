package issue_05_functions.src.util;

import java.util.List;
import java.util.function.Predicate;

import issue_05_functions.src.entities.Product;

public class ProductService {
   
    public double filteredSum(List<issue_05_functions.src.entities.Product> list, Predicate<Product> criteria) {
		double sum = 0.0;
		for (Product p : list) {
			if (criteria.test(p)) {
				sum += p.getPrice();
			}
		}
		return sum;
	}
}



