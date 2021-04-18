import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
    
            int n = s.length();
            HashMap<Character, Integer> tMap = new HashMap<>();
            HashMap<Character, Integer> windowMap = new HashMap<>();
    
            for (char c :  t.toCharArray()) { // 记录 t 中所有字符出现的次数
    
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }
    
            int left = 0, right = 0;
            // 记录窗口中满足条件的字符个数
            int flag = 0;
    
            // 记录最小覆盖字串的起始索引及长度
            int start = 0, minLength = Integer.MAX_VALUE;
    
            while (right < n) {
    
                char c = s.charAt(right);
                // 判断取出的字符是否在 t 中
                if (tMap.containsKey(c)) {
    
                    windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                    // 判断取出的字符在窗口中的出现次数是否与 t 中该字符的出现次数相同
                    if (windowMap.get(c).equals(tMap.get(c))) { 
    
                        flag++;
                    }
                }
    
                // 判断是否需要缩小窗口(已经找到符合条件的子串)
                while (flag == tMap.size()) {
    
                    if (right - left + 1 < minLength) {
    
                        start = left;
                        minLength = right - left + 1;
                    }
                    char c1 = s.charAt(left);
                    left++;
                    if (tMap.containsKey(c1)) {
    
                        if (windowMap.get(c1).equals(tMap.get(c1))) {
    
                            flag--;
                        }
                        windowMap.put(c1, windowMap.getOrDefault(c1, 0) - 1);
                    }
                }
                right++;
            }
            return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        }
    }