public class Solution43 {
    public String multiply(String num1, String num2) {
        long result = 0;
        for (int j = num2.length()-1; j >=0; j--) {
            long add =0;
            for (int i = num1.length()-1; i >=0; i--) {
                add+=(Math.pow(10, num1.length()-1-i)*(num1.charAt(i)-'0')*(num2.charAt(j)-'0'))*Math.pow(10, num2.length()-1-j);
            }
            result+=add;
        }
        // System.out.println(result);
        StringBuffer resultStr = new StringBuffer();
        if(result==0){
            resultStr.append(0);
        }
        while(result>=10){
            resultStr.append(result%10);
            result /=10;
        }
        if(result>0){
            resultStr.append(result);
        }
        return resultStr.reverse().toString();
    }
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        // System.out.println(solution43.multiply("123", "6"));
        // System.out.println(solution43.multiply("0", "6"));
        // System.out.println(solution43.multiply("1000", "12"));
        // System.out.println(solution43.multiply("123456789", "987654321"));
        System.out.println(solution43.multiply("140", "721"));
        System.out.println(498828660196L*840477629533L);
    }
    
}
