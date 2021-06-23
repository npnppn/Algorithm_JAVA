package a0623;

import java.util.*;
import java.io.*;

public class Main_1302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			if (map.containsKey(s)) { // 기존에 있으면 숫자 1씩 증가
				map.put(s, map.get(s) + 1);
			} else { // 처음 나오는거면 1
				map.put(s, 1);
			}

			if (map.get(s) > max) {
				max = map.get(s);
			}
		}

		ArrayList<String> list = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) == max) {
				list.add(key);
			}

		}
		Collections.sort(list);
		System.out.println(list.get(0));

	}

}
