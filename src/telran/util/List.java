package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

public interface List<T>  extends Iterable<T>{
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
	default boolean contains(T pattern) {
		//O[N] for array and linked list
		return indexOf(pattern)>=0;
	}
	/**
	 * 
	 * @param pattern
	 * @return index of the first occurrence of an object equaled to a given pattern, or -1 of no such an object
	 * 
	 */
	default int indexOf(T pattern) {
		//O[N] 
		return indexOf(new ContainsPredicate<T>(pattern));
	};
	/**
	 * 
	 * @param pattern
	 * @return index of the last occurrence of an object equaled to a given pattern, or -1 of no such an object
	 * 
	 */
	default int lastIndexOf(T pattern) {
		//O[N] 
		return lastIndexOf(new ContainsPredicate<T>(pattern))	;
	}
	/**
	 * 
	 * @param predicate
	 * @return true in the case the list contains ate list one object matching a condition of a given predicate
	 */
	default boolean contains(Predicate<T> predicate) {
		//O[N] 
		return indexOf(predicate)>-1;
	}
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
	
	/**
	 * sorts array of T objects in accordance to the natural order
	 */
	@SuppressWarnings("unchecked")
	default void sort() {
		//O[N* logN] 
		sort((Comparator<T>)Comparator.naturalOrder());
	}
	
	/**
	 * sorts array of T objects in according with a given comparator object comp
	 */
	void sort(Comparator<T> comp);
	/**
	 * remove first occurrence in the list that is equaled to a given pattern
	 * 
	 * @param pattern
	 * @return reference to being  removed object or null if no such object
	 */
	default T remove (T pattern) {
	//
		return remove(indexOf(pattern));
		
	}
	/**
	 * removes all object from "this" list that exists in a given list
	 * @param list
	 * @return true if at least one object has been removed
	 */
	default boolean removeAll(List<T> list)
	{	
		//O[N](need to update remove if for array)
		if(this == list)
		{
			clear();
			return true;
		}
	return removeIf(new RemoveAllPredicate<>(list));	
	}
	/**
	 * removes all object from "this" list that don't exists in a given list
	 * @param list
	 * @return true if at least one object has been removed
	 */
	default boolean retainAll(List<T> list)
	{
	return removeIf(new RemoveAllPredicate<>(list).negate());
	
	}
	/**
	 * searches for pattern in sorted list by given comparator
	 * @param pattern
	 * @param comp
	 * @return the same index as the standart binarySearch in the class array
	 */
	int sortedSearch(T pattern, Comparator<T> comp);
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	@SuppressWarnings("unchecked")
	default int sortedSearch(T pattern) {
		return sortedSearch(pattern, (Comparator<T>)Comparator.naturalOrder());
	}
	/**
	 * remove all elements
	 * after clear all size will be 0;
	 */
	void clear();
	
}
