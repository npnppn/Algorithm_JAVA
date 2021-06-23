package a0623;

import java.io.*;
import java.util.*;

public class Main_10546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			if (map.get(s) == null) { //비어있으면 1
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1); //이미 있는거면 숫자 증가
			}
		}

		for (int i = 0; i < N - 1; i++) {
			String s = sc.next();
			map.put(s, map.get(s) - 1);
		}

		for (String key : map.keySet()) {
			if (map.get(key) != 0) { //없는거만 슈슉 출력
				System.out.println(key);
			}
		}

	}

}
