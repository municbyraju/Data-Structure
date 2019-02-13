package org.java.ds.basic;

import java.util.Arrays;

public class ArrayListImp<T> implements IList<T>{
	
	T[] arra;
	int length, capacity;
	
	@SuppressWarnings("unchecked")
	public ArrayListImp(int size) {
		arra = (T[]) new Object[size];
		capacity = size;
		
	}

	@Override
	public T add(T t) {
		if(length==capacity) {
			arra = Arrays.copyOf(arra, capacity*2);
			capacity *=2;
			arra[length++]=t;
			return t;
		}
		arra[length++]=t;
		return t;
	}

	@Override
	public T add(int index, T t) {
		if(index == capacity) {
			arra = Arrays.copyOf(arra, capacity*2);
			capacity *=2;
			arra[index]=t;
			length++;
		}else if(index>capacity) {
			throw new ArrayIndexOutOfBoundsException();
		}else {
			if(index<length) {
				for(int x=length;x>=index;x--) {
					if(x==index) {
						arra[x] = t;
						break;
					}
					arra[x] = arra[x-1];
					
				}
				length++;
			}else if(index+1==length) {
				arra[length++]=t;
			}else {
				throw new IndexOutOfBoundsException();
			}
			
			
		}
		
		return t;
	}

	@Override
	public T get(int index) {
		if(index>=capacity) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return arra[index];
	}

	@Override
	public T remove(T t) {
		for(int i=0;i<length;i++) {
			if(arra[i]==t) {
				remove(i);
			}
		}
		return t;
	}

	@Override
	public T remove(int index) {
		if(index >= capacity) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(index<length) {
			for(int start=index;start<length;start++) {
				if(start+1==length) {
					arra[start+1]=null;
					length--;
					if(length<capacity/2) {
						arra = Arrays.copyOf(arra, capacity/2);
						capacity /=2;
					}
					
					break;
				}
				arra[start]=arra[start+1];
			}
			
		}
		
		
		return null;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public int capacity() {
		return capacity;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<length;i++) {
			sb.append(arra[i]+", ");
		}
		sb.replace(sb.lastIndexOf(", "), sb.length(), "");
		sb.append("]");
		return sb.toString();
	}

}
