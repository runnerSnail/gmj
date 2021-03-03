import java.util.HashMap;

public class Solution13 {
    public String intToRoman(int num) {
        int result = num;
        String answer = "";
        HashMap numToRomanHashMap = new HashMap<Number, String>();
        numToRomanHashMap.put(1, "I");
        numToRomanHashMap.put(4, "IV");
        numToRomanHashMap.put(5, "V");
        numToRomanHashMap.put(9, "IX");
        numToRomanHashMap.put(10, "X");
        numToRomanHashMap.put(40, "XL");
        numToRomanHashMap.put(50, "L");
        numToRomanHashMap.put(90, "XC");
        numToRomanHashMap.put(100, "C");
        numToRomanHashMap.put(400, "CD");
        numToRomanHashMap.put(500, "D");
        numToRomanHashMap.put(900, "CM");
        numToRomanHashMap.put(1000, "M");
        while (result > 0) {
            if (result >= 1000) {
                answer += numToRomanHashMap.get(1000);
                result -= 1000;
            } else if (result >= 900) {
                answer += numToRomanHashMap.get(900);
                result -= 900;
            } else if (result >= 500) {
                answer += numToRomanHashMap.get(500);
                result -= 500;
            } else if (result >= 400) {
                answer += numToRomanHashMap.get(400);
                result -= 400;
            } else if (result >= 100) {
                answer += numToRomanHashMap.get(100);
                result -= 100;
            } else if (result >= 90) {
                answer += numToRomanHashMap.get(90);
                result -= 90;
            } else if (result >= 50) {
                answer += numToRomanHashMap.get(50);
                result -= 50;
            } else if (result >= 40) {
                answer += numToRomanHashMap.get(40);
                result -= 40;
            } else if (result >= 10) {
                answer += numToRomanHashMap.get(10);
                result -= 10;
            } else if (result >= 9) {
                answer += numToRomanHashMap.get(9);
                result -= 9;
            } else if (result >= 5) {
                answer += numToRomanHashMap.get(5);
                result -= 5;
            } else if (result >= 4) {
                answer += numToRomanHashMap.get(4);
                result -= 4;
            } else if (result >= 1) {
                answer += numToRomanHashMap.get(1);
                result -= 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.intToRoman(3));
        System.out.println(solution13.intToRoman(4));
        System.out.println(solution13.intToRoman(9));
        System.out.println(solution13.intToRoman(58));
        System.out.println(solution13.intToRoman(1994));
    }

    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

}

// 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

// 字符 数值
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII,
// 即为 XX + V + II 。

// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

// 示例 1:

// 输入: 3
// 输出: "III"
// 示例 2:

// 输入: 4
// 输出: "IV"
// 示例 3:

// 输入: 9
// 输出: "IX"
// 示例 4:

// 输入: 58
// 输出: "LVIII"
// 解释: L = 50, V = 5, III = 3.
// 示例 5:

// 输入: 1994
// 输出: "MCMXCIV"
// 解释: M = 1000, CM = 900, XC = 90, IV = 4.
// 通过次数135,442提交次数209,330
