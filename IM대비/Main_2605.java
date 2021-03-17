package Im_ex;
import java.io.*;
import java.util.*;

public class Main_2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> List = new ArrayList<>();
		List.add(0);
		for(int i=1; i<=n; i++) {
			int num = sc.nextInt();
			List.add(i-num,i);
		}
		for (int i=1; i<=n; i++) {
			System.out.print(List.get(i) + " ");
		}

	}
}
