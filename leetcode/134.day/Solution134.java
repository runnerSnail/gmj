public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLen = gas.length;
        for (int i = 0; i < cost.length; i++) {
            int gasSum = 0;
            int costSum = 0;
            int count = 0;
            while (count < gasLen) {
                int index = (count + i) % gasLen;
                gasSum += gas[index];
                costSum += cost[index];
                if (gasSum < costSum) {
                    break;
                }
                count += 1;
            }
            if (count == gasLen) {
                return i;
            } else {
                i = i + count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
