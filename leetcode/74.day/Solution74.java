public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    private boolean binarySearchRow(int[] row, int target) {
        int high = row.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high - low - 1) / 2 + low;
            if(row[mid]==target) return true;
            if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {

        int high = matrix.length - 1;
        if (high < 0)
            return 0;
        int low = 0;
        // 0 1 2 3 //1
        while (low <= high) {
            int mid = (high - low - 1) / 2 + low;
            if(matrix[mid][0]==target)return mid;
            if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low-1;
    }

    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.searchMatrix(new int[][] { 
            { 1 }, 
        }, 1));
    }
}
