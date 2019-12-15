import java.util.*;

/**
 * @author scott 2019/12/15
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        int i = 0;
        for (Integer item : list) {
            nums[i] = nums[item];
            i++;
        }
        return map.size();
    }
}
