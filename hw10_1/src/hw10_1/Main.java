/*
 * 이름: 이호민
 * hw:  10_1
 * 학번: 201735030
 * 생성: 2022.11.18 00:23
 */
package hw10_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static int[][] par;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("hw10_1 : 이호민");

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());    // 정점 수
        int e = Integer.parseInt(st.nextToken());    // 간선 수

        // e개의 간선(v1, v2, weight)을 입력받아 간선 리스트에 삽입
        ArrayList<Edge> edgeList = new ArrayList<>();
        // 최소신장트리 간선 리스트용 새 리스트 생성
        ArrayList<Edge> temp = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList.add(new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        // 간선 리스트를 가중치 오름차순으로 정렬
        edgeList.sort(Comparator.comparingInt(o -> o.weight));

        // 트리를 이용한 상호배타적 집합 표현
        par = new int[2][n + 1];

        // 각 정점으로 구성된 n개의 상호배타적 집합 생성
        for (int i = 1; i <= n; i++) { makeSet(i); }

        // 오름차순으로 정렬된 edgeList에서 간선을 하나씩 검사하여, 사이클을 형성하지 않으면 트리 간선임(가중치 합에 더함)
        int treeEdgeCount = 0;  // 트리 간선 수
        int treeWeightSum = 0;  // 트리 가중치 합

        for(int i = 0; (i < e) && (treeEdgeCount < n - 1); i++) {
            Edge cur = edgeList.get(i);
            if (findSet(cur.v1) != findSet(cur.v2)) {  // 사이클을 형성하지 않으면(즉, edge의 v1, v2가 같은 집합에 속하지 않으면)
                union(cur.v1, cur.v2);        // v1, v2가 속한 집합을 합침
                treeWeightSum += cur.weight;   // 가중치 합에 edge의 가중치를 더함
                treeEdgeCount++;
                temp.add(cur);
            }
        }

        // 최소신장트리의 간선 가중치 합을 출력
        sb.append(treeWeightSum).append("\n");
        // 최소신장트리 간선 리스트를 출력
        sb.append(temp).append("\n");

        System.out.print(sb);
    }

    /***
     * 하나의 원소 x로 구성된 집합 생성 메서드
     * @param x 원소
     */
    private static void makeSet(int x) {
        par[0][x] = x;
        par[1][x] = 0;
    }

    /***
     * 경로 압축을 통한 대표 원소 검색 메서드
     * @param x 대표 원소 검색 인자
     * @return x를 포함한 그룹의 대표 원소
     */
    private static int findSet(int x) {
        if (par[0][x] != x) { par[0][x] = findSet(par[0][x]); }
        return par[0][x];
    }

    /***
     * 집합1과 집합2를 합치는 메서드
     * @param x 집합1
     * @param y 집합2
     */
    private static void union(int x, int y) {
        x = findSet(x);         // x에 대한 루트 노드 탐색
        y = findSet(y);         // y에 대한 루트 노드 탐색

        if (x == y) { return; } // 루트가 동일하면 동일 집합 판단
        if (par[1][x] > par[1][y]) { par[0][y] = x; }   // rank 높은 집합으로 병합
        else {
            par[0][x] = y;      // 집합 병합
            if (par[1][x] == par[1][y]) { par[1][y]++; }
        }
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

    @Override
    public String toString() { return "(" + v1 + " " + v2 + ")"; }
}
