package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D4_1233 {
	static int[] visit;
	static int[][] edge;
	static String[] node;
	static int n;
	static Stack<Integer> st;
	static int flag;

	public static void op(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			if (st.size() < 2) {
				flag = 0;
				return;
			}
			int a = st.pop();
			int b = st.pop();

			if (s.equals("+")) {
				st.push(b + a);
			}
			if (s.equals("-")) {
				st.push(b - a);
			}
			if (s.equals("*")) {
				st.push(b * a);
			}
			if (s.equals("/")) {
				if (a == 0) {
					a = 1;
				}
				st.push(b / a);
			}
		} else {
			st.push(Integer.parseInt(s));
		}
	}

	public static void dfs(int x) {
		if (flag == 0)
			return;
		visit[x] = 1;
		for (int i = 1; i <= n; i++) {
			if (edge[x][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}
		op(node[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			node = new String[n + 1];
			edge = new int[n + 1][n + 1];
			visit = new int[n + 1];
			st = new Stack<>();
			flag = 1;

			for (int i = 1; i <= n; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(tk.nextToken());
				node[i] = tk.nextToken();
				for (int j = 0; j < 2; j++) {
					if (tk.hasMoreTokens()) {
						int to = Integer.parseInt(tk.nextToken());
						edge[from][to] = 1;
					}
				}
			}
			dfs(1);
			if (st.size() < 1)
				flag = 0;

			System.out.println("#" + t + " " + flag);
		}
	}
}