import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        String cmd = "";
        int n = 0, x = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 실행 개수 지정

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken(); // 실행할 명령어
            if (st.hasMoreTokens()) { x = Integer.parseInt(st.nextToken()); } // 두번째 인자가 있다면

            switch (cmd) {
                case "push": // 큐에 push
                    q.offer(x);
                    break;
                case "pop": // 큐를 pop
                    if (!q.isEmpty()) { sb.append(q.poll()).append("\n"); }
                    else { sb.append(-1).append("\n"); }
                    break;
                case "size": // 큐의 size 출력
                    sb.append(q.size()).append("\n");
                    break;
                case "empty": // 큐가 비었다면 1, 안비었다면 0
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front": // 큐의 가장 앞 요소 출력
                    if (!q.isEmpty()) { sb.append(q.peek()).append("\n"); }
                    else { sb.append(-1).append("\n"); }
                    break;
                case "back": // 큐의 가장 뒷 요소 출력
                    if (!q.isEmpty()) { sb.append(x) .append("\n"); }
                    else { sb.append(-1).append("\n"); }
                    break;
            }
        }

        System.out.print(sb);
    }
}