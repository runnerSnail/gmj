public class Solution125 {
    
    public boolean isPalindrome(String s) {
        StringBuilder sgood = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sgood.append(Character.toLowerCase(c));
            }
        }
        return sgood.toString().equals(sgood.reverse().toString());
    }

    public static void main(String[] args) {

    }
}
