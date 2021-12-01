package array;
import java.io.*;
import java.util.*;

public class Main_10807 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for (int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int num = sc.nextInt(); //찾으려는 숫자
		int cnt = 0; //그 숫자의 갯수
		
		for (int i =0; i<n; i++) {
			if (arr[i] == num) cnt++;
		}
		System.out.println(cnt);

	}

}
