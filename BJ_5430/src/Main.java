import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

/*
 * BJ: 5430
 * URL: https://www.acmicpc.net/problem/5430
 * Date: 2022-03-05
 * Author: hominlab@gmail.com
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 전체 케이스 수 입력
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            deque = new ArrayDeque<>();

            // 명령어 입력
            String in_cmd = br.readLine();
            String[] cmd = in_cmd.split("");

            // 전체 배열 수 입력
            int total = Integer.parseInt(br.readLine());

            // 배열 정수 입력
//            String in_arr = br.readLine().replace("[", "").replace("]", "");
            System.out.println(total);

        }
        System.out.print(sb);
    }
}
