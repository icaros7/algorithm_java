import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int n, x = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        while (n --> 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (st.hasMoreTokens()) { x = Integer.parseInt(st.nextToken()); }

            switch (cmd) {
                case "push":
                    stack.push(x);
                    break;
                case "pop":
                    if (stack.isEmpty()) { sb.append(-1); }
                    else { sb.append(stack.pop()).append("\n"); }

                    System.out.print(sb);
                    sb.setLength(0);
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");

                    System.out.print(sb);
                    sb.setLength(0);
                    break;
                case "empty":
                    if (stack.isEmpty()) { sb.append(1).append("\n"); }
                    else { sb.append(0).append("\n"); }

                    System.out.print(sb);
                    sb.setLength(0);
                    break;
                case "top":
                    if (stack.isEmpty()) { sb.append(-1).append("\n"); }
                    else { sb.append(x).append("\n"); }

                    System.out.print(sb);
                    sb.setLength(0);
                    break;
            }
        }
    }
}
