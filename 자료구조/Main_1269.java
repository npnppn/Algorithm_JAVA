package data_structure;

import java.io.*;
import java.util.*;

public class Main_1269 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<Integer> first = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		// 집압에 집어넣고 겹치는거만 제거하면 원하는 결과가 나오겠다.
		for (int i = 0; i < N; i++) {
			first.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(first.contains(num)) {
				first.remove(num);
			} else {
				first.add(num);
			}
		}
		int len = first.size();
		System.out.println(len);

	}

}
