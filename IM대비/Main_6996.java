import java.io.*;
import java.util.*;

public class Main_6996 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String a = sc.next(); //공백 앞
			String b = sc.next(); //공백 뒤
			
			char[] arr1 = a.toCharArray(); //하나하나 배열로
			char[] arr2 = b.toCharArray(); //하나하나 배열로
			
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			//같으면 에너그램
			if (Arrays.equals(arr1, arr2)) {
				System.out.println(a + " & " + b + " are anagrams.");
			} else { //다르면 에너그램 아님
				System.out.println(a + " & " + b + " are NOT anagrams." );
			}
		}
		
	}

}
