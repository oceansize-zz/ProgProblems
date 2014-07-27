public class MySinglyLinkedList<T> {
	protected Node<T> head = null;
	protected int count = 0;
	
	public Node<T> getHead() {
		return head;
	}
	
	
	/**
	 * add new head
	 * @param node
	 */
	public void push(Node<T> node) {
		if(node == null) {
			return;
		}
		
		if(head == null) {
			head = node;
		}
		node.setNext(head);
		head = node;
		count++;
	}
	
	/**
	 * Pop head
	 */
	public void pop() {
		if(count == 0) {
			return;
		}
		
		if(count == 1) {
			head = null;
		}
		
		head = head.getNext();
	}

	public class Node<X> {
		protected Node<X> next = null;
		protected X data = null;

		public Node<X> getNext() {
			return this.next;
		}
		
		public void setNext(Node<X> node) {
			this.next = node;
		}

		public X getData() {
			return this.data;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
