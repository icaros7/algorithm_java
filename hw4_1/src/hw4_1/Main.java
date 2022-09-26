/*
 * 이름: 이호민
 * hw:  4_1
 * 학번: 201735030
 * 생성: 2022.09.26 21:55
 */

package hw4_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] target;
    public static int[] temp;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // Input total case number
        target = new int[n];    // Initialing integer array
        temp = new int[n];

        for (int i = 0; i < n; i++) { target[i] = Integer.parseInt(br.readLine()); }

        mergeSort(0, target.length-1);

        for (int i = 0; i < n; i++) { sb.append(target[i]).append("\n"); }
        System.out.println(sb);
    }

    /**
     * Simple MergeSort Algorithm
     * @param s Index of start in array
     * @param e Index of end in array
     */
    public static void mergeSort(int s, int e) {
        if (s >= e) { return; }

        int midIndex = (s + e) / 2; // Split array via middle index
        int p = s;
        int q = midIndex + 1;
        int cur = p;

        mergeSort(s, midIndex);         // mergeSort() first array
        mergeSort(midIndex + 1, e); // mergeSort() second array

        while (p <= midIndex || q <= e) {
            if (q > e || (p <= midIndex && target[p] < target[q])) {
                temp[cur++] = target[p++];
            } else {
                temp[cur++] = target[q++];
            }
        }

        for (int i = s; i <= e; i++) { target[i] = temp[i]; }
    }
}
