package week01;

import java.util.*;

public class ThreeSum {


    //1 暴力解法 三重循环
    //O(n^3)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == -(nums[i] + nums[j])) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    //暴力解法 两重循环
    //O(n^2) 使用map
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (map.get(-nums[i] - nums[j]) != null && map.get(-nums[i] - nums[j]) != i) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[map.get(-nums[i] - nums[j])]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }


    //采用左右指针，向中间夹逼
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //
            if (nums[i] > 0) {
                break;
            }

            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return lists;
    }


}