package ssafy_algo;
import java.util.*;
import java.io.*;

public class Main_11729 {

	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		sb.append((int) (Math.pow(2, n) - 1)).append('\n');
		hanoi(1, 2, 3, n);
		System.out.println(sb);
	}

	public static void hanoi(int from, int dest, int to, int num) {
		
		if (num == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		hanoi(from, to, dest, num - 1);
		sb.append(from + " " + to + "\n");
		//System.out.println(sb);
		hanoi(dest, from, to, num - 1);
	}
}