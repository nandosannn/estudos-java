package services;

import java.util.ArrayList;
import java.util.List;

/*Generics: aceitam qualquer tipo de variável e faz a segurança de tipos, ou seja, só aceita um mesmo tipo de variável. */

/*É definida como <T> um tipo qualquer T */
public class PrintService<T> {

	/*A lista pode ser de qualquer tipo desde que todos os elementos sejam desse mesmo tipo */
	private List<T> list = new ArrayList<>();

	/*O método aceita qualquer tipo de atributo */
	public void addValue(T value) {
		list.add(value);
	}

	public T first() {
		if (list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		return list.get(0);
	}

	public void print() {
		System.out.print("[");
		if (!list.isEmpty()) {
			System.out.print(list.get(0));
		}
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", " + list.get(i));
		}
		System.out.println("]");
	}

	/*O tipo genérico é usado para fazer operações que independem do tipo do atributo como trabalhar com métodos void */
}