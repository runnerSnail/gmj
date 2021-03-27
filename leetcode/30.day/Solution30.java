import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 30. 串联所有单词的子串
// 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

// 示例 1：

// 输入：
// s = "barfoothefoobarman",
// words = ["foo","bar"]
// 输出：[0,9]
// 解释：
// 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
// 输出的顺序不重要, [9,0] 也是有效答案。
// 示例 2：

// 输入：
// s = "wordgoodgoodgoodbestword",
// words = ["word","good","best","word"]
// 输出：[]
class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words.length > 0 ? words[0].length() : 0;
        List result = new ArrayList<Integer>();
        // generator all str
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            int has = hashMap.getOrDefault(word, 0);
            hashMap.put(word, has + 1);
        }
        int start = 0;
        int end = words.length * wordLen;
        while (end <= s.length()) {
            if (validateSubstring((HashMap) hashMap.clone(), s.substring(start, end), wordLen)) {
                result.add(start);
            }
            start++;
            end++;
        }

        return result;
    }

    // slide window
    public boolean validateSubstring(HashMap<String, Integer> hashMap, String substr, int wordLen) {
        for (int i = 0; i < substr.length(); i += wordLen) {
            String word = substr.substring(i, i + wordLen);
            // System.out.println(word);
            if (hashMap.containsKey(word)) {
                int num = hashMap.get(word);
                // System.out.println(num); 
                if(num>0) {
                    hashMap.put(word, num - 1);
                    if(num-1==0) hashMap.remove(word);
                };
            } else {
                return false;
            }
        }
        return hashMap.size()==0;
    }

    // hashMap
    public void generatorStr(Set<String> set, String[] words, String str) {
        if (words.length == 0) {
            set.add(str);
        }
        for (int i = 0; i < words.length; i++) {
            String[] rest = new String[words.length - 1];
            if (rest.length == 0) {
                generatorStr(set, rest, str += words[i]);
                return;
            }
            // System.out.println(Arrays.toString(rest));
            for (int j = 0, k = 0; j < words.length; j++) {
                if (j == i) {
                    continue;
                }
                rest[k++] = words[i];
            }
            generatorStr(set, rest, str += words[i]);
        }
    }

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        String[] words = { "word", "good", "best", "word" };
        // System.out.println(solution30.findSubstring("wordgoodgoodgoodbestword", words).toString());
        String[] words1 = { "foo","bar" };
        String[] words2 = { "word","good","best","good" };
        // System.out.println(solution30.findSubstring("barfoothefoobarman", words1).toString());
        System.out.println(solution30.findSubstring("wordgoodgoodgoodbestword", words2).toString());
    }
}