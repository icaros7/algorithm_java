import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int n = 0, m = 0, d = 0, c = 0;

        // 테스트 케이스의 수 받기
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        catch (IOException e) { e.printStackTrace(); }

        for (int i = 0; i < n; i++) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.countTokens() == 2) {
                    m = Integer.parseInt(st.nextToken());
                    d = Integer.parseInt(st.nextToken());
                }
                else { throw new Exception("Need more/less arguments"); }

                st = new StringTokenizer(br.readLine());
                if (st.countTokens() == m) {
                    for (int j = 0; j < st.countTokens(); j++) { q.offer(Integer.parseInt(st.nextToken())); }
                }

            }
            catch (IOException e) { e.printStackTrace(); }
            catch (Exception e) { e.printStackTrace(); }

            for (int j = 0; j < q.size(); j++) {
                c = q.poll();
            }
        }
    }
}