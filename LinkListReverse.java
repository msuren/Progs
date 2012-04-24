import java.util.LinkedList;

class Node {
	int ele;
	Node next;
	public Node( int n) {
		ele = n;
	}
	public int get() {
		return ele;
	}
}
public class LinkListReverse {
	public static void main(String args[]) {
		Node head = new Node(1);

		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		Node t  = head;
		while(t != null) {
			System.out.println(t.ele);
			t = t.next;
		}
		head = reverseList(head);
		t  = head;
		while(t != null) {
			System.out.println(t.ele);
			t = t.next;
		}
	}
	
	public static Node reverseList(Node head) {
		Node node = head;
		Node next = node.next;
		node.next = null;
		while(next != null) {
			Node t = next.next;
			next.next = node;
			node = next;
			next = t;
		}
		return node;
	}
}

