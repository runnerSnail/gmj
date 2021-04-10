import java.util.ArrayList;
import java.util.List;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> merged = new ArrayList();
        boolean place = false;
        for (int[] interval : intervals) {
            if(interval[0]>right){
                if(!place){
                    place = true;
                    merged.add(new int[]{left,right});
                }
                merged.add(interval);
            }else if(interval[1]<left){
                merged.add(interval);
            }else{
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if(!place){
            merged.add(new int[]{left,right});
        }
        int[][] ans = new int[merged.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = merged.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
