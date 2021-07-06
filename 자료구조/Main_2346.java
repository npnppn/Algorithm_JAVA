package a0706;

import java.util.*;
import java.io.*;

// 덱을 이용해서 풍선을 터트리면 되는데.. 왼쪽으로 이동할때 조건을 생각못했었다.

class Ballon {
	int idx, number;
	Ballon(int idx, int number) {
		this.idx = idx;
		this.number = number;
	}
}

public class Main_2346 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Deque<Ballon> dq = new ArrayDeque<Ballon>();
		for (int i = 1; i <= N; i++) {
			dq.add(new Ballon(i, sc.nextInt()));
		}

		StringBuilder sb = new StringBuilder();
		while (!dq.isEmpty()) {
			sb.append(dq.getFirst().idx + " ");
			
			int next = dq.poll().number;
			
			if (dq.isEmpty())
				break; //암것도 없으면 끝

			if (next > 0) {
				next -= 1;
				for (int i = 0; i < next; i++) {
					dq.addLast(dq.pollFirst());
				}
			} else {
				// que.poll()로 인해 한 칸 오른쪽으로 가버리는 형태가 되기 때문에 왼쪽으로 이동할 때는 next값 변경하면x
				for (int i = 0; i < Math.abs(next); i++) {
					dq.addFirst(dq.pollLast());
				}
			}
		}
		System.out.println(sb.toString());
	}
}