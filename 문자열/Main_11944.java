package string;

import java.util.*;
import java.io.*;

public class Main_11944 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1[] = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < str1[0].length(); j++) {
				if (M == 0) {
					i = N;
					break;
				}
				sb.append(str1[0].charAt(j));
				M--;
			}
		}
		System.out.println(sb);
	}
}
