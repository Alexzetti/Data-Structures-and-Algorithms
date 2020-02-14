
public class ArrayStack<E> implements Stack<E> {

    private final static int DEFAULT_CAPACITY = 1000;

    private int top=-1;
    private E[] data;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        data = (E[]) (new Object[initialCapacity]);
    }

    @Override
    public int size() {
        return top + 1;
    }
	@Override
    public boolean isEmpty() {
        return top == -1;
    }
	@Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }

        data[++top] = e;
    }
	@Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[top];
    }
	@Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E result = data[top];
        data[top] = null;
        top--;
        return result;
    }
	@Override
	public String toString() {
		String print = "( ";
		for(int i = 0; i < size(); i++)
			print+= data[i] + " ";
		print+=")";
		return print;
	}
}
