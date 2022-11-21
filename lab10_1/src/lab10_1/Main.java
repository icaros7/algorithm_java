/*
 * 이름: 이호민
 * lab: 10_1
 * 학번: 201735030
 * 생성: 2022.11.17 17:11
 */
package lab10_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static int[] par;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("lab10_1 : 이호민");

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());    // 정점 수
        int e = Integer.parseInt(st.nextToken());    // 간선 수

        // e개의 간선(v1, v2, weight)을 입력받아 간선 리스트에 삽입
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[3];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            temp[2] = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(temp[0], temp[1], temp[2]));
        }

        // 간선 리스트를 가중치 오름차순으로 정렬
        edgeList.sort(Comparator.comparingInt(o -> o.weight));

        // 트리를 이용한 상호배타적 집합 표현
        // 배열 parent를 생성. [0...n-1]이면 충분하지만, 인덱스 계산을 이해하기 쉽게 하기 위해 [0...n]을 생성해보자.
        par = new int[n + 1];

        // 각 정점으로 구성된 n개의 상호배타적 집합 생성
        for (int i = 1; i <= n; i++) { makeSet(i); }

        // 오름차순으로 정렬된 edgeList에서 간선을 하나씩 검사하여, 사이클을 형성하지 않으면 트리 간선임(가중치 합에 더함)
        int treeEdgeCount = 0;  // 트리 간선 수
        int treeWeightSum = 0;  // 트리 가중치 합

        for(int i = 0; (i < e) && (treeEdgeCount < n - 1); i++) {
            Edge edge = edgeList.get(i);
            if (findSet(edge.v1) != findSet(edge.v2)) {  // 사이클을 형성하지 않으면(즉, edge의 v1, v2가 같은 집합에 속하지 않으면)
                union(edge.v1, edge.v2);        // v1, v2가 속한 집합을 합침
                treeWeightSum += edge.weight;   // 가중치 합에 edge의 가중치를 더함
                treeEdgeCount++;
            }
        }
        // 최소신장트리의 간선 가중치 합을 출력
        sb.append(treeWeightSum).append("\n");
        System.out.print(sb);
    }

    private static void makeSet(int x) { par[x] = x; }

    private static int findSet(int x) {
        if (par[x] != x) { par[x] = findSet(par[x]); }

        return par[x];
    }

    private static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x != y) { par[y] = x; }
    }
}

class Edge {
    int v1, v2; // 간선 (v1, v2)를 이루는 정점 번호
    int weight;	// 간선 가중치

    /**
     * Edge 생성자
     * @param v1 간선간 정점 번호1
     * @param v2 간선간 정점 번호2
     * @param weight 간선 가중치
     */
    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}