package array;

import java.io.*;
import java.util.*;

//같은 char가 있는거만 빼면 되겠네
public class Main_1919 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String aa = sc.next();
		String bb = sc.next();

		int[] a = new int[26];
		int[] b = new int[26];

		for (int i = 0; i < aa.length(); i++)
			a[aa.charAt(i) - 'a']++;
		for (int i = 0; i < bb.length(); i++)
			b[bb.charAt(i) - 'a']++;

		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			cnt += Math.abs(a[i] - b[i]);
		}
		System.out.println(cnt);

	}

}
