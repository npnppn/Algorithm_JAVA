package a0705;

import java.io.*;
import java.util.*;

//상민 : 파랑포장지 A초, 지수 : 빨강포장지 B초 / 상민이가 우선순위 / B는 파란색 , R은 빨간색
//선물 포장 시작시간을 큐에 담고나서 선물들의 순서를 부여하면 될듯? 문제를 이해하는데 오래걸려서 어려웠음..

public class Main_17225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 상민이가 선물 하나 포장하는데 걸리는 시간
		int B = sc.nextInt(); // 지수가 포장 시간
		int N = sc.nextInt(); // 어제 가게 손님 수

		Queue<Integer> blue = new LinkedList<Integer>(); // 파란 선물 포장시간 담는 큐
		Queue<Integer> red = new LinkedList<Integer>(); // 빨강 선물 포장시간 담는 큐

		int bluetime = 0;
		int redtime = 0;

		// 주문부터 포장까지 일단!
		for (int tc = 1; tc <= N; tc++) {
			int t = sc.nextInt(); // 가게 오픈 후 t초 후 손님이 주문한거
			char c = sc.next().charAt(0); // 포장지 색깔
			int m = sc.nextInt(); // 주문 선물 갯수

			// 상민이
			if (c == 'B') {
				if (t <= bluetime) // 만약 손님을 받은 시간에 아직까지 포장을 하고 있으면 포장이 끝나는 시간으로 변경 해준다.
					//t = bluetime;
					bluetime += A;

				for (int i = 0; i < m; i++) { // 주문한 선물의 개수만큼 반복
					blue.offer(t); // 포장 시작
					t += A; // 포장 시간 간격으로 증가
					bluetime = t + A; // 마지막 포장이 끝나는 시간! 이게 현재시간 + 선물갯수*포장시간이어야 40점짜리 테케 통과하는듯?
				}
			}

			// 지수
			else {
				if (t <= redtime)
					//t = redtime;
					redtime += B;

				for (int i = 0; i < m; i++) {
					red.offer(t);
					t += B;
					redtime = t + B;
				}
			}
		}

		// System.out.println(red);
		// System.out.println(blue);

		// 포장 끝, 포장한 선물들의 번호 부여
		int cnt = 0; // 시간체크
		int idx = 1; // 선물번호
		ArrayList<Integer> ba = new ArrayList<>();
		ArrayList<Integer> ra = new ArrayList<>();

		while (!blue.isEmpty() || !red.isEmpty()) {
			if (!blue.isEmpty() && cnt == blue.peek()) { // 현재 시간에 상민이 포장을 했으면.
				ba.add(idx++);
				blue.poll();
				if (!blue.isEmpty() && cnt == blue.peek()) // 현재 시간에 상민이 또 포장을 했으면,
					continue;
			}

			else if (!red.isEmpty() && cnt == red.peek()) {
				ra.add(idx++);
				red.poll();
				if (!red.isEmpty() && cnt == red.peek())
					continue;
			}
			cnt++; // 시간 증가
		}

		System.out.println(ba.size()); // 상민이 포장 선물 갯수
		for (int i : ba) {
			System.out.print(i + " "); // 각 번호들
		}
		System.out.println();
		System.out.println(ra.size()); // 지수 포장 선물 갯수
		for (int i : ra) {
			System.out.print(i + " "); // 각 번호들
		}
	}

}