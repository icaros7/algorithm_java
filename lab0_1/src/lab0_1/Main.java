/*
 * 이름: 이호민
 * lab: 0_1
 * 학번: 201735030
 * 생성: 2022.09.01 16:50
 */

package lab0_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("lab0_1 : 이호민");

        // 두 정수를 입력받아 합을 출력
        Scanner s = new Scanner(System.in);
        System.out.print("두 정수 입력 : ");
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.print("합 = ");
        System.out.println(a + b);
    }
}