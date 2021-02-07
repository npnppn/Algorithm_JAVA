package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D3_1225 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer tk;

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			tk = new StringTokenizer(br.readLine());
			int num = 1; //1씩 증가하면서 빼주는거

			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) { //큐에 저장함
				queue.offer(Integer.parseInt(tk.nextToken()));
			}

			while (true) {
				int cnt = queue.poll() - num++;
				if (cnt <= 0) {
					queue.offer(0); //큐에 객체저장
					break;
				}
				queue.offer(cnt);
				if (num == 6) {
					num = 1;
				}
			}

			//큐 잘 나왔나 확인
			//System.out.println(queue);
			StringBuilder sb = new StringBuilder("#");
			sb.append(tc);
			sb.append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			System.out.println(sb);
		}
	}

}
