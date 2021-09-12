package string;

import java.io.*;
import java.util.*;

public class Main_4358 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int cnt = 0; // �� ����
		String s = br.readLine();
		while (true) {
			map.put(s, map.getOrDefault(s, 0) + 1);
			cnt++;
			s = br.readLine();
			if(s == null || s.length() == 0) {
				break;
			}
		}
		// System.out.println(cnt);

		//Ű�� ���� ������ �迭�� ����� ����� �߰��Ұ���
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		// System.out.println(Arrays.toString(keys));

		StringBuilder sb = new StringBuilder();
		for (Object key : keys) {
			String keyString = (String) key;
			int keyCount = map.get(keyString);

			double percent = ((double) keyCount / (double) cnt) * 100;
			sb.append(keyString + " " + String.format("%.4f", percent) + "\n");
		}
		System.out.println(sb);

	}

}
