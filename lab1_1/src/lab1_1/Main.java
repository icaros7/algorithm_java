/*
 * 이름: 이호민
 * lab: 1_1
 * 학번: 201735030
 * 생성: 2022.09.06 17:10
 */

package lab1_1;

public class Main {
    /**
     * 재귀적 호출을 통해 Factorial 연산 수행 메서드
     * @param n int형 피연산자
     */
    private static int factorial(int n) {
        if (n == 1) { return 1; }
        else { return n * factorial(n - 1); }
    }

    /**
     * 재귀적 호출을 통해 Sum 연산 수행 메서드
     * @param n int형 피연산자
     */
    private static int sum(int n) {
        if (n == 1) { return 1; }
        else { return n + sum(n - 1); }
    }

    /**
     * 재귀적 호출을 통한 1 ~ n 순차 출력 메서드
     * @param n int형 피연산자
     */
    private static void show(int n) {
        if (n != 1) {
            show(n - 1);
            System.out.print(n + " ");
        }
        else { System.out.print(1 + " "); }
    }

    public static void main(String[] args) {
        System.out.println("lab1_1 : 이호민");

        System.out.println(factorial(1));
        System.out.println(factorial(5));
        System.out.println(factorial(10));

        System.out.println(sum(1));
        System.out.println(sum(5));
        System.out.println(sum(10));

        show(1);
        System.out.println();
        show(5);
        System.out.println();
        show(10);
    }
}
