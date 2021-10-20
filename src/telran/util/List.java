package telran.util;

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
	
}
