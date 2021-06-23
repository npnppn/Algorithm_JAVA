package a0623;

import java.io.*;
import java.util.*;

public class Main_14425 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			hm.put(s, i + 1); // 해쉬에 넣어둠
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String st = sc.next();
			if (hm.get(st) != null) { // 문자열 없으면 갯수 1씩 추가
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
