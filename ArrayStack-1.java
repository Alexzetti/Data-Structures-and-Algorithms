public class ArrayStack<E> implements Stack<E> {
	
	private static final int DEFAULT_CAPACITY = 1000;
	
	private int top = -1;
	
	private E[] data;
	
	public ArrayStack() { this(DEFAULT_CAPACITY); }
	
	public ArrayStack(int capacity) {
		data = (E[]) (new Object[capacity]);
	}
	@Override
	public int size() { return top + 1; }
	@Override
	public boolean isEmpty() { return top == -1; }
	@Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[top];
    }
	@Override
    public void push(E e) {
        if (size() == data.length) {
			E[] temp = data;
			data = (E[]) (new Object[data.length*2]);
			for(int i = 0; i < temp.length; i++)
				data[i] = temp[i];
			System.out.println("Re-Sized  -  "+data.length);
        }

        data[++top] = e;
    }
	@Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E toreturn = data[top];
        data[top] = null;
        top--;
        return toreturn;
    }
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for(int i = 0; i < size(); i++) {
			sb.append(data[i]+"");
			if(i != size()-1)
				sb.append(", ");
		}
		sb.append(" ]");
		return sb.toString();
	}
}