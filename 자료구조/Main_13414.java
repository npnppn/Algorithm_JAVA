package datastructure;

import java.io.*;
import java.util.*;

//중복 제거하고 나서 제한인원으로 자르면 될 듯
public class Main_13414 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		// 문제에서 01234567 이런식 있으니까 숫자형말고 문자형으로해야할듯
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		for (int i = 0; i < l; i++) {
			String value = br.readLine();
			if (hs.contains(value)) {
				hs.remove(value);
			}
			hs.add(value);
		}

		// System.out.println(hs);
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (String s : hs) {
			sb.append(s + "\n");
			cnt++;
			if (cnt == k)
				break;
		}
		System.out.println(sb);
	}

}
