/*
 * 이름: 이호민
 * hw:  6_1
 * 학번: 201735030
 * 생성: 2022.10.07 13:40
 */
package hw6_1;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hw6_1 : 이호민\n");

        // MyBinarySearchTree 객체 생성(tree)
        MyBinarySearchTree mbst = new MyBinarySearchTree();

        // tree를 출력
        sb.append(mbst).append("\n");

        // tree에 키값 2가 존재하는지 여부를 출력
        sb.append(mbst.contains(2)).append("\n");

        // tree에 키값 5, 4, 3, 1, 2, 8, 6, 9, 7, 10, 1, 5를 차례대로 삽입한 후 tree를 출력
        int[] arr = new int[] {5, 4, 3, 1, 2, 8, 6 ,9, 7, 10, 1, 5};
        mbst.add(arr);
        sb.append(mbst).append("\n");

        // tree에 키값 2, 6, 5, 11이 존재하는지 여부를 차례대로 출력
        sb.append(mbst.contains(2)).append("\n");
        sb.append(mbst.contains(6)).append("\n");
        sb.append(mbst.contains(5)).append("\n");
        sb.append(mbst.contains(11)).append("\n");

//      // TODO: 추가 과제
//        // tree에서 키값 9, 1, 5를 차례대로 삭제한 후 tree를 출력
//        arr = new int[] {9, 1, 5};
//        mbst.remove(arr);
//        sb.append(mbst).append("\n");
//
//        // tree에서 키값 9, 6, 3, 4, 2, 7, 8, 10, 11을 차례대로 삭제한 후 tree를 출력
//        arr = new int[] {9, 6, 3, 4, 2, 7, 8, 10, 11};
//        mbst.remove(arr);
//        sb.append(mbst).append("\n");

        System.out.println(sb);
    }
}