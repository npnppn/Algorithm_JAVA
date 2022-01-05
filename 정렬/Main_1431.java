package sort;

import java.io.*;
import java.util.*;

public class Main_1431 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}

		Arrays.sort(s, new Comparator<String>() {
			public int compare(String a, String b) {
				if (a.length() < b.length())
					return -1;
				else if (a.length() == b.length()) {
					int sum1 = 0;
					int sum2 = 0;
					for (int i = 0; i < a.length(); i++) {
						if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
							sum1 += a.charAt(i) - '0';
						}
						if (b.charAt(i) >= '0' && b.charAt(i) <= '9') {
							sum2 += b.charAt(i) - '0';
						}
					}
					if (sum1 == sum2) {
						return a.compareTo(b);
					} else {
						return Integer.compare(sum1, sum2);
					}

				} else {
					return 1;
				}
			}

		});

		for (String i : s) {
			System.out.println(i);
		}
	}

}
