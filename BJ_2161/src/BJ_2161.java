import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2161 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int n = 0;

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // N값 지정
        }
        catch (IOException e) { e.printStackTrace(); }

        // 큐 초기화
        for (int i = 0; i < n; i++) { q.offer(i + 1); }

        for (int i = 0; i < n; i++) { // 가장 위 카드를 버리고
            System.out.print(q.poll() + " ");
            q.offer(q.poll()); // 그 다음 카드를 가장 아래로
        }
    }
}
