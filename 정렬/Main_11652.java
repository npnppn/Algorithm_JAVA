package sort;

import java.io.*;
import java.util.*;

//카드의 갯수와 적힌 숫자를 봐야하니 인덱스 잘 확인 할 것 !
public class Main_11652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Long[] arr = new Long[n];

		// 적힌숫자, 갯수로 해쉬맵 생성
		HashMap<Long, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		int max = Integer.MIN_VALUE;

		// 최대로 나온 갯수를 찾아놓고
		for (int i : map.values()) {
			max = Math.max(max, i);
		}

		ArrayList<Long> list = new ArrayList<Long>();
		// 그 최대로 나온 갯수의 키를 구하자
		for (Map.Entry<Long, Integer> val : map.entrySet()) {
			if (val.getValue() == max)
				list.add(val.getKey());
		}
		// System.out.println(list);
		Collections.sort(list);
		System.out.println(list.get(0));

	}

}
