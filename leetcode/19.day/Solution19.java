import java.util.*;

public class Solution19 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() == '('){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() == '{'){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
            stack.add(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution19 soluion19 = new Solution19();
        System.out.println(soluion19.isValid("()")==true);
        System.out.println(soluion19.isValid("()[]{}")==true);
        System.out.println(soluion19.isValid("(]")==false);
        System.out.println(soluion19.isValid("([)]")==false);
        System.out.println(soluion19.isValid("{[]}")==true);
        System.out.println(soluion19.isValid("}")==false);
        System.out.println(soluion19.isValid("(])")==false);
        System.out.println(soluion19.isValid("([}}])")==false);
    }
}
