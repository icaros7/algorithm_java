import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) != Math.abs(o2) ? Integer.compare(Math.abs(o1), Math.abs(o2)) : Integer.compare(o1, o2);
            }
        });
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
