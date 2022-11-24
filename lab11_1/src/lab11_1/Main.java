/*
 * 이름: 이호민
 * lab: 11_1
 * 학번: 201735030
 * 생성: 2022.11.24 17:15
 */
package lab11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    /**
     * Meeting 정보를 갖는 Class
     */
    private static class Meeting {
        int _sTime, _eTime;     // 회의 시작 시간, 종료 시간

        /**
         * Meetings Class 생성자
         * @param sTime 회의 시작 시간
         * @param eTime 회의 종료 시간
         */
        public Meeting(int sTime, int eTime) {
            this._sTime = sTime;
            this._eTime = eTime;
        }

        @Override
        public String toString() { return "(" + _sTime + ", " + _eTime + ")"; }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.println("lab11_1 : 이호민");

        int n = Integer.parseInt(br.readLine());            // 전체 case 수 입력 받기
        int before = 0;                                     // 마지막 _eTime 저장
        Meeting[] meetings = new Meeting[n];                // 전체 meetings 리스트
        ArrayList<Meeting> selMeetings = new ArrayList<>(); // 선택된 meetings 리스트

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = (new Meeting(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        // 종료시각-시작시각 기준으로 오름차순 정렬
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1._eTime == o2._eTime) { return (o1._sTime - o2._sTime); }
            else { return (o1._eTime - o2._eTime); }
        });

        // 회의 정렬 이후 출력 및 최적의 시간으로 배정
        sb.append("회의 정렬 결과 =\n");
        for (int i = 0; i < n; i++) {
            Meeting cur = meetings[i];
            sb.append(cur).append("\n");

            if (i == 0) {
                before = cur._eTime;
                selMeetings.add(cur);
            }
            else {
                if (before <= cur._sTime) {
                    selMeetings.add(cur);
                    before = cur._eTime;
                }
            }
        }

        // 선택 결과 출력
        sb.append("회의 선택 결과 =\n");
        for (int i = 0; i < selMeetings.size(); i++) {
            Meeting cur = selMeetings.get(i);
            sb.append(cur).append("\n");
        }
        sb.append(selMeetings.size()).append("\n");

        System.out.print(sb);
    }
}
