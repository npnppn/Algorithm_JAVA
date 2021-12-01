package array;

import java.io.*;
import java.util.*;
//아스키코드를 숫자로 바꾸는게 핵심
public class Main_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'a';
			arr[num]++;
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
