package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] tmp = new int[3];

		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (i < 100)
				count++; // 예시에서 1에서 99까지는 한수로 봄
			else {
				int a = i / 100; //백의자리
				int b = (i % 100) / 10; //십의자리
				int c = (i % 100) % 10; //일의자리
				if (a - b == b - c) //각 자리 차이 같으면 한수!
					count++;
			}
		}

		System.out.println(count);
	}
}