package array;

import java.io.*;
import java.util.*;

public class Main_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 입력받은 숫자
		String s = Integer.toString(n);
		int[] arr = new int[10];
		
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			if (num == 9) {
				num = 6;
			}
			arr[num]++;
		}
		
		//6과 9는 바꿀수 있음
		arr[6] = (arr[6] / 2) + (arr[6] % 2);
		Arrays.sort(arr);
		System.out.println(arr[9]);

	}

}
