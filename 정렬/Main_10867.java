package sort;

import java.io.*;
import java.util.*;

public class Main_10867 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashSet<Integer> s = new HashSet<>();

		for (int i = 0; i < N; i++) {
			s.add(sc.nextInt());
		}

		List<Integer> list = new ArrayList<>(s);
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (int k : list) {
			sb.append(k + " ");
		}
		System.out.println(sb);

	}

}
