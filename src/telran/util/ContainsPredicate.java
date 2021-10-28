package telran.util;

import java.util.function.Predicate;

public class ContainsPredicate<T> implements Predicate<T> {
T pattern;

	public ContainsPredicate(T pattern) {
	this.pattern = pattern;
}

	@Override
	public boolean test(T t) {
		
		return t.equals(pattern);
	}

}
