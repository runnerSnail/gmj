import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(0, 0, s);
        return res;
    }

    private void dfs(int segmentId, int segmentStart, String s) {
         if (segmentId == SEG_COUNT) {
            if (segmentStart == s.length()) {
                StringBuilder segment = new StringBuilder();
                for (int i = 0; i < segments.length - 1; i++) {
                    segment.append(segments[i]);
                    segment.append('.');
                }
                segment.append(segments[SEG_COUNT-1]);
                res.add(segment.toString());
            }
            return;
        }

        if (segmentStart == s.length()) {
            return;
        }

        if (s.charAt(segmentStart) == '0') {
            segments[segmentId] = 0;
            dfs(segmentId + 1, segmentStart + 1, s);
            return;
        }

        int carry = 0;

        for (int i = segmentStart; i < s.length(); i++) {
            carry = carry * 10 + s.charAt(i) - '0';
            if (carry > 0 && carry <= 0xFF) {
                segments[segmentId] = carry;
                dfs(segmentId + 1, i + 1, s);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses("25525511135"));
    }
}
