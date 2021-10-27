package telran.util;

import java.util.function.Predicate;

public class RetainAllPredicate<T> implements Predicate<T> {
List<T> list;

	public RetainAllPredicate(List<T> list) {
	this.list = list;
}

	@Override
	public boolean test(T t) {
		
		return !list.contains(t);
	}

}
