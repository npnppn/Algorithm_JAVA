package a0623;

import java.io.*;
import java.util.*;

public class Main_1620 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 포켓몬 갯수
		int M = sc.nextInt(); // 문제의 개수

		HashMap<String, Integer> pocket = new HashMap<>();
		String arr[] = new String[N]; // 입력받을 문자열들

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			arr[i] = s;
			pocket.put(s, i + 1); // 도감에 숫자랑 문자를 집어넣어
		}

		for (int i = 0; i < M; i++) {
			if (sc.hasNextInt()) {
				System.out.println(arr[sc.nextInt() - 1]);
			} else {
				System.out.println(pocket.get(sc.next()));
			}
		}

	}

}
