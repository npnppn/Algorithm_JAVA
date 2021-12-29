package class3;

import java.io.*;
import java.util.*;

public class Main_1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		HashMap<Integer, String> hm2 = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			hm.put(str, i);
			hm2.put(i, str);
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			//문자일 때
			if (s.charAt(0) <= 'Z' && s.charAt(0) >= 'A') {
				System.out.println(hm.get(s));
			} else { //숫자 일 때
				System.out.println(hm2.get(Integer.parseInt(s)));
			}

		}
	}

}
