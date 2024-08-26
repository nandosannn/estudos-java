package services;

import java.util.List;

public class CalculationService {

    /*Para que o método compareTo funcione para um tipo T genérico é preciso que o método tenha uma herança da Classe Comparable de um tipo genérico T*/
	public static <T extends Comparable<T>> T max(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalStateException("List can't be empty");
		}
		T max = list.get(0);
		for (T item : list) {
			/*Desse modo é possível usar normalmente o Método compareTo */
            if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}
}