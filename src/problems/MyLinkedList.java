package problems;

/**
 * For LinkedList<E> 
 * get(int index) is O(n) 
 * add(E element) is O(1) 
 * add(int * index, E element) is O(n) 
 * remove(int index) is O(n) 
 * Iterator.remove() is O(1)
 * 
 * <--- main benefit of LinkedList<E> ListIterator.add(E element) is O(1) <---
 * main benefit of LinkedList<E>
 * 
 * For ArrayList<E> get(int index) is O(1) 
 * <--- main benefit of ArrayList<E> * 
 * add(E element) is O(1) amortized, 
 * but O(n) worst-case since the array must be resized and copied add(int index, E element) is O(n - index) amortized, but
 * O(n) worst-case (as above) remove(int index) is O(n - index) (i.e. removing
 * last is O(1)) Iterator.remove() is O(n - index) ListIterator.add(E element)
 * is O(n - index)
 * 
 * @author rance
 * 
 */
public class MyLinkedList {

	class Node {
		public Node nextNode;
		public Node previousNode;
		public Object data;
	}

	protected Node firstNode;
	protected Node lastNode;
	protected int count;

	public MyLinkedList() {
	}
	
	public Object find(int index) {
		if(index > count || index < 1) {
			return null;
		}
		else if(index == 1) {
			return firstNode.data;
		}
		else if(index == count) {
			return lastNode.data;
		}
		else if(index == 2) {
			return firstNode.nextNode.data;
		}
		else if(index == count - 1) {
			return lastNode.previousNode.data;
		}
			
		int i = 2;
		Node currNode = firstNode.nextNode;
		while(i < index) {
			currNode = currNode.nextNode;
			i++;
		}
		return currNode.data;
	}

	/**
	 * Add object to front of list
	 * 
	 * @param obj
	 */
	public void pushFirst(Object obj) {
		if (firstNode == null) {
			lastNode = firstNode = new Node();
		} else {
			Node tempNode = firstNode;
			firstNode = new Node();
			tempNode.previousNode = firstNode;
			firstNode.nextNode = tempNode;
		}
		firstNode.data = obj;
		count++;
	}

	/**
	 * Add node to end of list
	 * 
	 * @param obj
	 */
	public void push(Object obj) {

		if (firstNode == null) {
			lastNode = firstNode = new Node();
		} else {
			Node tempNode = new Node();
			tempNode.previousNode = lastNode;
			lastNode.nextNode = tempNode;
			lastNode = tempNode;
		}
		lastNode.data = obj;
		count++;
	}

	/**
	 * remove node from end of list
	 */
	public void pop() {
		if (lastNode == null)
			return;
		else if (count == 1) {
			firstNode = lastNode = null;
		} else {
			lastNode = lastNode.previousNode;
			if (lastNode != null) {
				lastNode.nextNode = null;
			}
		}
		count--;
	}

	/**
	 * remove head
	 */
	public void popFirst() {
		if (firstNode == null)
			return;
		else if (count == 1) {
			firstNode = lastNode = null;
		} else {
			firstNode.data = null;
			firstNode = firstNode.nextNode;
		}
		count--;
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();
		list.push(new Integer(2));
		list.push(new Integer(3));
		list.pushFirst(new Integer(1));
		list.pushFirst(new Integer(0));

		for (Node x = list.firstNode; x != null; x = x.nextNode) {
			System.out.println("data value: " + x.data.toString());
		}
		System.out.println("------------------");

		//list.popFirst();
		//list.pop();

		//list.pop();
		//list.pop();
		//list.pop();

		for (Node x = list.firstNode; x != null; x = x.nextNode) {
			System.out.println("data value: " + x.data.toString());
		}
		System.out.println("size: " + list.size());
		System.out.println("find: " + list.find(0));
		System.out.println("find: " + list.find(5));
	}
}
