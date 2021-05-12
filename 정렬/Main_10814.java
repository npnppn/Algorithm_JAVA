package baekjoon;

import java.io.*;
import java.util.*;

public class Main_10814 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[][] s = new String[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i][0] = st.nextToken(); // 나이
			s[i][1] = st.nextToken(); // 이름
		}

		Arrays.sort(s, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); //나이순으로 정렬하면 됨
			}
		});

		for (int i = 0; i < n; i++) {
			System.out.println(s[i][0] + " " + s[i][1]);

		}

	}

}
