package string;

import java.io.*;
import java.util.*;

public class Main_1769 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		while (true) {
			int sum = 0;
			if (s.length() == 1) {
				break;
			}

			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - '0';
			}
			cnt++;
			s = String.valueOf(sum);

		}
		if (Integer.parseInt(String.valueOf(s)) % 3 == 0) {
			System.out.println(cnt);
			System.out.println("YES");
		} else {
			System.out.println(cnt);
			System.out.println("NO");
		}

	}

}