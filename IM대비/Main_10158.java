import java.io.*;
import java.util.*;

public class Main_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());

		
		//p위치에서 t만큼 오른쪽으로 가다가 벽만나면 반대로 가다가 벽만나면 계속 왔다갔다 하는데 2w만큼 움직일 때마다 다시 0으로 돌아옴
		int x = (p + t) % (2 * w);
		int y = (q + t) % (2 * h);

		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);

		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}
}
