import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        String[] strArr = path.split("/");
        for (int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            if (s.equals("") || s.equals("."))
                continue;
            else if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (!queue.isEmpty())
                sb.append('/');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // "/home//foo/"
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath("/home//foo/"));
        System.out.println(solution71.simplifyPath("/..//"));
    }
}
