/*
 * 이름: 이호민
 * hw:  1_2
 * 학번: 201735030
 * 생성: 2022.09.01 19:45
 */

package hw1_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        sb.append("hw1_2 : 이호민").append("\n");
        System.out.println(sb);
        int n = sc.nextInt();   // 전체 Case 수 입력

        int[] arr = new int[n]; // Case 수에 따른 Integer Array 생성
        for (int i = 0; i < n; i++) { arr[i] = sc.nextInt(); } // 각 배열 원소 값 입력 및 Case 수 만큼만 입력을 통한 Out-of-bounds 방지

        Arrays.sort(arr);       // Array.sort를 이용하여 배열 sorting

        sb.append(arr[0]).append(" ").append(arr[arr.length - 1]).append("\n"); // 최소값, 최대값 출력

        int minCount = 1, maxCount = 1;
        if (arr[0] == arr[arr.length - 1]) { sb.append(n).append(" ").append(n); }  // 최소값과 최대값이 같은 경우 Case 수로 통일
        else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    minCount++;
                    continue;
                }
                break;
            }
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] == arr[i - 1]) {
                    maxCount++;
                    continue;
                }
                break;
            }
            sb.append(minCount).append(" ").append(maxCount);   // 최소값 개수, 최대값 개수 출력
        }
        System.out.println(sb); // StringBuilder 대기열 한번에 출력
    }
}
