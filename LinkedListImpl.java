package org.java.ds.linkedlist;


public class LinkedListImpl<T>{
	Node<T> head;
	Node<T> tail;
	int length;
	static class Node<T>{
		
		T data;
		Node<T> next;
		
		public Node(T t) {
			data = t;
			next = null;
		}
		
	}
	
	
	public void add(T t) {
		Node<T> new_Node = new Node<>(t);
		if(null == head) {
			head = new_Node;
			tail = new_Node;
			++length;
		}else {
			tail.next = new_Node;
			tail = tail.next;
			++length;
		}
	}
	
	public void add(int index,T t) {
		Node<T> new_Node = new Node<>(t);
		if(0==index) {
			new_Node.next = head;
			head = new_Node;
			++length;
		}else {
			Node<T> last = head.next;
			Node<T> previous = head;
			int count =1;
			while(last !=null) {
				if(count==index) {
					new_Node.next = last;
					previous.next = new_Node;
					++length;
					break;
				}
				last = last.next;
				previous = previous.next;
				++count;
			}
		}
	}
	
	public T get(int index) {
		if(0==index) {
			return head.data;
		}else {
			Node<T> last = head.next;
			int count=1;
			while(last!=null) {
				if(count==index) {
					return last.data;
				}
				last=last.next;
				++count;
				
			}
		}
		return null;
	}
	
	public void remove(int index,T t) {
		if(0==index) {
			head = head.next;
		}else {
			Node<T> last = head.next;
			int count=1;
			Node<T> previous = head;
			while(last!=null) {
				if(count==index) {
					previous.next = last.next;
					break;
				}
				last = last.next;
				previous = previous.next;
				++count;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> last = head.next;
		sb.append("Linked List : [");
		sb.append(head.data);
		while(last!=null) {
			sb.append(", "+last.data);
			last = last.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LinkedListImpl<Integer> ll = new LinkedListImpl<>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(2, 100);
		ll.add(2, 120);
		System.out.println(ll.toString());
		System.out.println("Linked list element 2: value :"+ll.get(2));
	}

}
