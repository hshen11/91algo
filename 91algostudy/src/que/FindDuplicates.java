package que;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * @author 沈浩
 * @date 2023/2/9 22:03
 */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                duplicates.add(index + 1);
            }
        }
        return duplicates;
    }

}
