package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1655 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 외치는 정수갯수

		PriorityQueue<Integer> minheap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if (i % 2 == 0) { //짝수개면 maxheap에 추가
				maxheap.add(number);
			} else { //아니면 minheap에 추가
				minheap.add(number);
			}
			
			//이제 최대힙의 원소와 최소힙 원소를 비교해보는 작업 반복
			if (!maxheap.isEmpty() && !minheap.isEmpty()) {
				if (maxheap.peek() > minheap.peek()) {
					maxheap.add(minheap.poll());//결국 핵심은 maxheap에 위치한 값이 중간 값이 되도록.
					minheap.add(maxheap.poll());
				}
			}
			sb.append(maxheap.peek() + "\n");
			
		}
		System.out.print(sb);
	}
}