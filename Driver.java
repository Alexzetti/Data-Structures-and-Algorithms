
public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("\n\nStack:");
		ListStack stack = new ListStack();
		
		for(int a = 1; a <= 10; a++)
			stack.push(a);
		System.out.println("Size: "+stack.size()+"   Full: "+stack);
		stack.push(11);
		System.out.println("Size: "+stack.size()+"   Push: "+stack);
		stack.pop();
		System.out.println("Size: "+stack.size()+"   Pop:  "+stack);
		
		
		System.out.println("\n\nQueue:");
		ListQueue queue = new ListQueue();
		
		for(int b = 1; b <= 10; b++)
			queue.enqueue(b);
		
		System.out.println("Size: "+queue.size()+"   Full:    "+queue);
		queue.enqueue(11);
		System.out.println("Size: "+queue.size()+"   Enqueue: "+queue);
		queue.dequeue();
		System.out.println("Size: "+queue.size()+"   Dequeue: "+queue);
		
		
		System.out.println("\n\nDeque:");
		ListDeque deque = new ListDeque();
		
		for(int c = 1; c <= 10; c++)
			deque.addFirst(c);
		
		System.out.println("Size: "+deque.size()+"   Full:   "+deque);
		deque.addFirst(11);
		System.out.println("Size: "+deque.size()+"   Add:    "+deque);
		deque.removeLast();
		System.out.println("Size: "+deque.size()+"   Remove: "+deque);
	}
}
