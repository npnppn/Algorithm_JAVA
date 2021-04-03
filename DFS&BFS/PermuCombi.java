package com.ssafy.algo;

import java.util.Arrays;

public class PermuCombi {

	/*
	 * nPr ==> 3P2 = 3 * 2 = 6 -----순열----- [1, 2] [1, 3] [2, 1] [2, 3] [3, 1] [3,2]
	 * -----조합----- [1, 2] [1, 3] [2, 3]
	 */

	static int[] num = { 1, 2, 3 }; // num = {1,2,3,4}
	static int N = 2; // N=2, N=3
	static int sCount = 0; // 총 부분집합의 갯수

	// 순열
	private static void makePermutation(int toSelect, int[] selected, boolean[] visited) {
		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toSelect] = num[i];
				makePermutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	// --------------------------------------------------------------------------------------
	// 조합
	private static void makeCombination(int toSelect, int[] selected, int startIdx) {
		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		for (int i = startIdx; i < num.length; i++) {
			selected[toSelect] = num[i];
			makeCombination(toSelect + 1, selected, i + 1);
		}
	}

	// 부분집합
	public static void powerSet(int cnt, boolean[] isSelected) {
		if (cnt == N) {
			sCount++;
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sb.append(num[i] + ",");
				}
			}
			if (sb.length() > 1)
				sb.deleteCharAt(sb.length() - 1);
			sb.append("}");
			System.out.println(sb);
			return;
		}
		// 선택
		isSelected[cnt] = true;
		powerSet(cnt + 1, isSelected);

		// 선택 아닐때
		isSelected[cnt] = false;
		powerSet(cnt + 1, isSelected);
	}

	public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("-----순열-----");
		makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.		
		System.out.println("-----조합-----");
		makeCombination(0, new int[N], 0);

//		3. num으로 구성할 수 있는 모든 부분집합
		System.out.println("----부분집합------");
		powerSet(0, new boolean[num.length]);
	}
}
