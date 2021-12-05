package data_structure;

import java.io.*;
import java.util.*;

public class Main_6198 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Long> st = new Stack<>(); // 높이가 크니까 long으로
		long cnt = 0;

		for (int i = 0; i < n; i++) {
			Long num = Long.parseLong(br.readLine());
			while (!st.isEmpty()) {
				if (st.peek() <= num) {
					st.pop();
				} else
					break;
			}
			cnt += st.size();
			st.push(num);
		}
		System.out.println(cnt);

	}

}
