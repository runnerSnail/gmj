import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] interval1,int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.size()==0 ||  merged.get(merged.size()-1)[1]<L){
                merged.add(intervals[i]);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], R);
            }
        }

        return merged.toArray(new int[merged.size()][merged.size()]);
    }
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        solution56.merge(new int[][]{{1,4},{0,4}});
    }
}
