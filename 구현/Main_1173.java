package baekjoon;

import java.io.*;
import java.util.*;

//온동이면 1분후 맥박 X+T
//X+T<=M 일때만 운동가능
//휴식이면 1분후 맥박 X-R
//X-R<m이면 맥박은 m

public class Main_1173 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 운동하려는 총 시간
		int m = sc.nextInt(); // 초기맥박
		int M = sc.nextInt(); // 최대 맥박
		int T = sc.nextInt(); // 증가하는 맥박
		int R = sc.nextInt(); // 감소하는 맥박
		int min = m; // 하한선 정해줌
		int cnt = 0; // 운동하는 갯수 하나씩 셀거
		int total = 0; // 전체시간

		while (true) {
			if (cnt == N) { // 운동갯수가 N번 되면 이제 종료함
				break;
			}

			// 운동 가능하면
			if (m + T <= M) {
				m = m + T; // 맥박수 요렇게 되고
				cnt++; // 필요한 시간++
				total++;
			}
			// 최대 맥박수 넘어갈때 휴식시간
			else if (m + T > T) {
				total++;
				m = m - R; // 맥박수 요렇게 되고
				if (m < min)// m이하로 떨어지면 안됨
					m = min;
			}
			
			//운동을 할 수 없는경우 -1
			if(min+ T > M && min == m) {
				System.out.println("-1");
				return;
			}

		}
		System.out.println(total); // 전체 시간 출력

	}

}
