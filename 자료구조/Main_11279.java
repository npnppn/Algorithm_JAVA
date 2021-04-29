package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11279 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1); //우선순위큐 선언
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0) { //숫자 0일경우에
				if (q.isEmpty()) { //큐에 없어?
					System.out.println(0); //그럼 0이지
				} else { //큐에있다면
					System.out.println(q.poll()); //땡겨와
				}
			}
            //숫자 0이 아닐경우엔
            else {
				q.offer(number); //우선순위큐에 넣어
			}

		}
	}
}