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
        String cmd = "";
        int n = 0, x = 0;

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 실행 개수 지정
        }
        catch (IOException e) { e.printStackTrace(); }
        
        for (int i = 0; i < n; i++) {
            try { // try to readLine
                StringTokenizer st = new StringTokenizer(br.readLine());
                cmd = st.nextToken(); // 실행할 명령어
                if (st.hasMoreTokens()) { x = Integer.parseInt(st.nextToken()); } // 두번째 인자가 있다면
            }
            catch (IOException e) { e.printStackTrace(); }

            switch (cmd) {
                case "push": // 큐에 push
                    q.offer(x);
                    break;
                case "pop": // 큐를 pop
                    if (!q.isEmpty()) { System.out.println(q.poll()); }
                    else { System.out.println("-1"); }
                    break;
                case "size": // 큐의 size 출력
                    System.out.println(q.size());
                    break;
                case "empty": // 큐가 비었다면 1, 안비었다면 0
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front": // 큐의 가장 앞 요소 출력
                    if (!q.isEmpty()) { System.out.println(q.peek()); }
                    else { System.out.println("-1"); }
                    break;
                case "back": // 큐의 가장 뒷 요소 출력
                    if (!q.isEmpty()) { System.out.println(x); }
                    else { System.out.println("-1"); }
                    break;
            }    
        }
    }
}