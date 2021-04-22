import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    // 0 / 0 1 / 00 01 11 10
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {
            {
                add(0);
            }
        };
        int head = 1;
        for (int i = 0; i < n; i++) {
            int len = res.size();
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution89 solution89 = new Solution89();
        System.out.println(solution89.grayCode(2).toString());
    }
}