import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution31 {
    public int[] nextPermutation(int[] nums) {
        int findPos = 0;

        for (int i = nums.length - 1; i > 1; i--) {
            if (i - 1 == 0) {
                break;
            }
            if (nums[i] > nums[i - 1]) {
                findPos = i;
                int temp = Integer.MAX_VALUE;
                int cloest = i;
                for (int j = i; j < nums.length && i + 1 < nums.length; j++) {
                    int interval = nums[j] - nums[i - 1];
                    if (interval > 0 && interval < temp) {
                        temp = interval;
                        cloest = j;
                    }
                }
                // System.out.println(Arrays.toString(nums));
                // System.out.println(i + "," + cloest);
                int swap = nums[cloest];
                nums[cloest] = nums[i - 1];
                nums[i - 1] = swap;
                // System.out.println(Arrays.toString(nums));
                break;
            }
        }

        for (int i = findPos; i < nums.length - 1; i++) {
            for (int j = findPos; j < nums.length - 1; j++) {
                int temp = nums[j];
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        // 输入12435输出12453。
        int[] num = {1,2,4,3,5};
        System.out.println(Arrays.toString(solution31.nextPermutation(num)));
        int[] num1 = {1,2,3};
        System.out.println(Arrays.toString(solution31.nextPermutation(num1)));
        int[] num2 = { 1, 2, 7, 4, 3, 1 }; // 131247
        System.out.println(Arrays.toString(solution31.nextPermutation(num2)));
        // int[] num2 = { 1, 2, 7, 4, 3, 1 };
        // for (int i = 0; i < num2.length - 1; i++) {
        //     for (int j = 0; j < num2.length-1; j++) {
        //         int temp = num2[j];
        //         if (num2[j] > num2[j + 1]) {
        //             num2[j] = num2[j + 1];
        //             num2[j + 1] = temp;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(num2));
    }
}
// @lc code=end

// import java.util.*;

// public class TrieTree {
// class TrieNode{
// public TrieNode[] subNode;
// public int count;//该节点的子节点个数
// public boolean isWord;//单词标记位
// public TrieNode() {
// this.count = 0;
// this.isWord = false;
// this.subNode = new TrieNode[26];//只包含小写字母a-z
// }
// }

// public TrieNode root;
// public TrieTree() {
// root = new TrieNode();
// }

// public boolean search(String word) {
// TrieNode curNode = root;
// int index;
// for(int i = 0; i < word.length(); i++) {
// index = word.charAt(i)-'a';
// if(curNode.subNode[index]!= null) {
// curNode = curNode.subNode[index];
// }else{
// return false;
// }
// }
// return curNode.isWord;
// }

// public void insert(String word) {
// if(search(word)) {
// System.out.println("The word already exists.");
// return;
// }
// TrieNode node = root;
// int index;
// for(int i = 0; i < word.length(); i++) {
// index = word.charAt(i) - 'a';
// if(node.subNode[index]==null) {
// node.subNode[index]= new TrieNode();
// }
// node.count++;
// node = node.subNode[index];
// }
// node.isWord = true;
// }

// public void delete(String word) {
// if(!search(word)) {
// System.out.println("No such word.");
// return;
// }
// TrieNode node = root;
// LinkedList<Integer> indexList = new LinkedList();
// LinkedList<TrieNode> nodeList = new LinkedList();
// int index;
// for(int i = 0; i < word.length(); i++) {
// index = word.charAt(i) - 'a';
// indexList.add(index);
// nodeList.add(node);
// node = node.subNode[index];
// }
// for(int i = word.length() - 1; i >= 0; i--) {
// node = nodeList.pollLast();
// index = indexList.pollLast();
// if(node.subNode[index].subNode == null) {
// if(i != word.length() - 1) {
// if(node.subNode[index].isWord == true) {//如果前缀节点中有单词标记位，那么不再继续删除
// return;
// }
// }
// node.subNode[index] = null;
// node.count--;
// }
// if(i == word.length()-1) {
// if(node.subNode[index].subNode != null) {
// node.subNode[index].isWord = false;
// return;
// }
// }

// }
// }

// public static void main(String[] args) {
// TrieTree myTrieTree = new TrieTree();
// String[] words = {"hello","face","hi","hell","why"};
// //插入字符串
// for(String word : words)
// myTrieTree.insert(word);

// //插入重复字符串
// myTrieTree.insert("hello");
// //删除字符串
// myTrieTree.delete("hell");
// //重复删除字符串
// myTrieTree.delete("hell");
// myTrieTree.delete("hi");
// //查询字符串，找到为true，未找到为false
// System.out.println(myTrieTree.search("hello"));
// System.out.println(myTrieTree.search("hi"));
// System.out.println(myTrieTree.search("hell"));
// }
// }
// 输入：nums = [1,2,3]
// 输出：[1,3,2]