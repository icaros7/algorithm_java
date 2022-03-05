import java.util.Collections;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 최대순 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 케이스 수 입력
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) { sb.append("0").append("\n"); }
                else { sb.append(queue.poll()).append("\n"); }
            }
            else { queue.offer(input); }
        }

        System.out.print(sb);
    }
}
