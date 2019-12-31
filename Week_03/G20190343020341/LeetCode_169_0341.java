import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_169_0341 {

}

// 官方暴力解
class Solution169_1 {
    public int majorityElement(int[] nums) {
        int targetCount = nums.length / 2;
        //从第一个元素开始遍历
        for(int outer: nums) {
            int count = 0; //初始每个元素的个数为0
            for(int inter: nums)  {
                if (inter == outer) {
                    count++;
                }
            }
            if(count > targetCount) {
                return outer;
            }
        }
        return -1;
    }
}

//用HashMap辅助 优于官方暴力
class Solution169_2 {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int curcount = ((Integer) map.get(nums[i]));
                if(curcount + 1 > nums.length / 2) {
                    return nums[i];
                }
                map.put(nums[i], curcount + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}


// 排序
class Solution169_3 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

// 分治
class Solution169_4 {
    public int majorityElement(int[] nums) {
        //最初 low = 0; hi = nums.length - 1
        return majorityElementRecusive(nums, 0, nums.length - 1);
    }

    // low hi是两个指针，这样不需要对传递的数组做处理，直接传初始数组，然后根据指针取合适
    // 位置的值。因此不能使用0和nums.length - 1之类
    public int majorityElementRecusive(int[] nums, int low, int hi) {
        // 终止条件 一个元素的数组直接返回众数
        if (low == hi) {
            return nums[low];
        }

        //将指针分成2半，注意这边的mid 是加了low的， 因为low不等于0的时候是不能省的
        int mid = (hi - low) /2 + low;
        int left = majorityElementRecusive(nums, low, mid);
        int right = majorityElementRecusive(nums, mid + 1, hi);

        if(left == right) {
            return left;
        }

        int leftAssist = getRangeTotal(left, nums, low, hi);
        int rightAssist = getRangeTotal(right, nums, low, hi);

        //如果相等返回哪个都可以
        return leftAssist > rightAssist ? left : right;
    }

    private int getRangeTotal(int num, int[] nums, int low, int hi) {
        int count = 0;
        //这边右边界包括high
        for(int i = low; i <= hi; i++) {
            if(nums[i] == num) {
                count++;
            }
        }
        return count;
    }


}


//Boyer-Moore 投票算法
class Solution169_5 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for(int num: nums) {
            if(count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1: -1;
        }

        return candidate;
    }
}











