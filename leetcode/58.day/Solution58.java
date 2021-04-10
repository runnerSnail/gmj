public class Solution58 {
    public int lengthOfLastWord(String s) {
        if(s.length()==0)return 0;
        int ans = 0;
        for (int i = s.length(); i > 0; --i) {
            if(s.charAt(i)!=' ') ans++;else{
                return ans;
            }
        }
        return ans;
    }
}
