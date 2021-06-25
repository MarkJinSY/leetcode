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
