package array;

/**
 * @author 沈浩
 * @date 2023/2/8 10:18
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n - 1;
    }

    public static int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,3,4,5,6,7,9};
        int i = missingNumber2(nums);
        System.out.println("i = " + i);
    }

}
