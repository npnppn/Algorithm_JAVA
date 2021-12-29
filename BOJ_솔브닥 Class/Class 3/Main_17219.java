package class3;

import java.io.*;
import java.util.*;

//해시맵으로 저장해서 키를 불러오면 되겠다!
public class Main_17219 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String s1 = str.nextToken();
			String s2 = str.nextToken();
			hm.put(s1, s2);

		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (hm.containsKey(s)) {
				System.out.println(hm.get(s));
			}
		}
	}

}
