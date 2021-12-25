import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] S = str.split("");
		String[] sum = S;
        
		for (int i = 0; i < S.length; i++) {
			for (int j = i + 1; j < S.length; j++) {
				sum[i] += S[j];
			}
		}

		Arrays.sort(sum);
		for (int i = 0; i < sum.length; i++) {
			System.out.println(sum[i]);
		}
	}

}
