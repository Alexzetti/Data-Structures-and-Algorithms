public class Lab6 {
	public static void main(String []args) {
		
		AList<Integer> list = new AList<>();
		System.out.println("Size: "+list.size());
		for(int i = 1; i <= 10; i++) {
			list.add(i-1, i);
			System.out.println("Size: " + list.size() + "   " + list);
		}
		System.out.println("Adding 30 to end");
		list.add(10,30);
		System.out.println("Size: " + list.size() + "   " + list);
		System.out.println("Adding 10 to front");
		list.add(0,10);
		System.out.println("Size: " + list.size() + "   " + list);
		System.out.println("Adding 50 to index 5");
		list.add(5,50);
		System.out.println("Size: " + list.size() + "   " + list);
		System.out.println("Removing from front");
		list.remove(0);
		System.out.println("Size: " + list.size() + "   " + list);
		System.out.println("Removing from end");
		list.remove(list.size()-1);
		System.out.println("Size: " + list.size() + "   " + list);
		System.out.println("Removing from index 7");
		list.remove(7);
		System.out.println("Size: " + list.size() + "   " + list);
		
		System.out.println("\n\n\n");
		
		ArrayStack stack = new ArrayStack(10);
		for(int i = 1; i <= 30; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		
	}
}