package com.array;

public class MoveZeros {
    //1不考虑原数组，在多个数组上的话
    //保存非零数字到新数组
    //记录0个数
    //尾部补全0
    public static void moveZeroes(int[] nums) {

        int[] newNum = new int[nums.length];
        int pos = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                newNum[pos] = nums[i];
                pos++;
            } else {
                zeroCount++;
            }
        }

        for (int i = nums.length - 1 - zeroCount; i < nums.length; i++) {
            newNum[i] = 0;
        }
        nums = newNum;
    }


    //将所有非0向左移
    //填充0
    public static void moveZeroes1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }

    }


    public static void moveZeroes2(int[] nums) {
        int leftPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftPos) {
                    nums[leftPos] = nums[i];
                    nums[i] = 0;
                }
                leftPos++;
            }

        }

    }


    //snow ball method
    public static void moveZeroes3(int[] nums) {

        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZeroes3(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(nums[i]);
        }
    }

}
