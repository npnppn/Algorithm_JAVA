package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2812 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String input = br.readLine();

		char[] arr = input.toCharArray(); //하나하나 나눠
		//System.out.println(Arrays.toString(arr));
		
		Deque<Character> dq = new ArrayDeque<>(); // 1 9 2 4 라 하면 1을 덱에 넣고 그다음에 그 1이랑 9랑 비교하면 9가 크니까 1삭제 후 9로 바꿈.. 이런식으로 계속 비교해가면서 최대값을 남겨. 
		for (int i = 0; i < arr.length; i++) {
			while (k > 0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.removeLast();
				k--;
			}
			dq.addLast(arr[i]);
		}
		while (dq.size() > k) {
			sb.append(dq.removeFirst());
		}
		System.out.println(sb);
	}

}
