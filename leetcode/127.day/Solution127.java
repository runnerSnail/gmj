import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution127 {
    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashSet<String> digcits = new HashSet<>(wordList);
        digcits.remove(beginWord);
        int step = 1;
        boolean found = false;
        int worldLen = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] charArray = curWord.toCharArray();

                for (int j = 0; j < worldLen; j++) {
                    char originChar = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWorld = String.valueOf(charArray);

                        if (!digcits.contains(nextWorld)) {
                            continue;
                        }
                        digcits.remove(nextWorld);
                        queue.offer(nextWorld);
                        if (nextWorld.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            step++;
            if (found) {
                return step;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
