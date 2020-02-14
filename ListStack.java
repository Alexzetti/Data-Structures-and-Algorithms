
public class ListStack<E> implements Stack<E> {

	private SinglyLinkedList<E> data = new SinglyLinkedList<E>();
	
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}

	@Override
	public E top() {
		if(size() == 0) 
			return null;
		return data.first();
	}

	@Override
	public void push(E element) {
		data.addFirst(element);
	}

	@Override
	public E pop() {
		if(size() == 0) 
			return null;
		return data.removeFirst();
	}
	
	@Override
	public String toString() {
		String print = "( ";
		SinglyLinkedList.Node<E> node = data.getHead();
		while(node != null) {
			print += node.getElement() + " ";
			node = node.getNext();
		}
		print += ")";
		return print;
	}

}
