/*
 * 이름: 이호민
 * hw:  6_1
 * 학번: 201735030
 * 생성: 2022.10.07 13:40
 */
package hw6_1;

public class MyBinarySearchTree {
    private static Node root = null;

    private static class Node {
        int _key;    // 키 값
        Node _left;  // 왼쪽 자식 링크
        Node _right; // 오른쪽 자식 링크
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("(");

        if (root != null) {
            inOrder(stb, root);
            stb.delete(stb.length() - 2, stb.length());
        }
        stb.append(")");

        return stb.toString();
    }

    /***
     * 단일 키 값 삽입 메서드
     * @param key Int 형 새로운 key 값
     */
    public void add(int key) {
        if (contains(key)) { return; }
        insertInTree(root, key);
    }

    /***
     * 배열을 통한 새로운 키 값 삽입 메서드
     * @param key Int 형 배열
     */
    public void add(int[] key) {
        for (int i = 0; i < key.length; i++) { add(key[i]); }
    }

    /***
     * 정수키값을 매개변수로 받아 트리에 존재하는지 여부를 리턴
     * @param key int 형 검사 대상 key
     * @return 존재 유무
     */
    public boolean contains(int key) {
        if (root == null) { return false; } // 빈 경우 실패 반환

        Node cur = root;                    // 현위치 커서를 root 로 설정. 탐색 준비

        while (cur != null) {
            if (cur._key == key) { return true; }           // 찾은 경우 성공 반환
            else if (cur._key < key) { cur = cur._right; }  // 찾는 대상보다 현재 커서의 값이 작은 경우 왼쪽 탐색
            else { cur = cur._left; }                       // 찾는 대상보다 현재 커서의 값이 큰 경우 오른쪽 탐색
        }

        return false;
    }

    /***
     * 단일 key 값을 트리로부터 삭제
     * @param key 삭제할 Int 형 key 값
     */
    public void remove(int key) {
        if (root == null) { return; }   // 트리가 비어있는 경우 삭제 취소

        Node target = root;
        Node parent = target;

        do {
            if (target._key > key && target._left != null) {
                parent = target;
                target = target._left;
            } else if (target._key < key && target._right != null) {
                parent = target;
                target = target._right;
            }
            else {                      // target == root 인 경우
                parent = null;
                target = root;
            }
        } while (target._key != key);   // 삭제 대상 키를 찾을 때 까지 탐색

        deleteInTree(target, parent);
    }


    /***
     * 배열을 통한 삭제할 key 값 삭제
     * @param key 삭제할 Int 형 key 값 배열
     */
    public void remove(int[] key) {
        for (int i = 0; i < key.length; i++) { remove(key[i]); }
    }

    /***
     * 트리를 중순위 순회하며 키값을 문자열에 추가하는 재귀 메소드
     * @param sb @Override 된 toString()의 StringBuilder
     * @param n 탐색을 시작할 Node Class struct
     */
    private void inOrder(StringBuilder sb, Node n) {
        if (n == null) { return; }

        inOrder(sb, n._left);
        sb.append(n._key).append(", ");
        inOrder(sb, n._right);
    }

    private void insertInTree(Node n, int key) {
        if (root == null) {
            root = newNode(key);
            return;
        } else if (n._key != key) {
            if (n._key < key) {
                if (n._right != null) { insertInTree(n._right, key); }
                else { n._right = newNode(key); }
            } else {
                if (n._left != null) { insertInTree(n._left, key); }
                else { n._left = newNode(key); }
            }
        }

        return;
    }

    private void deleteInTree(Node t, Node p) {
//        // TODO: target == root 인 경우 condition에 대한 method 구현
//        if (p == null) {        // target == root 인 경우
//            searchMax();
//            root = null;
//        }
//        else if (t._right == null && t._left == null) {          // 자식이 없는 경우
        if (t._right == null && t._left == null) {          // 자식이 없는 경우
            if (t._key > p._key) { p._right = null; }
            else { p._left = null; }
        } else if (t._right != null && t._left == null) {   // 작은 자식이 있는 경우
            if (t._right._key < p._key) { p._left = t._right; }
            else { p._right = t._right; }
        } else {                                            // 큰 자식이 있는 경우
            if (t._left._key < p._key) { p._left = t._left; }
            else { p._right = t._left; }
        }
    }

    private Node newNode(int key) {
        Node temp = new Node();
        temp._key = key;

        return temp;
    }
}
