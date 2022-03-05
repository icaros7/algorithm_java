import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    // 중앙값보다 큰 값 저장 우선순위 큐
    static PriorityQueue<Integer> hQueue = new PriorityQueue<>();
    // 중앙값보다 작은 값 저장 우선순위 큐
    static PriorityQueue<Integer> lQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 케이스 수 입력
        int n = Integer.parseInt(br.readLine());

        // 임시 저장 변수 생성
        int temp = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (i == 0) {               // 첫번째 루프의 경우 임시 저장 후 출력
                temp = input;

                sb.append(input).append("\n");
                continue;
            }
            else if (i == 1) {          // 두번째 루프의 경우 임시 저장 값과 비교 후 분배
                if (temp > input) {
                    hQueue.offer(temp);
                    lQueue.offer(input);
                    sb.append(input).append("\n");
                }
                else {
                    hQueue.offer(input);
                    lQueue.offer(temp);
                    sb.append(temp).append("\n");
                }

                continue;
            }

            addToQueue(input);
            sb.append(peekFromQueue()).append("\n");
        }

        System.out.print(sb);
    }

    // 큐 추가 메서드
    private static void addToQueue(int in) {
        if (in > hQueue.peek()) { hQueue.offer(in); }
        else { lQueue.offer(in); }

        reOrder();
    }

    // 중앙값 출력 메서드
    private static int peekFromQueue() {
        if (hQueue.size() > lQueue.size()) { return hQueue.peek(); }
        else { return lQueue.peek(); }
    }

    // 큐 사이즈가 2 이상 차이나는 경우 재 분배
    private static void reOrder() {
        if (hQueue.size() - lQueue.size() >= 2) { lQueue.offer(hQueue.poll()); }
        else if (lQueue.size() - hQueue.size() >= 2) { hQueue.offer(lQueue.poll()); }
    }
}
