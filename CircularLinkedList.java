package org.java.ds.linkedlist;


public class CircularLinkedList<T> {

	Node<T> head;
	Node<T> tail;

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T t) {
			data = t;
		}
	}

	public void add(T t) {
		Node<T> new_Node = new Node<>(t);
		if (null == head) {
			head = new_Node;
			tail = new_Node;
			tail.next = head;
		} else {
			tail.next = new_Node;
			tail = new_Node;
			tail.next = head;
		}
	}

	public void add(int index, T t) {
		Node<T> new_Node = new Node<>(t);
		if (0 == index) {
			new_Node.next = head;
			tail.next = new_Node;
			head = new_Node;
		} else {
			Node<T> last = head.next;
			int count = 1;
			Node<T> previous = head;
			while (last != head) {
				if (count == index) {
					previous.next = new_Node;
					new_Node.next = last;
				}
				++count;
				last = last.next;
				previous = previous.next;
			}
		}
	}

	public T get(int index) {
		if (0 == index) {
			return head.data;
		} else {
			Node<T> last = head.next;
			int count = 1;
			while (last != head) {
				if (count == index) {
					return last.data;
				}
				last = last.next;
				++count;
			}
		}
		return null;
	}
	
	public void remove(int index) {
		if (0 == index) {
			tail.next=head.next;
			head=head.next;
		}else {
			Node<T> last = head.next;
			int count=1;
			Node<T> previous = head;
			while(last!=head) {
				if(count==index) {
					previous.next=last.next;
				}
				++count;
				last = last.next;
				previous = previous.next;
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> last = head.next;
		sb.append("Linked List : [");
		sb.append(head.data);
		while(last!=head) {
			sb.append(", "+last.data);
			last = last.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CircularLinkedList<Integer> ll = new CircularLinkedList<>();
		ll.add(10);
		System.out.println(ll.toString());
		
		ll.add(20);
		ll.add(30);
		ll.add(2, 100);
		ll.add(2, 120);
		System.out.println(ll.toString());
		ll.remove(2);
		System.out.println(ll.toString());
		System.out.println("Linked list element 2: value :"+ll.get(2));
	}

}
