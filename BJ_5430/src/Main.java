import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

/*
 * BJ: 5430
 * URL: https://www.acmicpc.net/problem/5430
 * Date: 2022-03-05
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
            String command = br.readLine();
            String[] commands;
            int total = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            Iterator<Integer> iterator = deque.iterator();

            // 분할
            commands = command.split("");
            for (int i = 0; i < temp.length(); i++) {
                if (i == 0 || i == temp.length() - 1 || i % 2 == 0) { continue; }
                deque.offerLast(Integer.parseInt(String.valueOf(temp.charAt(i))));
            }

            // 연산 출력 부분
            if (deque.size() > total || total == 0 || deque.isEmpty()) { sb.append("error\n"); continue; }

            for (int i = 0; i < commands.length; i++) {
                switch (commands[i]) {
                    case "R":
                        if (iterator == deque.iterator()) { iterator = deque.descendingIterator(); }
                        else { iterator = deque.iterator(); }
                        break;

                    case "D":
                        deque.poll();
                }
            }

            sb.append("[");
            for (int i = 0; i < deque.size(); i++) {
                sb.append(iterator.next());
                if (i != deque.size() - 1) { sb.append(","); }
                else { sb.append("]\n"); }
            }
        }

        System.out.print(sb);
    }
}
