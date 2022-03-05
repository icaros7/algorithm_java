import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

/*
 * BJ: 10866
 * URL: https://www.acmicpc.net/problem/10866
 * Date: 2022-03-05
 * Author: hominlab@gmail.com
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 총 시행 케이스 수 입력
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;

                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_back":
                    if (deque.isEmpty()) { sb.append(-1).append("\n"); }
                    else { sb.append(deque.pollLast()).append("\n"); }
                    break;

                case "pop_front":
                    if (deque.isEmpty()) { sb.append(-1).append("\n"); }
                    else { sb.append(deque.pollFirst()).append("\n"); }
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "back":
                    if (deque.isEmpty()) { sb.append(-1).append("\n"); }
                    else { sb.append(deque.peekLast()).append("\n"); }
                    break;

                case "front":
                    if (deque.isEmpty()) { sb.append(-1).append("\n"); }
                    else { sb.append(deque.peekFirst()).append("\n"); }
                    break;
            }
        }

        System.out.print(sb);
    }
}
