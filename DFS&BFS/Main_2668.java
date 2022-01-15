package bfsdfs;

import java.io.*;
import java.util.*;

public class Main_2668 {

	static int n, res;
	static ArrayList<Integer> al = new ArrayList<>();
	static boolean[] visited;
	static int[] arr;
	static int value;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			value = i;
			dfs(i);
			visited[i] = false;
		}

		System.out.println(al.size());
		Collections.sort(al);
		for (int i : al) {
			System.out.println(i);
		}
	}

	static void dfs(int i) {
		if (arr[i] == value) {
			al.add(value);
		}

		if (!visited[arr[i]]) {
			visited[arr[i]] = true;
			dfs(arr[i]);
			visited[arr[i]] = false;
		}
	}

}
