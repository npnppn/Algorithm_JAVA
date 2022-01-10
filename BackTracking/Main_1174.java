package backtracking;

import java.io.*;
import java.util.*;

public class Main_1174 {

	static int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	static ArrayList<Long> al = new ArrayList<>();

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		al.add((long) 0);
		dfs(0, 0);
		Collections.sort(al);
		
		//2의10승 만큼 만들수 있으니까 이걸 넘어가면 -1
		if (n >= 1024) {
			System.out.println("-1");
		} else {
			System.out.println(al.get(n-1));
		}

	}

	static void dfs(long sum, int start) {
		if (!al.contains(sum)) {
			al.add(sum);
		}
		if (start >= 10)
			return;

		dfs((sum * 10) + num[start], start + 1);
		dfs(sum, start + 1);
	}

}
