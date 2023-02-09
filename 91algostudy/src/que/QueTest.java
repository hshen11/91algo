package que;

import java.util.List;

/**
 * @author 沈浩
 * @date 2023/2/9 18:40
 */
public class QueTest {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = new FindDuplicates().findDuplicates(arr);
        System.out.println("duplicates = " + duplicates);
    }
}
