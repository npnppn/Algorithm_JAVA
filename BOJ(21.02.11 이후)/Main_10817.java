package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_10817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i<3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}

}


/* 무식한 방법
Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int result = 0;
		int max = 0;
		if (a > b && a> c) {
			max = a;
			if( b> c) {
				result = b;
			}
			else result = c;
		}
		
		else if (b > a && b> c) {
			max = b;
			if( a> c) {
				result = a;
			}
			else result = c;
		}
		
		else if (c > a && c> b) {
			max = c;
			if( a> b) {
				result = a;
			}
			else result = b;
		}
		
		else if (a==b && b==c & a==c){
			result = a;
		}
		
		else if (a==b && b>c) {
			result = b;
		}
		
		else if (b==c && c>a) {
			result = c;
		}
		
		else if (a==c && a>b) {
			result = a;
		}
		
		System.out.println(result);
*/