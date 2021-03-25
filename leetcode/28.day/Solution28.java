// 28. 实现 strStr()
// 实现 strStr() 函数。

// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

// 示例 1:

// 输入: haystack = "hello", needle = "ll"
// 输出: 2
// 示例 2:

// 输入: haystack = "aaaaa", needle = "bba"
// 输出: -1
// 说明:

// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

public class Solution28 {
    public int strStr(String haystack, String needle) {
        int start = 0, end = needle.length() - 1;
        while (end < haystack.length()) {
            for (int i = 0; i < needle.length(); i++) {
                if(haystack.charAt(start+i)!=needle.charAt(i)){
                    break;
                }
                if(i==needle.length()-1){
                    return start;
                }
            }
            start++;
            end++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("hello", "ll"));
        System.out.println(solution28.strStr("aaaaa", "bba"));
    }
}

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
// class Solution {
// public List<Integer> findSubstring(String s, String[] words) {

// }
// }