package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int res[] = new int[42];
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt() % 42 ;
			res[arr[i]++]++;
		}
		//System.out.println(Arrays.toString(res));
		for (int i =0 ; i<42; i++) {
			if (res[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
