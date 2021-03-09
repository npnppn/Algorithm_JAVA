package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		ArrayList<Integer> result = new ArrayList<Integer>(); //리스트 결과 담을 배열
		for (int i=N; i>=N/2;i--) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(N);
			
			int tmp = N;
			int tmp2 = i;
			
			while(true) {
				if(tmp<0) break;
				int tmp3 = tmp;
				
				if(tmp2>=0) arr.add(tmp2);
				
				tmp= tmp2;
				tmp2 = tmp3 - tmp;
			}
			
			if (count<arr.size()) {
				count = arr.size();
				result = arr;
			}
			
		}
		System.out.println(count);
		for(int i: result) System.out.print(i + " ");
	}
}