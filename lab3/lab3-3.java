public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];
        
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, nums.length - mid);

        left = sortArray(left);
        right = sortArray(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result1 = solution.sortArray(new int[] {5, 2, 3, 1});
        int[] result2 = solution.sortArray(new int[] {5, 1, 1, 2, 0, 0});
        
        System.out.print("Sorted array 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.print("Sorted array 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
