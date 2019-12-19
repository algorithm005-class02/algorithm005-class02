import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 两数之和
class LeetCode_01_0299 {

  public static int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {

      // 因为otherVal = target - nums[i]
      // 每次都把nums[i]存入hashMap中，用otherVal去hashMap里寻找 是否存在
      // 如果存在即满足条件 返回hashMap中otherVal的下标和nums[i]的下标
      int otherVal = target - nums[i];
      if (map.containsKey(otherVal)) {
        return new int[] { map.get(otherVal), i };
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("没有匹配的数据");
  }

  public static void main(String[] args) {

    int[] nums = new int[] { 2, 7, 11, 15 };
    int target = 9;

    int[] res = twoSum(nums, target);
    System.out.println(Arrays.toString(res));
  }
}