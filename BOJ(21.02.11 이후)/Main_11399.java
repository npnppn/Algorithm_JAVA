package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 오름차순 정렬, 1 2 3 3 4
		//System.out.println(Arrays.toString(arr));
		int sum = 0;
		for (int i = 0; i < N; i++) {//N번 반복할거임
			for (int j = 0; j <= i; j++) { //첫번째는 인덱스1, 두번째는 인덱스 1+ 인덱스2, ... 이런식
				sum += arr[j];
			}
		}
		System.out.println(sum);

	}

}
