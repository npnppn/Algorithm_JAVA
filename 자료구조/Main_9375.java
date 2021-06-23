package a0623;

import java.io.*;
import java.util.*;

public class Main_9375 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				String name = sc.next();
				String type = sc.next();

				if (map.containsKey(type)) {
					map.put(type, map.get(type) + 1);
				} else {
					map.put(type, 1);
				}
			}

			int ans = 1;
			for (int val : map.values())
				ans *= val + 1;
			System.out.println(ans - 1);
		}
	}
}