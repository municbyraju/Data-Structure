package org.java.ds.linkedlist;


public class DoubleLinkedList<T> {
	
	Node<T> head;
	Node<T> tail;
	
	static class Node<T>{
		T data;
		Node<T> next;
		Node<T> previous;
		
		public Node(T t) {
			data = t;
			
		}
	}
	
	public void add(T t) {
		Node<T> new_Node = new Node<>(t);
		if(null==head) {
			head = new_Node;
			tail = new_Node;
		}else {
			tail.next = new_Node;
			new_Node.previous = tail;
			tail = tail.next;
		}
	}
	
	public void add(int index, T t) {
		Node<T> new_Node = new Node<>(t);
		if(0==index) {
			new_Node.next = head;
			head.previous = new_Node;
			head=head.previous;
		}else {
			int count=1;
			Node<T> last = head.next;
			while(last!=null) {
				if(count==index) {
					Node<T> temp = last.previous;
					new_Node.previous = temp;
					temp.next=new_Node;
					new_Node.next = last;
					last.previous = new_Node;
				}
				last=last.next;
				++count;
			}
		}
	}
	
	public T get(int index) {
		if(0==index) {
			return head.data;
		}else {
			Node<T> last=head.next;
			int count=1;
			while(last!=null) {
				if(count==index) {
					return last.data;
				}
				++count;
				last = last.next;
				
			}
		}
		return null;
	}
	
	public void remove(int index) {
		if(0==index) {
			Node<T> temp=head.next;
			temp.previous = null;
			head=temp;
		}else {
			Node<T> last=head.next;
			int count=1;
			while(last!=null) {
				if(count==index) {
					Node<T> temp=last.previous;
					temp.next=last.next;
					last.next.previous = temp;
					break;
				}
				++count;
				last=last.next;
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
		DoubleLinkedList<Integer> ll = new DoubleLinkedList<>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(2, 100);
		ll.add(2, 120);
		System.out.println(ll.toString());
		ll.remove(2);
		System.out.println("Linked list element 2: value :"+ll.get(2));
	}
}
