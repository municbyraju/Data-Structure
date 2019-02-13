/**
 * 
 */
package org.java.ds.basic;

/**
 * @author munichandramoulimai
 *
 */
public interface IList<T> {

	T add(T t);

	T add(int index, T t);

	T get(int index);

	T remove(T t);

	T remove(int index);

	int length();

	int capacity();
}
