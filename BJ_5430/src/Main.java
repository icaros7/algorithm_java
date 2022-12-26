import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

/*
 * BJ: 5430
 * URL: https://www.acmicpc.net/problem/5430
 * Date: 2022-03-07
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
            Iterator<Integer> iterator = deque.iterator();
            boolean isReversed = false;
            boolean exit = false;

            // 명령어 입력
            String[] cmd = br.readLine().split("");

            // 전체 배열 수 입력
            int total = Integer.parseInt(br.readLine());

            // 배열 정수 입력
            String[] in_arr = br.readLine().replace("[", "").replace("]", "").split(",");
            // 배열 정수 Dequeue 에 Offer
            try {
                for (String s : in_arr) {
                    deque.offerLast(Integer.parseInt(s));
                }
            }
            catch (NumberFormatException e) {}

            for (String s : cmd) {
                if (s.equals("R")) { // iterator 정방향/역방향 전환
                    if (deque.isEmpty()) {
                        sb.append("[]\n"); exit = true; break;
                    }
                    else if (isReversed) { iterator = deque.iterator(); isReversed = false; }
                    else { iterator = deque.descendingIterator(); isReversed = true; }
                }
                else if (s.equals("D")) { // iterator next 제거
                    if (deque.isEmpty()) { sb.append("error\n"); exit = true; break; }
                    else if (iterator.hasNext()) { iterator.next(); iterator.remove(); }
                    else { sb.append("error\n"); exit = true; break; } // 상위 루프 탈출과 함께 종료
                }
            }

            // 상위 루프를 탈출 해야하는 경우
            if (exit) { continue; }

            sb.append("[");
            while (iterator.hasNext()) { sb.append(iterator.next()).append(","); }
            if (sb.lastIndexOf(",") > 2) { sb.deleteCharAt(sb.lastIndexOf(",")); }
            sb.append("]\n");
        }
        System.out.print(sb);
    }
}
