public class Sword11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int middle = (right + left ) / 2;
            if (numbers[middle] < numbers[right]) {
                right = middle;
            } else if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else {
                right--;
            }
        }
        return numbers[left];

    }

    public static void main(String[] args) {
        Sword11 sword11 = new Sword11();
        System.out.println(sword11.minArray(new int[] { 3,1}));
    }
}
