import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int perHour = 1000;
    static final int nightFee = 5000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 케이스 수 입력 받기
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String[] HM = st.nextToken().split(":");
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(HM[0]);
            int M = Integer.parseInt(HM[1]);
            int totalFee = 0;

            while (D > 0) {
                // 야간 시간대에 사용이 가능하며, 5000원어치 이상 하는 경우
                if ((D >= 300) && (H >= 22 || H <= 3)) {
                    // 60분 미만 사전 계산
                    if (M != 0) { D += M; M = 0; }
                    while (H != 8) {
                        D -= 60;
                        H += 1;
                        H %= 24;
                    }
                    totalFee += nightFee;
                }
                // 그 외엔 일반 요금 계산
                else {
                    D -= 60;
                    H += 1;
                    H %= 24;
                    totalFee += perHour;
                }
            }

            sb.append(totalFee).append("\n");
        }

        System.out.print(sb);
    }
}