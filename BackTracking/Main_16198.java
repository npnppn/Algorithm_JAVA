package backtracking;

import java.io.*;
import java.util.*;

public class Main_16198 {
	static ArrayList<Integer> arr;
	static int n;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new ArrayList<>();
		cnt = 0;
		for (int i = 0; i < n; i++) {
			int n = sc.nextInt();
			arr.add(n);
		}
		dfs(0);
		System.out.println(max);
	}

	static void dfs(int select) {
		if (arr.size() <= 2) {
			max = Math.max(max, select);
			return;
		}

		for (int i = 1; i < arr.size() - 1; i++) {
			int tmp = arr.get(i);
			cnt = arr.get(i - 1) * arr.get(i + 1);
			arr.remove(i);
			dfs(select + cnt);
			arr.add(i, tmp);

		}
	}

}
