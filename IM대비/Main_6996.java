package im;
//6분걸림.
import java.io.*;
import java.util.*;

public class Main_6996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String first = sc.next(); //앞에꺼
			String second = sc.next(); //뒤에꺼
			char[] firstCh = first.toCharArray(); //char로 하나하나 받아
			char[] secondCh = second.toCharArray();
			
			Arrays.sort(firstCh);
			Arrays.sort(secondCh);
			
			if(Arrays.equals(firstCh, secondCh)) {
				System.out.println(first + " & " + second + " are anagrams.");
			} else {
				System.out.println(first + " & " + second + " are NOT anagrams.");
			}

		}

	}

}
