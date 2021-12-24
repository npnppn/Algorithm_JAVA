package sort;

import java.io.*;
import java.util.*;

public class Main_11931 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Integer num[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num, Collections.reverseOrder());
		for (int i : num) {
			sb.append(i);
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
