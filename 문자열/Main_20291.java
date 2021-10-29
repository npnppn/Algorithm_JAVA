package string;

import java.io.*;
import java.util.*;

public class Main_20291 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> hm = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '.') {
					String answer = s.substring(j + 1);

					if (hm.containsKey(answer)) {
						hm.put(answer, hm.get(answer) + 1);
					} else {
						hm.put(answer, 1);
					}

				}
			}
		}
		// System.out.println(hm);
		for (String key : hm.keySet()) {
			System.out.println(key + " " + hm.get(key));
		}

	}

}
