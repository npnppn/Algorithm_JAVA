package boj;

import java.io.*;
import java.util.*;

//1. 뽑고자 하는 원소가 덱의 중앙에서 끝쪽에 가까운 쪽 방향으로 이동하여 뽑고자 하는 원소가 첫 번째 위치에 갈 때까지 반복
//2. 원소를 뽑음
public class Main_1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int count = 0; // 2, 3번 연산 횟수 누적 합 변수
		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 뽑으려는 숫자 개수

		for (int i = 1; i <= N; i++) {
			deque.offer(i);// 1부터 N까지 덱에 담아둔다.
		}

		int[] seq = new int[M]; // 뽑고자 하는 수 담을 배열
		for (int i = 0; i < M; i++) {
			seq[i] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기
			int target_idx = deque.indexOf(seq[i]);
			int half_idx;
			// 만약 현재 덱의 원소가 짝수 개라면 중간 지점을 현재 덱의 절반 크기에서 -1 감소시킨다.
			// {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면 인덱스는 1

			if (deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			} else {
				half_idx = deque.size() / 2;
			}

			// 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
			if (target_idx <= half_idx) {
				// idx 보다 앞에 있는 원소들을 모두 뒤로 보내버려
				for (int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}
			
			// 중간 지점보다 원소의 위치가 뒤에 있는 경우
			else { 
				// idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보내
				for (int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}

			}
			deque.pollFirst(); // 연산이 끝나면 맨 앞 원소를 삭제
		}

		System.out.println(count);

	}
}