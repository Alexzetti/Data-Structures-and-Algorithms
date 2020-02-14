public class ListDeque<E> implements Deque<E> {
	
	private DoublyLinkedList<E> data = new DoublyLinkedList<E>();
	
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
	public E last() {
		if(size() == 0)
			return null;
		return data.last();
	}
	
	@Override
	public void addFirst(E element) {
		data.addFirst(element);
	}
	
	@Override
	public void addLast(E element) {
		data.addLast(element);
	}
	
	@Override
	public E removeFirst() {
		if(size() == 0)
			return null;
		return data.removeFirst();
	}
	
	@Override
	public E removeLast() {
		if(size() == 0)
			return null;
		return data.removeLast();
	}
	
	@Override
	public String toString() {
		String print = "( ";
		DoublyLinkedList.Node<E> node = data.getFirst();
		while(node != data.getLast().getNext()) {
			print += node.getElement() + " ";
			node = node.getNext();
		}
		print += ")";
		return print;
	}
	
}