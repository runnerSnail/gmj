import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        int currentLength = 0;
        for (int i = 0; i < words.length;) {
            if (currentLength == 0 || currentLength > 0 && currentLength + 1 + words[i].length() <= maxWidth) {
                end++;
                if (currentLength == 0) {
                    currentLength += words[i].length();
                } else {
                    currentLength = currentLength + 1 + words[i].length();
                }
                i++;
            } else {
                int sub = maxWidth - currentLength + (end - start) - 1;
                if (end - start == 1) {
                    String blank = getSubBlank(sub);
                    ans.add(words[start] + blank);
                } else {
                    StringBuilder temp = new StringBuilder();
                    temp.append(words[start]);
                    int averageBlank = sub / (end - start - 1);
                    int missing = sub % (end - start - 1);
                    String blank = getSubBlank(averageBlank + 1);
                    int k = 1;
                    // _  _ _
                    for (int j = 0; j < missing; j++) {
                        temp.append(blank + words[start+k]);
                        k++;
                    }
                    blank = getSubBlank(averageBlank);
                    for (; k < (end-start); k++) {
                        temp.append(blank + words[start + k]);
                    }
                    ans.add(temp.toString());
                }
                start = end;
                currentLength = 0;
            }
            StringBuilder temp = new StringBuilder();
            temp.append(words[start]);
            for (int j = 1; j < (end-start); j++) {
                temp.append(" " + words[start+j]);
            }

            temp.append(getSubBlank(maxWidth-currentLength));
            ans.add(temp.toString());
        }
        return ans;
    }

    private String getSubBlank(int sub) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sub; i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        System.out.println(-1/2);
        System.out.println(solution68.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justiftion.","vv"},16).toString());
    }
}
