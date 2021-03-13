package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_14696 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총 라운드 수
		
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int[] arr1 = new int[5]; // a가 뽑은 그림들 담을 배열
			for (int j = 0; j < a; j++) {
				arr1[sc.nextInt()]++;
			}
			
			int b = sc.nextInt();
			int[] arr2 = new int[5]; // b가 뽑은 그림들 담을 배열
			for (int j = 0; j < b; j++) {
				arr2[sc.nextInt()]++;
			}
			
			//배열 이제 비교해볼거임 
			boolean flag = false;
			for (int j = 4; j > 0; j--) {
				// 4의 개수부터 체크
				if (arr1[j] > arr2[j]) {
					System.out.println("A");
					break;
				}
				
				else if (arr1[j] < arr2[j]) {
					System.out.println("B");
					break;
				}

				if ((arr1[j] == arr2[j]) && j == 1)
					flag = true;
			}

			// 같은 경우에는
			if (flag) System.out.println("D");
			
		}

	}

}