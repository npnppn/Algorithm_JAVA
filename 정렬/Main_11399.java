package ex;
import java.io.*;
import java.util.*;

public class Main_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []arr = new int[N];
		for (int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		for (int i=0; i<N; i++) {
			for (int j=N-i; j>0; j--) {
				//System.out.println(arr[i]);
				sum += arr[i];
			}
			
		}
		System.out.println(sum);

	}

}
