package ssafy_algo;
import java.io.*;
import java.util.*;

//큰 로직은 입력받은 N과 count 가 같아질 때 까지 숫자를 1씩 증가시켜 666이 포함되는지 여부를 계속 검사
//조금 비효율적이지만 N의 범위가 10000보다 작으니 괜찮다고 생각

public class Main_1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자 입력받음
		int count = 0;
		int a = 665; 
		while(count!=N) {
			a++; //제일 작은 수는 666
			if (String.valueOf(a).contains("666")) //문자열로 바꿨을때 666이란 글자 있으면
				count++; //갯수 증가시키고 N값이랑 같아지면 while문 종료
		}
		System.out.println(a);

	}

}
