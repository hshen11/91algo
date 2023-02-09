package array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author 沈浩
 * @date 2023/2/7 23:06
 */
public class ThirdLargestNum {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);

        for (int i = 1, diff = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] && ++diff == 3) { // 此时 nums[i] 就是第三大的数
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public int thirdMax2(int[] nums) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num : nums) {
            s.add(num);
            if (s.size() > 3) {
                s.remove(s.first());
            }
        }
        return s.size() == 3 ? s.first() : s.last();
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 0, 90};
        thirdMax(nums);
        
    }
}
