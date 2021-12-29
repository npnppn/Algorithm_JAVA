package class3;

import java.io.*;
import java.util.*;

//hashset대신 treeset을 쓰면 정렬 안해도되니까 이게 낫겠다!
public class Main_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		TreeSet<String> hs = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			hs.add(s);
		}

		TreeSet<String> hs2 = new TreeSet<>();
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (hs.contains(s)) {
				hs2.add(s);
			}
		}

		System.out.println(hs2.size());
		for (String s : hs2) {
			System.out.println(s);
		}

	}

}
