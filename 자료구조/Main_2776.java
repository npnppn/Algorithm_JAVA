package data_structure;

import java.io.*;
import java.util.*;

public class Main_2776 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			Set<Integer> first = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				first.add(Integer.parseInt(st.nextToken()));
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (first.contains(num)) {
					sb.append("1\n");

				} else {
					sb.append("0\n");
				}

			}
			

		}
		System.out.println(sb.toString());

	}

}
