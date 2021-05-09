import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<Deque<String>>> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        List<Deque<String>> breakWords = backTrace(s, 0, s.length(), map, new HashSet<>(wordDict));

        for (Deque<String> breakWord : breakWords) {
            ret.add(String.join("", breakWord));
        }

        return ret;
    }

    private List<Deque<String>> backTrace(String s, int index, int length, Map<Integer, List<Deque<String>>> map,
            HashSet<String> hashSet) {
        List<Deque<String>> breakWords = new ArrayList<>();

        if (index == length) {
            breakWords.add(new LinkedList<>());
        }

        if (!map.containsKey(index)) {
            
            for (int i = index + 1; i < length; i++) {
                String word = s.substring(index, i);

                if (hashSet.contains(word)) {
                    List<Deque<String>> nextBreakWords = backTrace(s, index + 1, length, map, hashSet);
                    for (Deque<String> nextBreakWord : nextBreakWords) {
                        Deque<String> breakWord = new LinkedList<>(nextBreakWord);
                        breakWord.offerFirst(word);
                        breakWords.add(breakWord);
                    }
                }
            }

            map.put(index, breakWords);
        }

        return map.get(index);
    }

    public static void main(String[] args) {

    }
}