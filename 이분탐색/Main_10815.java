package binary_search;

import java.io.*;
import java.util.*;

public class Main_10815 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<Integer> card = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			card.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(card.contains(num)) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}

		}
		System.out.println(sb);
	}

}
