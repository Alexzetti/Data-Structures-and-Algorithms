public class ListQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> data = new SinglyLinkedList<E>();
	
	@Override
	public int size() { 
		return data.size(); 
	}
	
	@Override
	public boolean isEmpty() {
		if(size() == 0)
			return true;
		return false;
	}
	
	@Override
	public E first() {
		if(size() == 0)
			return null;
		return data.first();
	}
	
	@Override
	public void enqueue(E element) {
		data.addLast(element);
	}
	
	@Override
	public E dequeue() {
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