/*
 * 이름: 이호민
 * hw:  9_1
 * 학번: 201735030
 * 생성: 2022.11.08 14:40
 */
package hw9_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());      // 전체 케이스 수 입력

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());    // 현재 n 값 받기
            int[][] arr = new int[2][n + 1];
            int[][] newArr = new int[2][n + 1];

            newArr[0][0] = newArr[1][0] = 0;            // 0열의 경우 늘 0
            for (int j = 0; j < 2; j++) {               // 행 탐색
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {       // 열 탐색
                    int a = Integer.parseInt(st.nextToken());
                    arr[j][k] = a;
                    if (k == 1) { newArr[j][k] = a; }   // (max(0, 0) + x = x) 이므로 1열 바로 복사
                }
            }

            /*
            * 행렬탐색을 하되 조건 추가
            * - 7시반 방향 값과 7시반 방향 값의 9시 방향 값 비교 (스티커 조건)
            * - 값을 미리 예측은 불가능하므로 최대 2칸 이후 탐색
            *   - 3칸의 경우 최대값 도출 실패
            *
            * newArr[j][j] = arr[j - 1][k - 1] + max(newArr[j][k - 1], newArr[j - 1][k]);
            */
            for (int j = 2; j <= n; j++) {
                newArr[0][j] = arr[0][j] + max(newArr[1][j - 1], newArr[1][j - 2]);
                newArr[1][j] = arr[1][j] + max(newArr[0][j - 1], newArr[0][j - 2]);
            }
            sb.append(max(newArr[0][n], newArr[1][n])).append("\n");
        }
        System.out.print(sb);
    }

    private static int max(int a, int b) { return (a >= b) ? a : b; }
}
