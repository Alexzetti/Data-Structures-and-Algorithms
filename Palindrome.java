import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String repeat = "Y";
		while(repeat.equals("Y")) {
			System.out.print("Enter a word: ");
			String word = ip.next();
			if(isPalindrome(word))
				System.out.println(word+" is a palindrome");
			else
				System.out.println(word+" is not a palindrome");
			System.out.print("Do you want to test another word? (Y/N): ");
			repeat = ip.next();
		}
	}
	
	public static boolean isPalindrome(String str) {
		char[] word = str.toCharArray();
		ListQueue reverse = new ListQueue();
		for(int a = word.length-1; a > -1; a--)
			reverse.enqueue(word[a]);
		for(int b = 0; b < word.length; b++) {
			if(word[b] != (char) reverse.dequeue())
				return false;
		}
		return true;
	}
}