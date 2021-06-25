import java.util.HashMap;
import java.util.Map;

public class One_sum_of_two_number {

    public static int[] twoSum(int[] nums, int target) {
        int [] a = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if((nums[i] + nums[j]) == target) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    /**
     * 算法及思路
     * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，
     * 能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
     * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     */

    public int[] OfficeAnswer(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int a = target - nums[i];
            if (map.containsKey(a) && map.get(a) != i) {
                return new int [] {map.get(a),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        System.out.println("test");
        int [] a = {3,2,4};
        int [] result = twoSum(a, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }
}
