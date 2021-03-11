package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생수
		ArrayList<Integer> List = new ArrayList<>();
		List.add(0);

		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			List.add(i-num, i);
		}
		List.remove(0);
		for(int i:List) {
			System.out.printf(i + " ");
		}


	}

}
