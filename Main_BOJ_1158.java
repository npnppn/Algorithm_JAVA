package ssafy_algo;
import java.util.*;
import java.io.*;

public class Main_BOJ_1158 {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        Queue<Integer> q = new LinkedList<>();
        
        // 큐에 각각의 값 추가
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        // 큐 사이즈가 1일 때까지 반복
        while(q.size()>1) {
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            
            // K번째 값은 poll한 후 출력한다.
            sb.append(q.poll() + ", ");
        }
        
        // 큐 사이즈가 1이 되면 poll
        sb.append(q.poll() + ">");
        System.out.println(sb);
	
	}
}