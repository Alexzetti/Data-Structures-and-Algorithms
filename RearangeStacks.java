public class RearangeStacks {
		public static void main(String[] args) {
			ArrayStack R = new ArrayStack();
			R.push(1); R.push(2); R.push(3);
			ArrayStack S = new ArrayStack();
			S.push(4); S.push(5);
			int Ss = S.size();
			ArrayStack T = new ArrayStack();
			T.push(6); T.push(7); T.push(8); T.push(9);
			int Ts = T.size();
			System.out.printf("R: %s\nS: %s\nT: %s\n\n", R, S, T);
			while(S.size() != 0)
				R.push(S.pop());
			System.out.printf("R: %s\nS: %s\nT: %s\n\n", R, S, T);
			while(T.size() != 0)
				R.push(T.pop());
			System.out.printf("R: %s\nS: %s\nT: %s\n\n", R, S, T);
			for(int i = 0; i <Ss+Ts; i++)
				S.push(R.pop());
			System.out.printf("R: %s\nS: %s\nT: %s\n\n", R, S, T);
		}
}