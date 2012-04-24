/*
Question: given a linked list where each node have a next pointer and
random pointer to a node in the list. create a copy of the list.
*/

class RNode {
	int ele;
	RNode next;
	RNode random;
	public RNode( int n) {
		ele = n;
	}
	public int get() {
		return ele;
	}
}

public class CopyRandomList {
	public static void main(String args[]) {
		RNode  n1 = new RNode(1);
		RNode  n2 = new RNode(2);
		RNode  n3 = new RNode(3);
		RNode  n4 = new RNode(4);
		RNode  head = n1;
		n1.next = n2;
		n1.random = n3;
		n2.next = n3;
		n2.random = n1;
		n3.next = n4;
		n3.random = n2;
		n4.next = null;
		n4.random = n2;
		RNode t  = head;
		
		while(t != null) {
			System.out.println(t.ele + " " + t.random.ele);
			t = t.next;
		}
		
		t  = head;
		while(t != null) {
			RNode n = new RNode(t.ele);
			n.next =t.next;
			t.next = n;
			t = n.next;
		}
		
		t  = head;
		while(t != null) {
			t.next.random =t.random.next;
			t = t.next.next;
		}
		RNode head2 = head.next;
		
		t  = head;
		while(t != null) {
			RNode n = t.next;
			
			if(n.next != null) {
				t.next = n.next;
				n.next = n.next.next;
				
			} else { 
				n.next = null;
				t.next = null;
			}
			t = t.next;
		}
		
		t  = head2;
		while(t != null) {
			System.out.println(t.ele + " " + t.random.ele);
			t = t.next;
		}
	}

}
