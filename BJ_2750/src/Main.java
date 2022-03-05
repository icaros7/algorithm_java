import java.lang.Comparable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Quick.sort(arr);

        for (int i : arr) { System.out.println(i); }
    }
}

class Quick {
    private static int callSize = 10;
    public static void sort(Comparable[] a) { sort(a, 0, a.length - 1); }

    private static void sort(Comparable[] a, int low, int high) {
        // if (high <= low) { return; }
        if (high < low + callSize) {
            Insertion.sort(a, low, high);
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1); // 피벗보다 작은 부분을 재귀
        sort(a, j + 1, high); // 피벗보다 큰 부분을 재귀
    }

    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        Comparable p = a[pivot];

        while (true) {
            while (isLess(a[++i], p)) { if (i == high) { break; } } // 피벗보다 작을 경우 탈출
            while (isLess(p, a[--j])) { if (j == pivot) { break; } }// 피벗보다 클 경우 탈출
            if (i >= j) { break; }                                  // i와 j가 교차 되면 탈출
            swap(a, i, j);
        }

        swap(a, pivot, j);  // 피벗과 a[j] 교환
        return j;           // a[j]의 피벗이 "영원히" 자리 잡은 곳
    }

    // 키 비교 메서드
    private static boolean isLess(Comparable u, Comparable v) { return (u.compareTo(v) < 0); }

    // 각 키 교환 메서드
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j++) {
                if (isLess(a[j], a[j - 1])) { swap(a, j, j - 1); }
                else { break; }
            }
        }
    }

    public static void sort(Comparable[] a, int low, int high) {
        for (int i = low; i < high; i++) {
            for (int j = i; j > 0; j++) {
                if (isLess(a[j], a[j - 1])) { swap(a, j, j - 1); }
                else { break; }
            }
        }
    }

    // 키 비교 메서드
    private static boolean isLess(Comparable i, Comparable j) { return (i.compareTo(j) < 0); }

    // 각 키 교환 메서드
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}