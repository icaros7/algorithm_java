import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        int n = 0, k = 0, cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        try { // try to readLine
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < n; i++) { q.offer(i + 1); } // 큐 채우기

        System.out.print("<");
        while (q.size() != 1) { // poll & offer util q.size == 1
            cnt++;
            int temp = q.poll();
            if (cnt % k != 0) { q.offer(temp); }
            else { System.out.print(temp + ", "); }
        }

        System.out.println(q.poll() + ">"); // 마지막 남은 아이템은 poll 후 바로 출력
    }
}
