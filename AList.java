import java.lang.*;

public class AList<E> implements List<E> {
	
	private final static int DEFAULT_CAPACITY = 1000;
	
	private E[] data;
	private int size = 0;
	private int front = 0;
	
	public AList() { this(DEFAULT_CAPACITY); }
	
	public AList(int cap) { data = (E[]) (new Object[cap]); }
	
	@Override
	public int size() { return size; }
	
	@Override
	public boolean isEmpty() { return size() == 0; }
	
	@Override
	public E get(int i) throws IndexOutOfBoundsException { 
		checkIndex(i, size);
		return data[listIndex(i)]; 
	}
	
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException { 
		checkIndex(i, size);
		E tmp = data[i];
		data[i] = e;
		return tmp;
	}
	
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		if(size == data.length)
			throw new IndexOutOfBoundsException("List is full");
		if(i == 0) {
			front = listIndex(-1);
			data[front] = e;
		} else if(i == size)
			data[listIndex(i)] = e;
		else {
			for(int a = size; a >= i; a--)
				data[listIndex(a+1)] = data[listIndex(a)];
			data[listIndex(i)] = e;
		}
		size++;
	}
	
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E removed;
		if(i == 0) {
			removed = data[front];
			data[front] = null;
			front = listIndex(1);
		} else if(i == size-1) {
			int end = listIndex(i);
			removed = data[end];
			data[end] = null;
		} else {
			removed = data[listIndex(i)];
			for(int a = i; a < size-1; a++)
				data[listIndex(a)] = data[listIndex(a+1)];
			data[size-1] = null;
		}
		size--;
		return removed;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for(int i = 0; i < size; i++) {
			sb.append(data[Math.floorMod(front+i, data.length)]);
			if(i != size-1)
				sb.append(", ");
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	private int listIndex(int i) { return Math.floorMod((i + front), data.length); }
	
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if(i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: "+i);
	}
}