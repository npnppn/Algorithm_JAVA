package shortestPath;

import java.io.*;
import java.util.*;

public class Main_1753 {
	static LinkedList<Node> list[];
    static int distance[];
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        int start = Integer.parseInt(br.readLine());
        
        visit = new boolean[v+1]; //방문 여부 
        list = new LinkedList[v+1]; // 
        distance = new int[v+1]; // 거리 배열
        Arrays.fill(distance, -1);
        
        
        for(int i = 1; i <= v; i++) {
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stz.nextToken());
            int v2 = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[v1].add(new Node(v2, w));
        }
        
        dijkstra(start);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++)
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));  // 우선 순위의 가중치에 시작 정점을 삽입
        distance[start] = 0; // 시작점의 거리 = 0
        
        while(!pq.isEmpty()) { 
            Node now = pq.poll(); // 정점을 꺼냄
            if(!visit[now.number]) {  // 정점을 방문하지 않았으면 
                visit[now.number] = true; // 방문처리
                for(Node next : list[now.number]) { 
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) { //이어져있고 현재 값보다 작으면
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int number, weight;
        
        Node(int n, int w) {
            this.number = n; // 정점의 번호
            this.weight = w; // 가중치
        }
        
        public int compareTo(Node n) { // 가중치의 오름차순
            return weight - n.weight;
        }
    }
}