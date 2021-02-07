package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D3_1208 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input_Solution_D3_1208.txt"));
		Scanner s = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int Dump = s.nextInt(); // 덤프 횟수
			
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = s.nextInt(); // 상자의 높이값
			}
			Arrays.sort(box); // 상자 배열 오름차순으로 정렬
			int first = 0; // 상자 배열의 첫번째
			int last = 99; // 상자 배열의 마지막

			while (true) {
				box[first]++;
				box[last]--;
				Dump--;
				Arrays.sort(box);
				if (Dump == 0) //덤프 횟수 마쳤으면 종료
					break;
			}

			System.out.println("#" + tc + " " + (box[99] - box[0]));
		}
		s.close();
	}
}