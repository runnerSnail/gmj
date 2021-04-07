import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key =  String.valueOf(chs);
            if(!hashMap.containsKey(key)){
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution49.groupAnagrams(strs);
        for (List<String> list : result) {
            String row = "";
            for (String str : list) {
                row+=(str);
            }
            System.out.println(row);
        }
    }
}
