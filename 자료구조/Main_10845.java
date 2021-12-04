package data_structure;

import java.util.*;
import java.io.*;

public class Main_10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		int b = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			if (tmp.contains("push")) {
				st = new StringTokenizer(tmp);
				st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
				b = num;
			} else if (tmp.equals("pop")) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.remove() + "\n");
				}
			} else if (tmp.equals("size")) {
				sb.append(q.size() + "\n");
			} else if (tmp.equals("empty")) {
				if (q.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (tmp.equals("front")) {
				if (q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(q.peek() + "\n");
			} else {
				if (q.isEmpty())
					sb.append("-1\n");
				else
					sb.append(b + "\n");
			}
		}
		System.out.println(sb);

	}

}
