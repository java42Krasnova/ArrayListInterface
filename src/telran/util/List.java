package telran.util;

import java.util.function.Predicate;

public interface List<T> {
/**
 * adds a given element at end of list
 * @param element
 */
	void  add (T element);
	/**
	 * adds a given element at given index
	 * @param index
	 * @param element
	 * @return true the index is correct, false - incorrect
	 */
	boolean add (int index, T element);
	/**
	 * 
	 * @return amount of all elements in
	 */
	int size ();
	/**
	 * 
	 * @param index
	 * @return reference to element at a given index or null
	 *  if  the index is incorrect if index<0 or index>=size
	 */
	T get(int index);
/**
 * removes element from list at a given index
 * @param index
 * @return reference to being removed element or null if the index is incorrect
 */
	T remove (int index );
	/**
	 * check existence of an object
	 * @param pattern
	 * @return true if there is at least one object equaled to a given pattern^ otherwise - false
	 */
	boolean contains(T pattern);
	/**
	 * 
	 * @param pattern
	 * @return index of the first occurrence of an object equaled to a given pattern, or -1 of no such an object
	 * 
	 */
	int indexOf(T pattern);
	/**
	 * 
	 * @param pattern
	 * @return index of the last occurrence of an object equaled to a given pattern, or -1 of no such an object
	 * 
	 */
	int lastIndexOf(T pattern);
	/**
	 * 
	 * @param predicate
	 * @return true in the case the list contains ate list one object matching a condition of a given predicate
	 */
	boolean contains(Predicate<T> predicate);
	/**
	 * 
	 * @param pattern
	 * @return index of the first occurrence of an object equaled to a given predicate, or -1 of no such an object
	 * 
	 */
	int indexOf(Predicate<T> predicate);
	/**
	 * 
	 * @param pattern
	 * @return index of the last occurrence of an object equaled to a given predicate, or -1 of no such an object
	 * 
	 */
	int lastIndexOf(Predicate<T> predicate);
	/**
	 * removes all objects matching a given predicate if at list one  object has been removed otherwise -false
	 * @param predicate
	 * @return
	 */
	 
	boolean removeIf(Predicate<T> predicate);
	
}
