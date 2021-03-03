import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



//  

// 示例 1：

// 输入：digits = "23"
// 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 示例 2：

// 输入：digits = ""
// 输出：[]
// 示例 3：

// 输入：digits = "2"
// 输出：["a","b","c"]

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Solution17 {
    HashMap<Character,String> digitHashMap = new HashMap<>();
    public HashMap<Character,String> initHashMap(){
        HashMap<Character,String> digitHashMap= new HashMap<>();
        digitHashMap.put((char)'2',"abc");
        digitHashMap.put((char)'3',"def");
        digitHashMap.put((char)'4',"ghi");
        digitHashMap.put((char)'5',"jkl");
        digitHashMap.put((char)'6',"mno");
        digitHashMap.put((char)'7',"pqrs");
        digitHashMap.put((char)'8',"tuv");
        digitHashMap.put((char)'9',"wxyz");
        return digitHashMap;
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        digitHashMap = initHashMap();
        if(digits.length()==0){
            return list;
        }
        appendStr("",digits,0,list);
        return list;
    }

    public void appendStr(String lastStr,String digits,int current,List<String> list){
        if(current==digits.length()){
            list.add(lastStr);
            return;
        }
        char number = digits.charAt(current);
        String str = digitHashMap.get((char)number);
        char[] chars =  str.toCharArray();
        for (char c : chars) {
            appendStr(lastStr+c,digits,current+1,list);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }
}
