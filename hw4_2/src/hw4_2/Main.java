/*
 * 이름: 이호민
 * hw:  4_2
 * 학번: 201735030
 * 생성: 2022.09.26 23:45
 */
package hw4_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[] temp;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열

    private static void mergeSort(int[] stdArr, int q, int p) {
        if (q == p) { return; }             // 재귀 탈출
        int midCur = (q + p) / 2;	        // 중앙값 기준 분할

        mergeSort(stdArr, q, midCur);		// 전자 리스트 재귀
        mergeSort(stdArr, midCur + 1, p);	// 후자 리스트 재귀
        merge(stdArr, q, p, midCur);		// 병합작업
    }

    private static void merge(int[] stdArr, int q, int p, int midCur) {
        int firstCur = q;		    // 첫번째 배열 커서
        int secondCur = midCur + 1;	// 두번째 배열 커서
        int tempCur = q;		    // 임시 배열 커서

        while ((firstCur <= midCur) && (secondCur <= p)) {
            if ((stdArr[firstCur] / 100000) <= (stdArr[secondCur] / 100000)) { // first 가 작을 경우
                temp[tempCur++] = stdArr[firstCur++];
            }
            else { temp[tempCur++] = stdArr[secondCur++]; } // second 가 작을 경우
        }

        if(firstCur > midCur) { // first 가 빌 때
            while(secondCur <= p) { temp[tempCur++] = stdArr[secondCur++]; } // second 넣고 종료
        }
        else {                  // second 가 빌 때
            while(firstCur <= midCur) { temp[tempCur++] = stdArr[firstCur++]; } // first 넣고 종료
        }

        for(int i = q; i <= p; i++) { stdArr[i] = temp[i]; }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 학생 수 입력
        int[] target = new int[n];
        temp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { target[i] = Integer.parseInt(st.nextToken()); }

        mergeSort(target, 0, n - 1);

        sb.append("hw4_2 : 이호민\n").append("병합 정렬\n");
        for (int i = 0; i < n; i++) { sb.append(target[i]).append(" "); }
        System.out.print(sb);
    }
}
