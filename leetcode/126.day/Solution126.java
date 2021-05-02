import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ret;
        }
        HashSet<String> digcits = new HashSet<>(wordList);
        digcits.remove(beginWord);
        HashMap<String, Integer> steps = new HashMap<>();
        HashMap<String, List<String>> form = new HashMap<>();
        steps.put(beginWord, 0);
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
                        if (steps.containsKey(nextWorld) && step == steps.get(nextWorld)) {
                            form.get(nextWorld).add(curWord);
                        }

                        if (!digcits.contains(nextWorld)) {
                            continue;
                        }
                        digcits.remove(nextWorld);
                        queue.offer(nextWorld);
                        form.putIfAbsent(nextWorld, new ArrayList<>());
                        form.get(nextWorld).add(curWord);
                        steps.put(nextWorld, step);
                        if (nextWorld.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            step++;
            if (found) {
                break;
            }
        }
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(beginWord, endWord, form, path, ret);
        }
        return ret;
    }

    private void dfs(String beginWord, String endWord, HashMap<String, List<String>> form, Deque<String> path,
            List<List<String>> ret) {
        if (endWord.equals(beginWord)) {
            ret.add(new ArrayList<>(path));
            return;
        }
        List<String> formWorlds = form.get(endWord);
        for (int i = 0; i < formWorlds.size(); i++) {
            path.addFirst(formWorlds.get(i));
            dfs(beginWord, formWorlds.get(i), form, path, ret);
            path.removeFirst();
        }
    }

    public static void main(String[] args) {
        Solution126 solution126 = new Solution126();
        String[] array = {"hot","dot","dog","lot","log","cog"};
        System.out.println(solution126.findLadders("hit", "cog",  Arrays.asList(array)));
    }
}
