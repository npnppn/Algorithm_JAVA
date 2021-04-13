package baekjoon;

import java.util.*;
import java.io.*;

public class Main_2564 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt(); // 가로
		int height = sc.nextInt(); // 세로
		int n = sc.nextInt(); // 상점 수
		int[] pos = new int[n + 1]; // 상점 위치 담을 배열
		for (int i = 0; i <= n; i++) { // 마지막줄은 자기자신 위치니까 <=를 사용했음!
			int dir = sc.nextInt(); // 방향을 의미, 1:북 / 2:남 / 3:서 / 4:동
			int distance = sc.nextInt(); // 거리값을 의미
			
			//모든걸 시계방향 기준으로 이동할 때 거리계산
			switch (dir) {
			case 1: // 상점이 북쪽일땐
				pos[i] = distance;
				break;

			case 2: // 상점이 남쪽일땐
				pos[i] = width + height + width - distance;
				break;

			case 3: // 상점이 서쪽일땐
				pos[i] = width + height + width + height - distance;
				break;

			case 4:
				pos[i] = width + distance;
				break;
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int tmp = Math.abs(pos[n] - pos[i]); //동근이 위치랑 시계방향 거리랑 계산
			
			//시계방향일때랑 반시계방향일때 거리 중 짧은거를 sum에 추가 (참고로 반시계방향일때는 전체 둘레 - 시계방향 하면 됨!)
			if (tmp > width + height) { //반시계 방향일때는
				sum += (2 * (width + height)) - tmp;
			} else { //시계 방향일때는 그대로 총 거리 출력
				sum += tmp;
			}
		}
		System.out.println(sum);

	}

}
