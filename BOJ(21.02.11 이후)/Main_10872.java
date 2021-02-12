package ssafy_algo;
import java.util.*;
import java.io.*;

public class Main_10872 {

	public static void main(String[] args) throws Exception, IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int N = Integer.parseInt(br.readLine());
		System.out.println(recursive(N));
	}
	
	public static int recursive(int num) {
		
		if (num <= 1) {
			return 1;
		} else
		return recursive(num-1) * num;
	}

}
