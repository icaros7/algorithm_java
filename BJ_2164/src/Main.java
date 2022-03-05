import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int n = 0;

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 실행 개수 지정
        }
        catch (IOException e) { e.printStackTrace(); }

        // 큐 초기화
        for (int i = 0; i < n; i++) { q.offer(i + 1); }

        for (int i = 0; i < n; i++) {
            if (q.size() == 1) { break; } // 마지막 하나가 남았다면 종료
            q.poll(); // 가장 위 카드를 버리고
            q.offer(q.poll()); // 그 다음 카드를 가장 아래로
        }

        System.out.println(q.poll()); // 마지막 카드를 뽑아 출력
    }
}