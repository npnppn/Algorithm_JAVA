package data_structure;

import java.io.*;
import java.util.*;

public class Main_3986 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> st = new Stack<>();
			st.push(s.charAt(0));

			for (int k = 1; k < s.length(); k++) {
				char now = s.charAt(k);
				if (!st.isEmpty()) {
					char pre = st.peek();
					if (pre == now) {
						st.pop();
						continue;
					}
				}
				st.push(s.charAt(k));
			}

			if (st.isEmpty()) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}

}
